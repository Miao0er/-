/*
 * ������תJS��װ
 * 2019/4/20
 * ��˶
 */
package nju.sofware.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class JsTool {
	public static void successAlert(HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8"); // ת��
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('�ɹ���');");
		out.println("history.back();");
		out.println("location.reload();");
		out.println("</script>");
	}
	
	public static void msgAlert(String msg,HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8"); // ת��
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('"+msg+"');");
		out.println("history.back();");
		out.println("location.reload();");
		out.println("</script>");
	}
	
	public static void loginAlert(HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8"); // ת��
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('���½��');");
		out.println("window.location.href='/login';");//--
		out.println("</script>");
	}
	
	public static void errorAlert(HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8"); // ת��
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('�������⣡');");
		out.println("window.location.href='/error';");//--
		out.println("</script>");
	}
	
	public static void redirectAlert(String msg,String url,HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8"); // ת��
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('"+msg+"');");
		out.println("window.location.href='/"+url+"';");//--
		out.println("</script>");
	}
	
	public static void Alert(String msg,HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8"); // ת��
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('"+msg+"');");
		out.println("</script>");
	}
}
