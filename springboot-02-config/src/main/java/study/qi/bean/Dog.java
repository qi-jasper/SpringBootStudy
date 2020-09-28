package study.qi.bean;

/**
 * @Description
 * @Author qi
 * @Date 2020/7/7 14:58
 * @ClassName Dog
 **/

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author qi
 * @Date 2020/7/7 14:13
 * @ClassName Dog
 **/

@Component
public class Dog {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
