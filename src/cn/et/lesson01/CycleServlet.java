package cn.et.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CycleServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 * servlet生命周期
	 * 1.tomcat容器自动实例化servlet实例(永远只有一个实例默认在第一次访问时实例化配置load-on-startup>0以上的值表示启动服务
	 * 		时实例化,否则第一次请求)
	 * 2.tomcat容器自动调用init方法进行简单初始化
	 * 3.service方法(请求的入口方法根据请求额类型调用doget和dopost)就是服务的方法每发起一次请求就会调用一次
	 * 4.destroy方法 当容器被关闭或者项目被重新加载时自动销毁
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public CycleServlet(){
		System.out.println("开始构造");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("service");
		super.service(req, resp);
		
	}
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("doget");
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

		super.doPost(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 * 一般用于进行初始化工作 永远只会被调用一次
	 */
	
	public void init() throws ServletException {
		System.out.println("init");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("initconfig");
		super.init(config);
	}

}
