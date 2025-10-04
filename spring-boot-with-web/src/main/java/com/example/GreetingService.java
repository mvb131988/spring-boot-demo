package com.example;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {
    public String getMessage() {
        return "Hello from Spring Core with JavaConfig abc!";
    }
}
