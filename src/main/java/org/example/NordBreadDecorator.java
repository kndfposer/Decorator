package org.example;

public class NordBreadDecorator extends OrderDecorator {
    public NordBreadDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public String getName() {
        return super.getName() + " + Нордская лепешка";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 7;
    }
}