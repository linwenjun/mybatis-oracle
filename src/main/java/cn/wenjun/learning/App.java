package cn.wenjun.learning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
@MapperScan("cn.wenjun.learning.dao")
public class App {
    public static void main(String args[]) throws IOException {
        SpringApplication.run(App.class, args);
    }
}
