package study.qi.swagger.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

/**
 * @Description
 * @Author qi
 * @Date 2020/7/19 13:23
 * @ClassName User
 **/

@ApiModel("用户实体类")
public class User {
    String name;
    String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
