package com.example.db;


import org.springframework.stereotype.Service;

@Service
public class ServiceA {

    private final RepositoryA repositoryA;

    public ServiceA(RepositoryA repositoryA) {
        this.repositoryA = repositoryA;
    }
    
    public void process() throws Exception {
        repositoryA.testConnection();
    }
    
}
