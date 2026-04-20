package org.example;

public class SauceDecorator extends StewDecorator{

    SauceDecorator(INordicStew stew){
        super(stew);
    }

    @Override
    public String getDescription(){
        return getStew().getDescription() + " + огненный соус";
    }

    @Override
    public int getPrice(){
        return getStew().getPrice() + 10;
    }
}
