package study.qi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import study.qi.bean.Person;

@SpringBootTest
class Springboot02ConfigApplicationTests {

    // 测试Person是否从配置文件yml中获取到值
    @Autowired
    Person person;

    // 测试容器中是否包含bean
    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        System.out.println(person);
        System.out.println(ioc.containsBean("helloService"));
    }

}