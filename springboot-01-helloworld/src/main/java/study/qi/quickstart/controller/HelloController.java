package study.qi.quickstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author qi
 * @Date 2020/7/7 12:47
 * @ClassName HelloController
 **/

// 这个类的所有方法返回的数据直接写给浏览器（如果是对象，转为json数据
/*@ResponseBody
@Controller*/
// 这个注解是上面两个注解的合体
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }
}
