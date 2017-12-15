package org.trump.vincent.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

/**
 * Created by Vincent on 2017/12/14 0014.
 */

/**
 * Spring-Security configuration
 * @Reference http://www.jianshu.com/p/76bfa6743ba9
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticate) throws Exception {
        authenticate
                // 基于内存用户存储-认证
                .inMemoryAuthentication()
                .withUser("vincent")
                .password("vincent")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN","USER");
    }

    /**
     * configure(WebSecurity) 通过重载，配置Spring Security的Filter链
     * configure(HttpSecurity) 通过重载，配置如何通过拦截器保护请求
     * configure(AuthenticationManagerBuilder) 通过重载，配置user-detail服务
     */

    @Override
    public void configure(AuthenticationManagerBuilder authenticate) throws Exception {
        authenticate
                //基于数据库用户存储的认证
                .jdbcAuthentication().dataSource(dataSource)
                    .usersByUsernameQuery("select userId,password,true from USER where userId=?")
                    .authoritiesByUsernameQuery("select userId,role from user where userId=?")

                    //用户密码加密
                    .passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

    @Override
    public void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeRequests()
                //任何人都可以访问
                .antMatchers("/resources","/css/**","/js/**").permitAll()
                //admin权限访问
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                //持有user权限的用户可以访问
                .antMatchers("/user/**").hasAuthority("ROLE_USER")
                /**
                 * 拥有其中一个权限即可访问
                 * USER = ROLE_USER
                 */
                .antMatchers("/**").hasAnyRole("ADMIN","USER")
                .and()
                /**
                 * 强制安全通道,使匹配的URL请求限制使用 Https 安全协议
                 */
                .requiresChannel()
                    .antMatchers("/config/**").requiresSecure()
                .and()
                /**
                 * Remember_ME 功能，不用每次都输入用户密码
                 */
                .rememberMe()
                    .key("simple-key")
                    .rememberMeParameter("remember_me");
    }

    @Override
    public void configure(WebSecurity webSecurity)throws Exception{

    }


    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password("password").roles("USER").build());
        return manager;
    }
}
