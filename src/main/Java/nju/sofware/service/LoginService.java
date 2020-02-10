/*
 * 登录逻辑相关实现接口
 * 2019/07/10
 * 刘硕
 */
package nju.sofware.service;

import nju.sofware.data.dataobject.Useraccount;

public interface LoginService {
	Useraccount valUser(String username,String password) throws Exception;
}
