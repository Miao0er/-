/*
 * 登录逻辑相关实现类
 * 2019/07/10
 * 刘硕
 */
package nju.sofware.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nju.sofware.data.dao.UseraccountMapper;
import nju.sofware.data.dataobject.Useraccount;
import nju.sofware.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired  
    private UseraccountMapper useraccountDao; 
	
	public Useraccount valUser(String username,String password) throws Exception{
		boolean valvalue = false;		
		Useraccount useraccount=useraccountDao.selectByPrimaryKey(username);
		if(useraccount.getPassword().equals(password)) {
			return useraccount;
		}else {
			return null;
		}	
	}
}
