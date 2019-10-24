package com.xp.fight.security.service;

import com.fasterxml.jackson.databind.node.BooleanNode;
import com.xp.fight.security.pojo.UserInfo;
import com.xp.fight.security.service.LdapPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private LdapPersonService ldapPersonService;

    /***
     * 验证用户名密码是否能通过验证
     * @param userName
     * @param password
     * @return
     */
    public Boolean isAuth(String userName,String password){
        return  ldapPersonService.isAuthed(userName,password);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {



        //使用ldap查询当前人员
        Map<String,Object>  userMap =  ldapPersonService.getNameByUser(userName);
        UserInfo LdapUerInfo = new UserInfo(userMap.get("username").toString(),userMap.get("password").toString(),"ROLE_ADMIN",
                true,true,true ,true);
        return LdapUerInfo;

//        if(userName.equals("admin")){
//
//            UserInfo  userInfo  = new
//                    UserInfo("admin","111111","ROLE_ADMIN",
//                    true,true,true ,true);
//            return  userInfo;
//        }else if("test".equals(userName)){
//            UserInfo userInfo = new
//                    UserInfo("test","111111","ROLE_ADMIN",
//                    true,true,true,true);
//            return userInfo;
//        }else{
//            return null;
//        }

        //panduan


    }

    /****
     * 根据用户名密码 构建用户 Userinfo
     * @param userName
     * @param password
     * @return
     */
    UserInfo  getUserInfo(String userName,String password){
       return new UserInfo(userName,password,"ROLE_ADMIN",
                true,true,true ,true);
    }
}
