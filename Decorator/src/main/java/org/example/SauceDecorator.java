package org.example;

public class SauceDecorator extends StewDecorator{

    SauceDecorator(INordicStew stew){
        super(stew);
    }

    @Override
    public String getDescription(){
        return stew.getDescription() + " + огненный соус";
    }

    @Override
    public int getPrice(){
        return stew.getPrice() + 10;
    }
}
