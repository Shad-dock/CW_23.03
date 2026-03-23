package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private LocalDateTime time;
    private String description;
    private int price;

    Order(INordicStew stew){
        this.time = LocalDateTime.now();
        this.description = stew.getDescription();
        this.price = stew.getPrice();
    }

    public String getDescription(){
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "В " + getNormTime() + " заказали блюдо: " + description + ". Итоговая стоимость: " + price + " септимов.";
    }
    private String getNormTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }
}
