package cn.whu.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author snow
 * @className Application
 * @date 2021/6/27
 **/
@SpringBootApplication
@MapperScan(basePackages = "cn.whu.trade.mapper")
@ComponentScan(basePackages = {"cn.whu"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}