package study.qi.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.qi.shiro.realms.CustomerRealm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 用来整合 shiro 框架相关配置类
 * @Author qi
 * @Date 2020/8/22 10:37
 * @ClassName ShiroConfig
 **/

@Configuration
public class ShiroConfig {

    // 1. 创建 ShiroFilter，负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 给 filter 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        // 配置系统受限资源
        Map<String, String> map = new HashMap<>();
        // authc 是过滤器的一种 表示：请求这个资源需要认证和授权
        map.put("/index.jsp", "authc");

        /**
         * 设置默认认证界面路径，如果不设置，在没有认证的情况下，则会自动返回 login.jsp 页面
         */
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);


        return shiroFilterFactoryBean;
    }
    // 2. 创建安全管理器，在 Web 环境下，需要使用 WebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

        // 给安全管理器设置 realm
        defaultWebSecurityManager.setRealm(realm);

        return defaultWebSecurityManager;
    }

    // 3. 创建自定义 realm
    @Bean
    public Realm getRealm() {
        // 使用自定义的 realm
        CustomerRealm customerRealm = new CustomerRealm();
        return customerRealm;
    }
}
