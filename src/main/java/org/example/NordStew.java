package org.example;
public class NordStew implements Order {
    @Override
    public String getName() {
        return "Нордское рагу";
    }

    @Override
    public int getPrice() {
        return 20;
    }
}