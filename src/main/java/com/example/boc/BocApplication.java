package com.example.boc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com/example/boc/model")
public class BocApplication {

    public static void main(String[] args) {
        SpringApplication.run(BocApplication.class, args);
    }

}
