/*
 * 团队Controller层
 * 2019/7/10
 * 刘硕
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
	* 功能说明
	* 团队管理界面返回
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
	* 功能说明
	* 添加团队form提交处理
	*/
	@RequestMapping(value = "/addteaminfo", method = RequestMethod.POST)
	public ModelAndView addTeaminfo(HttpServletRequest request,@ModelAttribute("teaminfoForm")Teaminfo teaminfo,HttpServletResponse response) {
		try {
			if(teamService.addTeaminfo(teaminfo)) {
				JsTool.redirectAlert("添加成功！", "team/teampage", response);
				return new ModelAndView("ManageTeam");
			}else {
				JsTool.redirectAlert("添加失败！", "user/teampage", response);
				return new ModelAndView("ManageTeam");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
	
	/**
	* 功能说明
	* 团队信息修改
	*/
	@RequestMapping(value = "/updateteaminfo", method = RequestMethod.POST)
	public ModelAndView updateteamminfo(HttpServletRequest request,@ModelAttribute("teaminfo")Teaminfo teaminfo,HttpServletResponse response) {
		try {
			if(teamService.updateTeaminfo(teaminfo)) {
				JsTool.redirectAlert("修改成功！", "team/teampage", response);
				return new ModelAndView("ManageTeam");
			}else {
				JsTool.redirectAlert("修改失败！", "team/teampage", response);
				return new ModelAndView("ManageTeam");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
	
	/**
	* 功能说明
	* 删除团队信息
	*/
	@RequestMapping(value = "/deleteteaminfo", method = RequestMethod.GET)
	public ModelAndView deleteTeaminfo(HttpServletRequest request,@RequestParam("infoid")Integer infoid,HttpServletResponse response) {
		try {
			if(teamService.deleteTeaminfo(infoid)) {
				JsTool.redirectAlert("删除成功！", "team/teampage", response);
				return new ModelAndView("ManageTeam");
			}else {
				JsTool.redirectAlert("删除失败！", "team/teampage", response);
				return new ModelAndView("ManageTeam");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
	
}
