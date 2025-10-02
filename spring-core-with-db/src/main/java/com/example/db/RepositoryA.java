package com.example.db;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryA {

    private final DataSource dataSource;

    public RepositoryA(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void testConnection() throws Exception {
        try (var conn = dataSource.getConnection()) {
            System.out.println("Connected to: " + conn.getMetaData().getURL());
        }
    }
    
}
