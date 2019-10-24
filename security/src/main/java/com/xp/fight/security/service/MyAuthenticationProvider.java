package com.xp.fight.security.service;

import com.xp.fight.security.pojo.UserInfo;
import com.xp.fight.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MyAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    MyUserDetailsService myUserDetailsService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String  name  = authentication.getName();
        String  password =  (String)authentication.getCredentials();//表单中输入的密码
        Boolean flag =  myUserDetailsService.isAuth(name,password);
        // 当用户名密码输入正确
        if(flag){
            //构建来判断用户名和密码是否正确
//            UserInfo userInfo = (UserInfo) myUserDetailsService.loadUserByUsername(name);//调用自己获取用户的方法
//            if(null==userInfo){
//                throw  new BadCredentialsException("用户不存在");
//            }
            // //这里我们还要判断密码是否正确，实际应用中，我们的密码一般都会加密，以Md5加密为例
            // Md5PasswordEncoder md5PasswordEncoder=new Md5PasswordEncoder();
            // //这里第个参数，是salt
            // 就是加点盐的意思，这样的好处就是用户的密码如果都是123456，由于盐的不同，密码也是不一样的，就不用怕相同密码泄漏之后，不会批量被破解。
            // String encodePwd=md5PasswordEncoder.encodePassword(password, userName);
            // //这里判断密码正确与否
            // if(!userInfo.getPassword().equals(encodePwd))
            // {
            // throw new BadCredentialsException("密码不正确");
            // }
            // //这里还可以加一些其他信息的判断，比如用户账号已停用等判断，这里为了方便我接下去的判断，我就不用加密了。
            //
            //
//            if (!userInfo.getPassword().equals(password)) {
//                throw new BadCredentialsException("密码不正确");
//            }

            UserInfo  userInfo = myUserDetailsService.getUserInfo(name,password);

            Collection<?extends GrantedAuthority> authorities = userInfo.getAuthorities();

            //构建用户登录成功的token
            return  new UsernamePasswordAuthenticationToken(userInfo,password,authorities);
        }else{
            return null;
        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
