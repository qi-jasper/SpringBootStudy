package study.qi.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Description
 * @Author qi
 * @Date 2020/7/18 22:41
 * @ClassName SwaggerConfig
 **/

@Configuration
@EnableSwagger2     // 开启Swagger2
public class SwaggerConfig {

    // 通过Docket配置Swagger的Bean实例
    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev");

        // 通过environment.acceptsProfiles判断是否处在自己设定的环境中，现在可以直接使用注解@Profiles("dev")
        boolean b = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 关闭Swagger
//                .enable(false)
                .select()
                /**
                 * RequestHandlerSelectors：配置要扫描接口的方式
                 *      basePackage：配置要扫描的包；
                 *      any：扫描全部；
                 *      none：不扫描；
                 *      withClassAnnotation：扫描类上的注解；
                 *      withMethodAnnotation：扫描方法上的注解
                 */
                .apis(RequestHandlerSelectors.basePackage("study.qi.swagger.controller"))
                // paths():过滤什么路径
//                .paths(PathSelectors.ant("/qi/*"))
                .build();
    }

    // 配置Swagger信息的apiInfo
    public ApiInfo apiInfo() {
        // author info
        Contact contact = new Contact("qi", "we", "we");

        return new ApiInfo(
                "qi Documentation",
                "Api Documentation",
                "1.0", "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}