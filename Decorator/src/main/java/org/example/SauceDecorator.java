package org.example;

public class SauceDecorator extends StewDecorator{

    SauceDecorator(INordicStew stew){
        super(stew);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " + огненный соус";
    }

    @Override
    public int getPrice(){
        return super.getPrice() + 10;
    }
}
