package com.xp.fight.security.config;

import com.xp.fight.security.service.MyAuthenticationProvider;
import com.xp.fight.security.service.MyAuthenticationFailHander;
import com.xp.fight.security.service.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/***
 *  构建 SpringSecurity 的配置类,可以使用两种方法
 *  一, 使用注解  @Configuration 和 @EnableWebSecurity  注解 WebSecurityConfigurer 类型的类
 *  二, 使用注解  @EnableWebSecurity  注解 继承 WebSecurityConfigurerAdapter 的类
 *
 *  我们一般使用第二种,因为第二种方式提供了一种更便利的方式去创建 WebSecurityConfigurer 的实例,
 *  我们使用的时候只需要 重写 WebSecurityConfigurerAdapter 的方法,即可以配置拦截URL.设置权限等功能
 */
//1  新建一个config类 继承  WebSecurityConfigurerAdapter
//2  需要添加注解为  @Configuration  @EnableWebSeurity
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;

    //添加失败或者是成功之后调用的方法
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailHander    myAuthenticationFailHander;

    //2 重写configure方法
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
                .formLogin().loginPage("/login").loginProcessingUrl("/login/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailHander)
                .permitAll()//表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
                .and()
                .authorizeRequests()
                .antMatchers("/testPostHttp").permitAll()
                .antMatchers("/index").permitAll()//这就表示 /index 这个页面不需要权限验证,谁都可以访问
                .antMatchers("/whoim").hasRole("ADMIN")//表示只有ADMIN这个角色可以访问

//                .anyRequest().authenticated()//经过认证才可以访问
                //  @rbacService 其实就是我们自己声明的bean
                .anyRequest().access("@rbacService.hasPermission(request,authentication)")//经过认证才可以访问
                .and()
                .csrf().disable();  // csrf

//        antMatchers 这里也可以限定HttpMethod的不同要求不同的权限（用于适用于Restful风格的API).
//
//        如：Post需要 管理员权限，get 需要user权限，我们可以这么个改造，
//        同时也可以通过通配符来是实现 如：/user/1 这种带参数的URL

//        .antMatchers("/whoim").hasRole("ADMIN")
//
//                .antMatchers(HttpMethod.POST,"/user/*").hasRole("ADMIN")
//
//                .antMatchers(HttpMethod.GET,"/user/*").hasRole("USER")


    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        //将密码写死的操作
////        super.configure(auth);
////          auth.inMemoryAuthentication().withUser("admin").password("123456").roles("USER")
////                  .and()
////                  .withUser("test").password("111111").roles("ADMIN");
//          //spring secrity 5.0 新增密码方式 ，所以 报错  应该增加
//         // There is no PasswordEncoder mapped for the id "null"
////        auth.inMemoryAuthentication().passwordEncoder
////                (new BCryptPasswordEncoder()).withUser("admin").password
////                (new BCryptPasswordEncoder().encode("123456")).roles("USER")
////                .and()
////                .withUser("xupeng").password
////                (new BCryptPasswordEncoder()
////                        .encode("111111")).roles("ADMIN");
//
//        //调用自己构建的密码认证方式
//        auth.authenticationProvider(myAuthenticationProvider);
//    }
}
