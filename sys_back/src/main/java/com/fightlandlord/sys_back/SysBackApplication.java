package com.fightlandlord.sys_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan(basePackages = "com.fightlandlord.sys_back.dao")
public class SysBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysBackApplication.class, args);
    }

}
