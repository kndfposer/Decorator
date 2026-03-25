package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OrderApp extends JFrame {
    private JCheckBox fireSauceCheck;
    private JCheckBox doubleVenisonCheck;
    private JCheckBox snowBerriesCheck;
    private JCheckBox nordBreadCheck;
    private JTextArea resultArea;

    public OrderApp() {
        setTitle("Оформление заказа");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel checkPanel = new JPanel(new GridLayout(4, 1));
        fireSauceCheck = new JCheckBox("Огненный соус (+10 септимов)");
        doubleVenisonCheck = new JCheckBox("Двойная порция оленины (+20 септимов)");
        snowBerriesCheck = new JCheckBox("Снежные ягоды (+5 септимов)");
        nordBreadCheck = new JCheckBox("Нордская лепешка (+7 септимов)");

        checkPanel.add(fireSauceCheck);
        checkPanel.add(doubleVenisonCheck);
        checkPanel.add(snowBerriesCheck);
        checkPanel.add(nordBreadCheck);

        JButton orderButton = new JButton("Оформить заказ");
        orderButton.addActionListener(e -> placeOrder());

        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(checkPanel, BorderLayout.NORTH);
        add(orderButton, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        ItemListener limitListener = e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int selected = countSelected();
                if (selected > 3) {
                    ((JCheckBox) e.getItem()).setSelected(false);
                    JOptionPane.showMessageDialog(this,
                            "Можно выбрать не более трёх добавок!",
                            "Предупреждение",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        };

        fireSauceCheck.addItemListener(limitListener);
        doubleVenisonCheck.addItemListener(limitListener);
        snowBerriesCheck.addItemListener(limitListener);
        nordBreadCheck.addItemListener(limitListener);
    }

    private int countSelected() {
        int count = 0;
        if (fireSauceCheck.isSelected()) count++;
        if (doubleVenisonCheck.isSelected()) count++;
        if (snowBerriesCheck.isSelected()) count++;
        if (nordBreadCheck.isSelected()) count++;
        return count;
    }

    private void placeOrder() {
        Order order = new NordStew();

        if (fireSauceCheck.isSelected()) {
            order = new FireSauceDecorator(order);
        }
        if (doubleVenisonCheck.isSelected()) {
            order = new DoubleVenisonDecorator(order);
        }
        if (snowBerriesCheck.isSelected()) {
            order = new SnowBerriesDecorator(order);
        }
        if (nordBreadCheck.isSelected()) {
            order = new NordBreadDecorator(order);
        }

        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        String fullName = order.getName();
        int totalPrice = order.getPrice();

        resultArea.setText("Время заказа: " + time + "\n" +
                "Состав заказа: " + fullName + "\n" +
                "Общая цена: " + totalPrice + " септимов");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OrderApp().setVisible(true));
    }
}