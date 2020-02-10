package nju.sofware.service;

import java.util.List;

import nju.sofware.data.dataobject.TeamMember;
import nju.sofware.data.dataobject.Teaminfo;
import nju.sofware.data.dataobject.Userinfo;
/*
 * �Ŷӳ�Ա�߼���ӿ�
 * 2019/0710
 * ��˶
 */
public interface TeamMemberService {
	void addteamMember(Userinfo userinfo) throws Exception;
	List<TeamMember> getTeamMembers()throws Exception;
	boolean deleteTeamMember(Integer infoid)throws Exception;
	boolean updateTeamMember(TeamMember teammember)throws Exception;
}
