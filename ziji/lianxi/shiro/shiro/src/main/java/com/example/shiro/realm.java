package com.example.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class realm extends AuthorizingRealm {
    //鉴权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从AuthenticationToken中获得登录名称
        String loginName = (String) authenticationToken.getPrincipal();
        shujuku shujuku = new shujukuimpl();
        String password = shujuku.loginname(loginName);
        if ("".equals(password)||password==null){
            throw new UnknownAccountException("账户不存在");
        }
        //传递账号和密码
        return new SimpleAuthenticationInfo(loginName,password,getName());
    }
}
