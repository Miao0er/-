/*
 * �û���Ϣ�߼���ؽӿ�
 * 2019/07/10
 * ��˶
 */
package nju.sofware.service;

import java.util.List;

import nju.sofware.data.dataobject.Useraccount;
import nju.sofware.data.dataobject.Userinfo;
import nju.sofware.service.model.UserAccountModel;

public interface UserService {
	boolean addUserinfo(Userinfo userinfo)throws Exception;
	List<Userinfo> getUserinfos()throws Exception;
	boolean deleteUserinfo(Integer infoid)throws Exception;
	boolean updateUserinfo(Userinfo userinfo)throws Exception;
	Useraccount getUseraccount(String username)throws Exception;
	boolean updateUseraccount(Useraccount useraccount)throws Exception;
	boolean updateUseraccount(UserAccountModel useraccountmodel,String username)throws Exception;
}
