package com.liulei.back.sao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.liulei.back.sao.mapper")
//@EnableDiscoveryClient
public class SaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaoApplication.class, args);
    }

}
