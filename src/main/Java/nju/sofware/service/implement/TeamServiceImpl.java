package nju.sofware.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nju.sofware.biz.TeamMemberServiceImpl;
import nju.sofware.data.dao.TeaminfoMapper;
import nju.sofware.data.dao.UserinfoMapper;
import nju.sofware.data.dataobject.Teaminfo;
import nju.sofware.data.dataobject.Userinfo;
import nju.sofware.service.TeamService;
/*
 * 团队逻辑层实现
 * 2019/0710
 * 刘硕
 */
@Service
public class TeamServiceImpl implements TeamService{
	@Autowired  
    private TeaminfoMapper teaminfoDao; 

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
	
	/*
	 *插入团队信息
	 * 2019/7/10
	 * 刘硕
	 */
	public boolean addTeaminfo(Teaminfo teaminfo)throws Exception{
		if(teaminfoDao.insert(teaminfo)>=1) {
			return true;
		}
		return false;
	}
	
	/*
	 * 查找所有团队信息
	 * 2019/07/10
	 */
	public List<Teaminfo> getTeaminfos()throws Exception{
		List<Teaminfo> teaminfos=teaminfoDao.selectAll();
		return teaminfos;
	}
	
	/*
	 * 更新团队信息
	 * 2019/07/10
	 */
	public boolean updateTeaminfo(Teaminfo teaminfo)throws Exception{
		if(teaminfoDao.updateByPrimaryKey(teaminfo)>=1){
			return true;
		}
		return false;
	}
	
	/*
	 * 删除团队信息
	 * 2019/07/10
	 */
	public boolean deleteTeaminfo(Integer infoid)throws Exception{
		if(teaminfoDao.deleteByPrimaryKey(infoid)>=1) {
			return true;
		}
		return false;
	}
}
