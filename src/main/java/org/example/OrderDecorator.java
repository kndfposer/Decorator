package org.example;

public abstract class OrderDecorator implements Order {
    private final Order decoratedOrder;

    public OrderDecorator(Order decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public String getName() {
        return decoratedOrder.getName();
    }

    @Override
    public int getPrice() {
        return decoratedOrder.getPrice();
    }
}