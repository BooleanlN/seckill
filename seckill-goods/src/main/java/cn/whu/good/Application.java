package cn.whu.good;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jiayi
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.whu.good.mapper")
@ComponentScan(basePackages = {"cn.whu"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}