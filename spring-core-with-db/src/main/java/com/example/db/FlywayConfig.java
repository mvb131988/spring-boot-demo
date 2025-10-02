package com.example.db;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class FlywayConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/mydb");
        config.setUsername("myuser");
        config.setPassword("mypass");
        config.setDriverClassName("org.postgresql.Driver");
        return new HikariDataSource(config);
    }
    
    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource) // reuse your Spring-managed DataSource
                .locations("classpath:db/migration") // default location
                .baselineOnMigrate(true) // if integrating into existing DB
                .load();
    }
    
}
