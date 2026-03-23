package org.example;

public class CakeDecorator extends StewDecorator{
    CakeDecorator(INordicStew stew){
        super(stew);
    }

    @Override
    public String getDescription(){
        return stew.getDescription() + " + нордская лепешка";
    }

    @Override
    public int getPrice(){
        return stew.getPrice() + 7;
    }
}
