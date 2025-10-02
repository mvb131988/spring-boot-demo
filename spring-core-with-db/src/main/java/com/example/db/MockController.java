package com.example.db;

import org.springframework.stereotype.Component;

@Component
public class MockController {

    private final ServiceA serviceA;

    public MockController(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
    
    public void process() throws Exception {
        serviceA.process();
    }
    
}
