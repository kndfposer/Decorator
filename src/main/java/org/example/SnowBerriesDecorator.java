package org.example;

public class SnowBerriesDecorator extends OrderDecorator {
    public SnowBerriesDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public String getName() {
        return super.getName() + " + Снежные ягоды";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 5;
    }
}