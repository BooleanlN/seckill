package cn.whu.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author snow
 * @className Swagger2Config
 * @date 2021/6/29
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> userPredicate = RequestHandlerSelectors.basePackage("cn.whu.user.controller");
        Predicate<RequestHandler> goodPredicate = RequestHandlerSelectors.basePackage("cn.whu.good.controller");
        Predicate<RequestHandler> tradePredicate = RequestHandlerSelectors.basePackage("cn.whu.trade.controller");

        return new Docket(DocumentationType.SWAGGER_2)  // 指定api类型为swagger2
                .apiInfo(apiInfo())                 // 用于定义api文档汇总信息
                .select()
                .apis(Predicates.or(userPredicate, goodPredicate,tradePredicate))
//                .apis(Predicates.or(adminPredicate, articlePredicate, userPredicate, filesPredicate))
                .paths(PathSelectors.any())         // 所有controller
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商场项目Api")                       // 文档页标题
                .contact(new Contact("whu",
                        "https://www.whu.cn",
                        "boolean@top.com"))                   // 联系人信息
                .description("商场项目Api")      // 详细信息
                .version("1.0.1")                               // 文档版本号
                .termsOfServiceUrl("https://www.whu.cn")     // 网站地址
                .build();
    }
}
