package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.db.MockController;

@SpringBootApplication // enables component scanning, autoconfig, and configuration support
public class MainApp {

    public static void main(String[] args) throws Exception {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        @SuppressWarnings("unused")
        ConfigurableApplicationContext context = SpringApplication.run(MainApp.class, args);
        MockController controller = context.getBean(MockController.class);
        controller.process();
        
        for (;;) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
