package com.example.demo.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class H2databaseConfig {
    @Bean(initMethod = "start", destroyMethod = "stop")
    public org.h2.tools.Server inMemoryH2DatabaseaServer() throws SQLException {
        return org.h2.tools.Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }
}
