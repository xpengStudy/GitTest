package com.xp.fight.security.service.impl;

import com.xp.fight.security.service.RbacService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/*****
 * 权限验证接口
 */

@Service("rbacService")
public class RbacServiceImpl implements RbacService {

    private AntPathMatcher antPathMatcher =  new AntPathMatcher();


    /***
     * 判断当前用户是否有权限能访问相应的URL
     * @param request
     * @param authentication
     * @return
     */
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        Object  principal = authentication.getPrincipal();
        boolean hasPerMission =  false;
        if(principal instanceof UserDetails){//判断当前用户是否是我们的UserDetails对象

            String userName =  ((UserDetails) principal).getUsername();
            Set<String> urls =  new HashSet<>();//这里应该在数据库读取用户所拥有的所有URL
            //手动设置当前用户所拥有访问 URL的权限
            urls.add("/whoim");

            for(String url:urls){
                //这里不能用 equal 来判断 ,因为URL是由参数的,所以要用 AntPathMatcher 来判断
                if(antPathMatcher.match(url,request.getRequestURI())){
                    hasPerMission = true;
                    break;
                }

            }
        }

        return hasPerMission;
    }
}
