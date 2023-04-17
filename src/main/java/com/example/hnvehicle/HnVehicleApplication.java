package com.example.hnvehicle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan("com.example.hnvehicle.mapper")
public class HnVehicleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HnVehicleApplication.class, args);
    }

}
