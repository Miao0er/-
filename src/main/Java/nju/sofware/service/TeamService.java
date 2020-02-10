/*
 * �Ŷ���Ϣ�����߼���ؽӿ�
 * 2019/07/10
 * ��˶
 */
package nju.sofware.service;

import java.util.List;

import nju.sofware.data.dataobject.Teaminfo;
import nju.sofware.data.dataobject.Userinfo;

public interface TeamService {
	boolean addTeaminfo(Teaminfo teaminfo)throws Exception;
	List<Teaminfo> getTeaminfos()throws Exception;
	boolean deleteTeaminfo(Integer infoid)throws Exception;
	boolean updateTeaminfo(Teaminfo teaminfo)throws Exception;
}
