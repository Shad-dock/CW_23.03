package org.example;

public class BerriesDecorator extends StewDecorator{
    BerriesDecorator(INordicStew stew){
        super(stew);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " + снежные ягоды";
    }

    @Override
    public int getPrice(){
        return super.getPrice() + 5;
    }
}
