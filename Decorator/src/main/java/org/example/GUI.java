package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JCheckBox sauceCheck;
    private JCheckBox venisonCheck;
    private JCheckBox berriesCheck;
    private JCheckBox cakeCheck;
    private JTextArea orderListArea;
    private ArrayList<Order> orderArrList;
    private INordicStew currentStew;
    private JLabel label;

    GUI(){
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        start();
        updTotal();
    }

    private void start(){
        orderArrList = new ArrayList<>();
        JPanel checkPanel = new JPanel();
        checkPanel.setLayout(new GridLayout(4, 1, 10, 10));

        sauceCheck = new JCheckBox("Огненный соус(+10 септимов)");
        venisonCheck = new JCheckBox("Двойная порция оленины(+20 септимов)");
        berriesCheck = new JCheckBox("Снежные ягоды(+5 септимов)");
        cakeCheck = new JCheckBox("Нордская лепешка(+7 септимов)");

        sauceCheck.addActionListener(e -> checkLimit());
        venisonCheck.addActionListener(e -> checkLimit());
        berriesCheck.addActionListener(e -> checkLimit());
        cakeCheck.addActionListener(e -> checkLimit());

        checkPanel.add(sauceCheck);
        checkPanel.add(venisonCheck);
        checkPanel.add(berriesCheck);
        checkPanel.add(cakeCheck);

        JButton orderButton = new JButton("Оформить заказ");
        orderButton.addActionListener(e -> makeOrder());

        orderListArea = new JTextArea("Список заказов");
        orderListArea.setEditable(false);
        JScrollPane scP = new JScrollPane(orderListArea);

        label = new JLabel("Цена: 50 септимов");
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(checkPanel, BorderLayout.NORTH);
        panel1.add(label, BorderLayout.SOUTH);

        add(panel1, BorderLayout.WEST);
        add(scP, BorderLayout.EAST);
        add(orderButton, BorderLayout.SOUTH);

        sauceCheck.addActionListener(e -> updTotal());
        venisonCheck.addActionListener(e -> updTotal());
        berriesCheck.addActionListener(e -> updTotal());
        cakeCheck.addActionListener(e -> updTotal());
    }

    private int getSelectedCount(){
       return (sauceCheck.isSelected()? 1: 0) +
               (venisonCheck.isSelected()? 1: 0)  +
               (berriesCheck.isSelected()? 1: 0 ) +
               (cakeCheck.isSelected()? 1: 0);
    }

    private void checkLimit(){
        int count = getSelectedCount();
        if (count >= 3){
            achtung();
        }else {
            norm();
        }
    }

    private void achtung(){
        sauceCheck.setEnabled(sauceCheck.isSelected());
        venisonCheck.setEnabled(venisonCheck.isSelected());
        berriesCheck.setEnabled(berriesCheck.isSelected());
        cakeCheck.setEnabled(cakeCheck.isSelected());
    }

    private void norm(){
        sauceCheck.setEnabled(true);
        venisonCheck.setEnabled(true);
        berriesCheck.setEnabled(true);
        cakeCheck.setEnabled(true);
    }

    private void updTotal(){
        currentStew = new BasicNordicStew();
        currentStew = sauceCheck.isSelected()? new SauceDecorator(currentStew) :  currentStew;
        currentStew = venisonCheck.isSelected()? new VenisonDecorator(currentStew) :  currentStew;
        currentStew = berriesCheck.isSelected()? new BerriesDecorator(currentStew) :  currentStew;
        currentStew = cakeCheck.isSelected()? new CakeDecorator(currentStew) :  currentStew;

        label.setText("Итого: " + currentStew.getPrice() + " септимов");
    }

    private void makeOrder(){
//        int count = getSelectedCount();
//        if(count > 3){
//            JOptionPane.showMessageDialog(this,
//                    "Нельзя выбрать больше 3х добавок",
//                    "Ошибка",
//                    JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        Order order = new Order(currentStew);
        orderArrList.add(order);

        updOrder();
        sauceCheck.setSelected(false);
        venisonCheck.setSelected(false);
        berriesCheck.setSelected(false);
        cakeCheck.setSelected(false);
        norm();
        updTotal();
    }

    private void updOrder(){
        StringBuilder sb = new StringBuilder();
        for(Order order : orderArrList){
            sb.append(order.toString()).append("\n");
        }
        orderListArea.setText(sb.toString());
    }

}
