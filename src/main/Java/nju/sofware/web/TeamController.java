/*
 * �Ŷ�Controller��
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

import nju.sofware.data.dataobject.Teaminfo;
import nju.sofware.data.dataobject.Userinfo;
import nju.sofware.service.TeamService;
import nju.sofware.service.UserService;
import nju.sofware.util.JsTool;


@Controller
@RequestMapping("/team")
public class TeamController {
	@Autowired  
    private TeamService teamService;
	
	/**
	* ����˵��
	* �Ŷӹ�����淵��
	*/
	@RequestMapping(value = "/teampage",method = RequestMethod.GET)
	public ModelAndView userinfoPage() {
		try {
		ModelAndView modelAndView = new ModelAndView();
		List<Teaminfo> teaminfos=teamService.getTeaminfos();
		modelAndView.addObject("teaminfos", teaminfos);
		modelAndView.setViewName("ManageTeam");
		return modelAndView;
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
	
	/**
	* ����˵��
	* ����Ŷ�form�ύ����
	*/
	@RequestMapping(value = "/addteaminfo", method = RequestMethod.POST)
	public ModelAndView addTeaminfo(HttpServletRequest request,@ModelAttribute("teaminfoForm")Teaminfo teaminfo,HttpServletResponse response) {
		try {
			if(teamService.addTeaminfo(teaminfo)) {
				JsTool.redirectAlert("��ӳɹ���", "team/teampage", response);
				return new ModelAndView("ManageTeam");
			}else {
				JsTool.redirectAlert("���ʧ�ܣ�", "user/teampage", response);
				return new ModelAndView("ManageTeam");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
	
	/**
	* ����˵��
	* �Ŷ���Ϣ�޸�
	*/
	@RequestMapping(value = "/updateteaminfo", method = RequestMethod.POST)
	public ModelAndView updateteamminfo(HttpServletRequest request,@ModelAttribute("teaminfo")Teaminfo teaminfo,HttpServletResponse response) {
		try {
			if(teamService.updateTeaminfo(teaminfo)) {
				JsTool.redirectAlert("�޸ĳɹ���", "team/teampage", response);
				return new ModelAndView("ManageTeam");
			}else {
				JsTool.redirectAlert("�޸�ʧ�ܣ�", "team/teampage", response);
				return new ModelAndView("ManageTeam");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
	
	/**
	* ����˵��
	* ɾ���Ŷ���Ϣ
	*/
	@RequestMapping(value = "/deleteteaminfo", method = RequestMethod.GET)
	public ModelAndView deleteTeaminfo(HttpServletRequest request,@RequestParam("infoid")Integer infoid,HttpServletResponse response) {
		try {
			if(teamService.deleteTeaminfo(infoid)) {
				JsTool.redirectAlert("ɾ���ɹ���", "team/teampage", response);
				return new ModelAndView("ManageTeam");
			}else {
				JsTool.redirectAlert("ɾ��ʧ�ܣ�", "team/teampage", response);
				return new ModelAndView("ManageTeam");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
	
}
