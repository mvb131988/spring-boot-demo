package com.example;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebListener
public class SpringContextLoader implements ServletContextListener {

    private static AnnotationConfigApplicationContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Bootstraps Spring with @Configuration class instead of XML
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (context != null) {
            context.close();
        }
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
