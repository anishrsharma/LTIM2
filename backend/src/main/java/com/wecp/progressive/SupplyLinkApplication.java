package com.wecp.progressive;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SupplyLinkApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to SupplyLink Project!");
        SpringApplication.run(SupplyLinkApplication.class, args);
    }
}
