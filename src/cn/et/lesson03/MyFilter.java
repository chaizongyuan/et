package cn.et.lesson03;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��������ʵ���� ʵ��Fileter ������ֻ������������ʱ����ʵ��
 * @author Administrator
 *
 */
public class MyFilter implements Filter {

	/**
	 * �������ڵ����ٷ���
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}
	/**
	 * ����������ĳЩ��Դ ��Щ��Դ��������doFilter
	 * ������������Դ�Ƿ��ܹ�ͨ���ù�����
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//�����˸÷��� ������ͨ����֤ ������ ���
		
		
		//���������file ��ͨ�� ������private ���
		//chain.doFilter(request, response);
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		
		String url=req.getRequestURL().toString();
		if(!url.contains("private")){
			chain.doFilter(request, response);
		}

	}
	/**
	 * �������ڵĳ�ʼ������
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init ");
	}

}
