package org.example;

public class FireSauceDecorator extends OrderDecorator {
    public FireSauceDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public String getName() {
        return decoratedOrder.getName() + " + Огненный соус";
    }

    @Override
    public int getPrice() {
        return decoratedOrder.getPrice() + 10;
    }
}
