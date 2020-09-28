package study.qi.swagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.qi.swagger.pojo.User;

/**
 * @Description
 * @Author qi
 * @Date 2020/7/18 10:26
 * @ClassName HelloController
 **/

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // 只要我们的接口中，返回值中存在实体类，它就会被扫描到Swagger中
    @PostMapping("user")
    public User user() {
        return new User();
    }
}
