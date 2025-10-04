package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<HelloServlet> helloServlet(GreetingService greetingService) {
        return new ServletRegistrationBean<>(new HelloServlet(greetingService), "/hello");
    }
    
}
