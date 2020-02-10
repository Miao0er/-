/*
 * 返回跳转JS封装
 * 2019/4/20
 * 刘硕
 */
package nju.sofware.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class JsTool {
	public static void successAlert(HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8"); // 转码
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('成功！');");
		out.println("history.back();");
		out.println("location.reload();");
		out.println("</script>");
	}
	
	public static void msgAlert(String msg,HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8"); // 转码
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('"+msg+"');");
		out.println("history.back();");
		out.println("location.reload();");
		out.println("</script>");
	}
	
	public static void loginAlert(HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8"); // 转码
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('请登陆！');");
		out.println("window.location.href='/login';");//--
		out.println("</script>");
	}
	
	public static void errorAlert(HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8"); // 转码
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('出现问题！');");
		out.println("window.location.href='/error';");//--
		out.println("</script>");
	}
	
	public static void redirectAlert(String msg,String url,HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8"); // 转码
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('"+msg+"');");
		out.println("window.location.href='/"+url+"';");//--
		out.println("</script>");
	}
	
	public static void Alert(String msg,HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8"); // 转码
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('"+msg+"');");
		out.println("</script>");
	}
}
