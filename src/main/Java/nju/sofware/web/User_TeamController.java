/*
 * �Ŷӳ�ԱController��
 * 2019/7/10
 * ��˶
 */
package nju.sofware.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import nju.sofware.data.dataobject.TeamMember;
import nju.sofware.data.dataobject.Teaminfo;
import nju.sofware.data.dataobject.Userinfo;
import nju.sofware.service.TeamMemberService;
import nju.sofware.service.UserService;
import nju.sofware.util.JsTool;

@Controller
@RequestMapping("/teammember")
public class User_TeamController {
	@Autowired  
    private TeamMemberService teammemberService;
	
	/**
	* ����˵��
	* ��Ա������淵��
	*/
	@RequestMapping(value = "/teammemberpage",method = RequestMethod.GET)
	public ModelAndView teammemberPage() {
		try {
		ModelAndView modelAndView = new ModelAndView();
		List<TeamMember> teammembers=teammemberService.getTeamMembers();
		modelAndView.addObject("teammembers", teammembers);
		modelAndView.setViewName("ManageUser_Team");
		return modelAndView;
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
	
	/**
	* ����˵��
	* ��Ա��Ϣ�޸�
	*/
	@RequestMapping(value = "/updateteammember", method = RequestMethod.POST)
	public ModelAndView updateteammember(HttpServletRequest request,@ModelAttribute("teammember")TeamMember teammember,HttpServletResponse response) {
		try {
			if(teammemberService.updateTeamMember(teammember)) {
				JsTool.redirectAlert("�޸ĳɹ���", "teammember/teammemberpage", response);
				return new ModelAndView("ManageUser_Team");
			}else {
				JsTool.redirectAlert("�޸�ʧ�ܣ�", "teammember/teammemberpage", response);
				return new ModelAndView("ManageUser_Team");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
	
	/**
	* ����˵��
	* ɾ����Ա��Ϣ
	*/
	@RequestMapping(value = "/deleteteammember", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,@RequestParam("id")Integer id,HttpServletResponse response) {
		try {
			if(teammemberService.deleteTeamMember(id)) {
				JsTool.redirectAlert("ɾ���ɹ���", "teammember/teammemberpage", response);
				return new ModelAndView("ManageUser_Team");
			}else {
				JsTool.redirectAlert("ɾ��ʧ�ܣ�", "teammember/teammemberpage", response);
				return new ModelAndView("ManageUser_Team");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
}
