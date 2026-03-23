package org.example;

public class BerriesDecorator extends StewDecorator{
    BerriesDecorator(INordicStew stew){
        super(stew);
    }

    @Override
    public String getDescription(){
        return stew.getDescription() + " + снежные ягоды";
    }

    @Override
    public int getPrice(){
        return stew.getPrice() + 5;
    }
}
