package nju.sofware.service;

import java.util.List;

import nju.sofware.data.dataobject.TeamMember;
import nju.sofware.data.dataobject.Teaminfo;
import nju.sofware.data.dataobject.Userinfo;
/*
 * 团队成员逻辑层接口
 * 2019/0710
 * 刘硕
 */
public interface TeamMemberService {
	void addteamMember(Userinfo userinfo) throws Exception;
	List<TeamMember> getTeamMembers()throws Exception;
	boolean deleteTeamMember(Integer infoid)throws Exception;
	boolean updateTeamMember(TeamMember teammember)throws Exception;
}
