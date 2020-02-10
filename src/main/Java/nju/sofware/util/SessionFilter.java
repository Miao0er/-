/*
 * �Զ���Ȩ�޹�����
 * 2019/4/20
 * ��˶
 */
package nju.sofware.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter {
	public static boolean userIdentityFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		String account = (String) session.getAttribute("account");// ����Ӧ�øĳɻ�ȡsession account
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
				JsTool.redirectAlert("����Ȩ�޲���", "login", response);
				return false;
			}
		}else {
			JsTool.loginAlert(response);
			return false;
		}
	}
	
}
