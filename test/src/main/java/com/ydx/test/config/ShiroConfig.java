package com.ydx.test.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean createFilter(DefaultWebSecurityManager sm) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(sm);
        bean.setLoginUrl("index.html");

        //无权访问页面
        bean.setUnauthorizedUrl("/noqx.html");
        Map<String,String> urls = new HashMap<>();

        //必须登录并且角色为国家主席才能访问showAllRoles
        urls.put("/showAllRoles","authc,roles[国家主席]");

        //必须登录且持有系统管理权限才能访问main.html
        urls.put("/main.html","authc,perms[系统管理]");

        bean.setFilterChainDefinitionMap(urls);
        return bean;
    }

    @Bean
    public DefaultWebSecurityManager createSM(JdbcRealm realm) {
        DefaultWebSecurityManager sm = new DefaultWebSecurityManager();
        sm.setRealm(realm);
        return sm;
    }
    @Bean
    public JdbcRealm createRealm(DruidDataSource ds) {
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(ds);
        realm.setPermissionsLookupEnabled(true);

        //通过用户名查找密码。匹配成功的话说明登录成功
        realm.setAuthenticationQuery("select password from users where username=?");

        //通过用户名来查找用户对应的角色名称
        realm.setUserRolesQuery("select r.name from role r left join user_role uu on r.id=uu.rid left join users us on uu.uid=us.id where us.username=?");

        //通过用户的角色名称  来查找角色对应的可访问资源
        realm.setPermissionsQuery("select r.text from resource r left join ranges rr on r.id=rr.resid left join role ro on rr.rolid=ro.id where ro.name=?");
        return realm;
    }



    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource createDS() {
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }
}
