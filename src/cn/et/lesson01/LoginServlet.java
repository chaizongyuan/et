package cn.et.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * request��ʾ���������������������ַ�س� ��������ύ��ť�� �����ȡ�����������һЩ��Ϣ������ͷ��
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//��ȡ�����url  getRequestURL
		String url=request.getRequestURL().toString();
		out.println("�������url:"+url+"<br/>");
		//��ȡ���� getParameter("��")
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		//��ȡ����ķ�ʽ
		String method=request.getMethod();
		out.println("�����������:"+method+"<br/>");
		//��ȡ����ͷ�ļ�ֱ��
		String acceptLa=request.getHeader("Accept-Language");
		out.println("�����֧�ֵ����Ժ͹���:"+acceptLa+"<br/>");
		String userAgent=request.getHeader("User-Agent");
		out.println("�����������:"+userAgent+"<br/>");
		
		String contextPath=request.getContextPath();
		out.println("������·����"+contextPath);
		//String str=null;
		//str.toString();
		
		
		//����jdbc ��ѯ���� 
		//��¼�ɹ� ��ӭXXX  select * from myuser where username=? and password=?
		//��¼ʧ��  ��ʾ ��¼ʧ�� 
		String sql="select * from myuser where username=? and password=?";
		try {
			Statement DBUtils = null;
			Connection conn=DBUtils.getConnection();
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				out.println("<font color=red>��ӭ "+userName+" ��½ϵͳ</font>");
			}
			else{
				out.println("<font color=red>��½ʧ��</font>");
				response.setDateHeader("expries", -1);  
				response.setHeader("Cache-Control", "no-cache");  
				response.setHeader("Pragma", "no-cache");  
				response.setHeader("Refresh","3;url="+contextPath+"/index.html");
				
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

		this.doGet(request, response);
	}

}
