package com.example.hw_29_logging.coffee.order;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class Order implements Comparable<Order> {

    private int id;
    private String name;

    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.id, o.getId());
    }

    @Override
    public String toString() {
        String format = "%5s | %s";
        return String.format(format, id, name);
    }
}
