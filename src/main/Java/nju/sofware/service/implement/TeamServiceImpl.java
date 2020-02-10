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
 * �Ŷ��߼���ʵ��
 * 2019/0710
 * ��˶
 */
@Service
public class TeamServiceImpl implements TeamService{
	@Autowired  
    private TeaminfoMapper teaminfoDao; 

	/*��ϲ����û�����*/
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
	 *�����Ŷ���Ϣ
	 * 2019/7/10
	 * ��˶
	 */
	public boolean addTeaminfo(Teaminfo teaminfo)throws Exception{
		if(teaminfoDao.insert(teaminfo)>=1) {
			return true;
		}
		return false;
	}
	
	/*
	 * ���������Ŷ���Ϣ
	 * 2019/07/10
	 */
	public List<Teaminfo> getTeaminfos()throws Exception{
		List<Teaminfo> teaminfos=teaminfoDao.selectAll();
		return teaminfos;
	}
	
	/*
	 * �����Ŷ���Ϣ
	 * 2019/07/10
	 */
	public boolean updateTeaminfo(Teaminfo teaminfo)throws Exception{
		if(teaminfoDao.updateByPrimaryKey(teaminfo)>=1){
			return true;
		}
		return false;
	}
	
	/*
	 * ɾ���Ŷ���Ϣ
	 * 2019/07/10
	 */
	public boolean deleteTeaminfo(Integer infoid)throws Exception{
		if(teaminfoDao.deleteByPrimaryKey(infoid)>=1) {
			return true;
		}
		return false;
	}
}
