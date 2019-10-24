package com.xp.fight.security.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**8
 * 返回权限验证的接口
 */
public interface RbacService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
