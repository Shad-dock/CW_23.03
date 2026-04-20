package org.example;

public class CakeDecorator extends StewDecorator{
    CakeDecorator(INordicStew stew){
        super(stew);
    }

    @Override
    public String getDescription(){
        return getStew().getDescription() + " + нордская лепешка";
    }

    @Override
    public int getPrice(){
        return getStew().getPrice() + 7;
    }
}
