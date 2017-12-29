package cn.et.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet {

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
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		String sql = "select * from myuser where userName=? and password=?";
		try {
			Connection conn = DbUtils.getConnectoin();//»ñÈ¡Á¬½Ó
			PreparedStatement sta = conn.prepareStatement(sql);//Ö´ÐÐÔ¤±àÒësqlÓï¾ä
			sta.setString(1, userName);
			sta.setString(2, password);
			ResultSet rs = sta.executeQuery();
			if (rs.next()) {
				out.println("<font color=red>»¶Ó­ "+userName+" µÇÂ¼³É¹¦</font>");
			}else {
				out.println("<font color=red>µÇÂ¼Ê§°Ü</font>");
			}
			rs.close();
			sta.close();
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
