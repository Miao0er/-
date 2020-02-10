package nju.sofware.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nju.sofware.data.dao.TeamMemberMapper;
import nju.sofware.data.dao.UseraccountMapper;
import nju.sofware.data.dataobject.TeamMember;
import nju.sofware.data.dataobject.Useraccount;
import nju.sofware.data.dataobject.Userinfo;
import nju.sofware.service.TeamMemberService;

/*
 * �Ŷӳ�Ա�߼���
 * 2019/07/10
 * ��˶
 */
@Service
public class TeamMemberServiceImpl implements TeamMemberService{
	@Autowired  
    private UseraccountMapper useraccountDao;
	@Autowired  
    private TeamMemberMapper teamMemberDao;
	
	
	public void addteamMember(Userinfo userinfo) throws Exception{
		Useraccount useraccount=useraccountDao.selectByPrimaryKey(userinfo.getUsername());
		TeamMember teammember=new TeamMember();
		teammember.setId(userinfo.getId());
		teammember.setUsername(userinfo.getUsername());
		teammember.setName(userinfo.getName());
		teammember.setPhone(useraccount.getPhone().toString());
		teammember.setEmail(useraccount.getEmail());
		teamMemberDao.insert(teammember);
	}
	
	/*
	 * ���������û���Ϣ
	 * 2019/07/10
	 */
	public List<TeamMember> getTeamMembers()throws Exception{
		List<TeamMember> teammembers=teamMemberDao.selectAll();
		return teammembers;
	}
	
	/*
	 * �����û���Ϣ
	 * 2019/07/10
	 */
	public boolean updateTeamMember(TeamMember teammember)throws Exception{
		if(teamMemberDao.updateByPrimaryKey(teammember)>=1){
			return true;
		}
		return false;
	}
	
	/*
	 * ɾ���û���Ϣ
	 * 2019/07/10
	 */
	public boolean deleteTeamMember(Integer infoid)throws Exception{
		if(teamMemberDao.deleteByPrimaryKey(infoid)>=1) {
			return true;
		}
		return false;
	}
}
