package cn.whu.good;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author jiayi
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.whu.good.mapper")
@ComponentScan(basePackages = {"cn.whu","org.n3r.idworker"})
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}