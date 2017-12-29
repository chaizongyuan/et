package cn.et.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取请求的url
		String url=request.getRequestURL().toString();
		out.println("你请求的url:"+url+"<br/>");
		//获取参数getParameter("键")
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		out.println(userName+"-----"+password+"<br/>");
		//获取请求的方式
		String method=request.getMethod();
		out.println("您请求的类型:"+method+"<br/>");
		//获取请求头的键值对
		String acceptLa=request.getHeader("Accept-Language");
		out.println("浏览器支持的语言和国家:"+acceptLa+"<br/>");
		String useAgent=request.getHeader("User-Agent");
		out.println("浏览器的类型"+useAgent+"<br/>");
		//获取上下文路径
		String contextPath=request.getContextPath();
		out.println("上下文路径"+contextPath+"<br/>");
//		String str=null;
//		str.toString();
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
