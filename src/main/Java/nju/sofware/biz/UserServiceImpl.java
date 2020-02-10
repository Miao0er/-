/*
 * 用户信息逻辑相关实现类
 * 2019/07/10
 * 刘硕
 */
package nju.sofware.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nju.sofware.data.dao.TeamMemberMapper;
import nju.sofware.data.dao.UseraccountMapper;
import nju.sofware.data.dao.UserinfoMapper;
import nju.sofware.data.dataobject.TeamMember;
import nju.sofware.data.dataobject.Useraccount;
import nju.sofware.data.dataobject.Userinfo;
import nju.sofware.service.UserService;
import nju.sofware.service.model.UserAccountModel;
import nju.sofware.service.model.UserAccountandInfo;

/*
 * 用户逻辑层,包括用户账户，以及角色信息的修改
 * 2019/07/10
 * 刘硕
 */
@Service
public class UserServiceImpl implements UserService{
	/*@Autowired  
    private UseraccountMapper useraccountDao;*/
	@Autowired  
    private UserinfoMapper userinfoDao; 
	@Autowired  
    private UseraccountMapper useraccountDao;
	@Autowired  
    private TeamMemberMapper teamMemberDao;

	/*组合插入用户数据*/
	/*public boolean addUser(UserAccountandInfo userinfo)throws Exception{
		Useraccount accountobject=userinfo.toaccount();
		Userinfo infoobject=userinfo.toinfo();
		if(useraccountDao.insert(accountobject)>=1&&userinfoDao.insert(infoobject)>=1) {
			return true;
		}else {
			return false;
		}
	}*/
	
	/*插入用户信息*/
	/*
	 * 这里出现了严重的设计缺陷，一开始没有注意到团队信息应该自动生成
	 * 2019/7/10
	 * 刘硕
	 */
	public boolean addUserinfo(Userinfo userinfo)throws Exception{
		if(userinfoDao.insert(userinfo)>=1) {
			TeamMemberServiceImpl falseImpl=new TeamMemberServiceImpl();
			Useraccount useraccount=useraccountDao.selectByPrimaryKey(userinfo.getUsername());
			TeamMember teammember=new TeamMember();
			teammember.setId(userinfo.getId());
			teammember.setUsername(userinfo.getUsername());
			teammember.setName(userinfo.getName());
			if(useraccount.getPhone()!=null) {
			teammember.setPhone(useraccount.getPhone().toString());
			}
			teammember.setEmail(useraccount.getEmail());
			teamMemberDao.insert(teammember);
			return true;
		}
		return false;
	}
	
	/*
	 * 查找所有用户信息
	 * 2019/07/10
	 */
	public List<Userinfo> getUserinfos()throws Exception{
		List<Userinfo> userinfos=userinfoDao.selectAll();
		return userinfos;
	}
	
	/*
	 * 更新用户信息
	 * 2019/07/10
	 */
	public boolean updateUserinfo(Userinfo userinfo)throws Exception{
		if(userinfoDao.updateByPrimaryKey(userinfo)>=1){
			return true;
		}
		return false;
	}
	
	/*
	 * 删除用户信息
	 * 2019/07/10
	 */
	public boolean deleteUserinfo(Integer infoid)throws Exception{
		if(userinfoDao.deleteByPrimaryKey(infoid)>=1) {
			return true;
		}
		return false;
	}
	
	/*
	 * 查找用户账户信息
	 * 刘硕2019/07/14
	 */
	public Useraccount getUseraccount(String username)throws Exception{
		return useraccountDao.selectByPrimaryKey(username);
	}
	
	/*
	 * 更新用户账户信息
	 * 刘硕2019/07/14
	 */
	public boolean updateUseraccount(Useraccount useraccount)throws Exception{
		if(useraccountDao.updateByPrimaryKey(useraccount)>=1) {
			return true;
		}
		return false;
	}
	
	/*
	 * 更新用户账户信息，密码为必填信息不可置空
	 * 刘硕2019/07/14
	 */
	public boolean updateUseraccount(UserAccountModel useraccountmodel,String username)throws Exception{
		Useraccount useraccount=toUseraccount(useraccountmodel,username);
		if(useraccountmodel.getPassword()==null||useraccountmodel.getPassword().trim()=="") {
			if(useraccountDao.updateByPrimaryKeywithoutPassword(useraccount)>=1) {
				return true;
			}else {
				return false;
			}
		}else {
			if(useraccountDao.updateByPrimaryKey(useraccount)>=1) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	/*
	 * 将servicemodel转换为datamodel,针对Useraccout对象
	 * 刘硕2019/07/14
	 */
	Useraccount toUseraccount(UserAccountModel model,String username) {
		Useraccount useraccount = new Useraccount();
		useraccount.setEmail(model.getEmail());
		useraccount.setHeadimage(model.getHeadpicpath());
		useraccount.setPassword(model.getPassword());
		if(model.getPhone()!=null) {
		useraccount.setPhone(Integer.parseInt(model.getPhone()));
		}
		useraccount.setUsername(username);
		return useraccount;
	}
}

