package com.xp.fight.security.config;

import com.xp.fight.security.pojo.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//1  新建一个config类 继承  WebSecurityConfigurerAdapter
//2  需要添加注解为  @Configuration  @EnableWebSeurity
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;

    //2 重写configure方法
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.formLogin().loginPage("/login").loginProcessingUrl("/login/form").failureUrl("/login-error").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//          auth.inMemoryAuthentication().withUser("admin").password("123456").roles("USER")
//                  .and()
//                  .withUser("test").password("111111").roles("ADMIN");
          //spring secrity 5.0 新增密码方式 ，所以 报错  应该增加
         // There is no PasswordEncoder mapped for the id "null"
//        auth.inMemoryAuthentication().passwordEncoder
//                (new BCryptPasswordEncoder()).withUser("admin").password
//                (new BCryptPasswordEncoder().encode("123456")).roles("USER")
//                .and()
//                .withUser("xupeng").password
//                (new BCryptPasswordEncoder()
//                        .encode("111111")).roles("ADMIN");

        //调用自己构建的密码认证方式
        auth.authenticationProvider(myAuthenticationProvider);
    }
}
