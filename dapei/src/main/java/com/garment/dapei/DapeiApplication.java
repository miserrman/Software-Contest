package com.garment.dapei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.garment.dapei.dao")
public class DapeiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DapeiApplication.class, args);
    }

}
