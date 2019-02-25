package com.practice.ssm.shiro;

import com.practice.ssm.model.User;
import com.practice.ssm.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-02-19 14:15
 *
 *  该类realm定义的作用是为了将 shiro的ini文件替换掉
 */
public class MyRealm extends AuthorizingRealm {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * shiro授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * shiro认证方法
     * @param token  该token令牌是从controller层传递过来的
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();//获取用户名
        String password = token.getCredentials().toString();//获取用户密码

        User user = this.userService.queryUserByName(username);

        ByteSource salt = ByteSource.Util.bytes(username);

        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), salt, this.getName());

        return authenticationInfo;
    }
}
