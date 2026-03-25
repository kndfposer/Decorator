package org.example;
public class SnowBerriesDecorator extends OrderDecorator {
    public SnowBerriesDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public String getName() {
        return decoratedOrder.getName() + " + Снежные ягоды";
    }

    @Override
    public int getPrice() {
        return decoratedOrder.getPrice() + 5;
    }
}