package org.example;
public class DoubleVenisonDecorator extends OrderDecorator {
    public DoubleVenisonDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public String getName() {
        return decoratedOrder.getName() + " + Двойная порция оленины";
    }

    @Override
    public int getPrice() {
        return decoratedOrder.getPrice() + 20;
    }
}