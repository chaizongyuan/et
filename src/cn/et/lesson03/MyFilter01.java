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
 * ��������ʵ����  ʵ��Filter  ������ ֻ������������ʱ����ʵ��
 * 
 * ��������
 *   ���ĳЩ��Դ���������������  �γ�����
 *   �����Դ������ʱ ������е����й��������ᱻ����ִ�� 
 *   ����κ�һ��������û��ͨ�� �������ж�����������й�����������ִ��
 * @author Administrator
 *
 */
public class MyFilter01 implements Filter {

	/**
	 * �������ڵ����ٷ���
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}
	/**
	 * ����������ĳЩ��Դ  ��Щ��Դ��������doFilter
	 * ������������Դ�Ƿ��ܹ�ͨ���ù�����
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//�����˸÷��� ������ͨ����֤ ������ ���
		request.getAttribute("aaa");
		
		//���������file ��ͨ�� ������private ���
		//chain.doFilter(request, response);
		

	}
	/**
	 * �������ڵĳ�ʼ������
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init ");
	}

}
