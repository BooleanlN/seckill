package cn.whu.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author snow
 * @className Application
 * @date 2021/6/28
 **/
@SpringBootApplication
@MapperScan(basePackages = "cn.whu.business.mapper")
@ComponentScan(basePackages = {"cn.whu","org.n3r.idworker"})
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
