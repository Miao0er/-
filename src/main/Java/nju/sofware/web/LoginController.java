/*
 *��¼Controller
 *2019/7/8
 *��˶ 
 */
package nju.sofware.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import nju.sofware.data.dataobject.Useraccount;
import nju.sofware.data.dataobject.Userinfo;
import nju.sofware.service.LoginService;
import nju.sofware.service.UserService;
import nju.sofware.util.JsTool;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired  
    private LoginService loginService;
	
	/**
	* ����˵��
	* ��½���淵��
	*/
	@RequestMapping(value = "/loginpage",method = RequestMethod.GET)
	public ModelAndView loginPage() {
		return new ModelAndView("Login");
	}
	
	/**
	* ����˵��
	* ��¼form�ύ����
	*/
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,@RequestParam("username") String username,String password, HttpServletResponse response) {
		try {
			Useraccount useraccount=loginService.valUser(username, password);
			if(useraccount!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("userhead", useraccount.getHeadimage());
				session.setAttribute("power",useraccount.getPower());
				JsTool.redirectAlert("��¼�ɹ���", "user/userinfoPage", response);
				return new ModelAndView("ManageUser");
			}else {
				JsTool.redirectAlert("�û����������", "login", response);
				return new ModelAndView("Login");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
}
