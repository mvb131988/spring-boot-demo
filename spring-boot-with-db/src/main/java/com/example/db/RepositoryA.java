package com.example.db;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class RepositoryA {

    private final DataSource dataSource;

    @PostConstruct
    void check() {
        System.out.println("DataSource bean is " + dataSource.getClass().getName());
    }
    
    public RepositoryA(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void testConnection() throws Exception {
        try (var conn = dataSource.getConnection()) {
            System.out.println("Connected to: " + conn.getMetaData().getURL());
        }
    }
    
}
