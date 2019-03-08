package com.xp.fight.security.pojo;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        if(userName.equals("admin")){

            UserInfo  userInfo  = new
                    UserInfo("admin","111111","ROLE_ADMIN",
                    true,true,true ,true);
            return  userInfo;
        }


        return null;
    }
}
