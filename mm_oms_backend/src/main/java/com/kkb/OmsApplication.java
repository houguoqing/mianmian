package com.kkb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //使用事务管理器
@SpringBootApplication
@MapperScan("com.kkb.mapper")
public class OmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(OmsApplication.class);
    }
}
