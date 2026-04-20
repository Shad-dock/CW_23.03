package org.example;

public class BerriesDecorator extends StewDecorator{
    BerriesDecorator(INordicStew stew){
        super(stew);
    }

    @Override
    public String getDescription(){
        return getStew().getDescription() + " + снежные ягоды";
    }

    @Override
    public int getPrice(){
        return getStew().getPrice() + 5;
    }
}
