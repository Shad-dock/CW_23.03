package org.example;

public class CakeDecorator extends StewDecorator{
    CakeDecorator(INordicStew stew){
        super(stew);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " + нордская лепешка";
    }

    @Override
    public int getPrice(){
        return super.getPrice() + 7;
    }
}
