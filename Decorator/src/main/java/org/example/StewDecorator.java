package org.example;

public abstract class StewDecorator implements INordicStew{
    private INordicStew stew;
    public StewDecorator(INordicStew stew){
        this.stew = stew;
    }

    @Override
    public String getDescription(){
        return stew.getDescription();
    }

    @Override
    public int getPrice(){
        return stew.getPrice();
    }

}
