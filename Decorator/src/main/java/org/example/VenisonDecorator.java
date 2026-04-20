package org.example;

public class VenisonDecorator extends StewDecorator{
    VenisonDecorator(INordicStew stew){
        super(stew);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " + двойная порция оленины";
    }

    @Override
    public int getPrice(){
        return super.getPrice() + 20;
    }
}
