package org.example;

public class DoubleVenisonDecorator extends OrderDecorator {
    public DoubleVenisonDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public String getName() {
        return super.getName() + " + Двойная порция оленины";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 20;
    }
}