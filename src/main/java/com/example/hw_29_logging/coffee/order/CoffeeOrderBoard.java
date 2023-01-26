package com.example.hw_29_logging.coffee.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.TreeSet;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoffeeOrderBoard {

    private int number;
    private final TreeSet<Order> orders;

    public void add(String name) {
        logStart();

        number++;
        Order order = new Order();
        order.setId(number);
        order.setName(name);
        orders.add(order);
        logOrder("ORDER ADDED", order);
    }

    public Order deliver() {
        logStart();

        Order order = orders.pollLast();
        if (order == null) {
            log.error("ORDER BOARD IS EMPTY");
        } else {
            logOrder("ORDER DELIVERED", order);
        }
        return order;
    }

    public Order deliver(int number) {
        logStart();

        Order orderByNum = null;
        try {
            orderByNum = orders.stream()
                    .filter(order -> order.getId() == number)
                    .findFirst().orElseThrow(NoSuchElementException::new);
            orders.remove(orderByNum);
            logOrder("ORDER DELIVERED", orderByNum);
        } catch (NoSuchElementException e) {
            log.error("NO ORDERS WITH NUMBER=" + number + " IN BOARD");
        }
        return orderByNum;
    }

    public void draw() {
        logStart();

        if (orders.isEmpty()) {
            log.error("ORDER BOARD IS EMPTY");
        } else {
            log.info("=====================");
            log.info(String.format("%5s | %s", "NUM", "NAME"));
            orders.forEach(order -> log.info("{}", order));
            log.info("=====================");
        }
    }

    private void logOrder(String message, Order order) {
        MDC.put("num", Integer.toString(order.getId()));
        MDC.put("name", order.getName());
        log.info(message);
        MDC.clear();
    }

    private void logStart() {
        log.info("METHOD {{}} STARTED...", Thread.currentThread().getStackTrace()[2].getMethodName());
    }
}
