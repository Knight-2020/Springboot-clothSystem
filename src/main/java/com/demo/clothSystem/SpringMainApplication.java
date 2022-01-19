package com.demo.clothSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@MapperScan("com.demo.clothSystem.mapper")
@EnableTransactionManagement
@EnableCaching(proxyTargetClass = true)
public class SpringMainApplication {
    //通过反射加载SpringMainApplication类对象启动服务
    public static void main(String[] args) {
        SpringApplication.run(SpringMainApplication.class, args);
    }
}
