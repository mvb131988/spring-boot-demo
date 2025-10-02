package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.db.MockController;

public class MainApp {
    
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MockController controller = context.getBean(MockController.class);
        controller.process();
        
        for(;;) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}