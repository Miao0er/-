/*
 * 自定义权限过滤器
 * 2019/4/20
 * 刘硕
 */
package nju.sofware.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter {
	public static boolean userIdentityFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		String account = (String) session.getAttribute("account");// 这里应该改成获取session account
		if(account!=null) {
			return true;
		}else {
			JsTool.loginAlert(response);
			return false;
		}
	}
	
	public static boolean managerIdentityFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		String account = (String) session.getAttribute("account");
		Integer power = (Integer) session.getAttribute("power");
		if(account!=null) {
			if(power>1) {
				return true;
			}else {
				JsTool.redirectAlert("您的权限不够", "login", response);
				return false;
			}
		}else {
			JsTool.loginAlert(response);
			return false;
		}
	}
	
}
