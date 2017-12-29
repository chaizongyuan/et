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
	 * servlet��������
	 * 1.tomcat�����Զ�ʵ����servletʵ��(��Զֻ��һ��ʵ��Ĭ���ڵ�һ�η���ʱʵ��������load-on-startup>0���ϵ�ֵ��ʾ��������
	 * 		ʱʵ����,�����һ������)
	 * 2.tomcat�����Զ�����init�������м򵥳�ʼ��
	 * 3.service����(�������ڷ���������������͵���doget��dopost)���Ƿ���ķ���ÿ����һ������ͻ����һ��
	 * 4.destroy���� ���������رջ�����Ŀ�����¼���ʱ�Զ�����
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public CycleServlet(){
		System.out.println("��ʼ����");
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
	 * һ�����ڽ��г�ʼ������ ��Զֻ�ᱻ����һ��
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
