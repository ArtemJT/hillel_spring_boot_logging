package com.example.hw_29_logging;

import com.example.hw_29_logging.coffee.order.CoffeeOrderBoard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class Hw29LoggingApplication {

    private final CoffeeOrderBoard coffeeOrderBoard;
    private final Random random;
    private final List<String> names = List.of("Alen", "Yoda", "Obi-van", "John Snow", "Jack Sparrow",
            "Peter Parker", "Bobby", "Helen", "Milagros", "Anna", "Valentina", "Black Widow", "Super-girl");

    public static void main(String[] args) {
        SpringApplication.run(Hw29LoggingApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        addNewOrders();

        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver(4);
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver();

        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver(2);
        coffeeOrderBoard.deliver(3);
        coffeeOrderBoard.deliver(2233);
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver();

        coffeeOrderBoard.draw();

        addNewOrders();

        coffeeOrderBoard.draw();
    }

    private void addNewOrders() {
        for (int i = 0; i < 10; i++) {
            int nextInt = random.nextInt(names.size());
            coffeeOrderBoard.add(names.get(nextInt));
        }
    }
}
