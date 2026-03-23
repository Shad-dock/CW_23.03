package org.example;

public class BasicNordicStew implements INordicStew{
    @Override
    public  String getDescription(){
        return "Нордское рагу";
    }

    @Override
    public int getPrice(){
        return 50;
    }
}
