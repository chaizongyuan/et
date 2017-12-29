package cn.et.lesson03;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
/**
 * ServletContext��������
 *   ����Ӧ�õķ������������͹ر�  �����٣�
 *   
 * ���ݴ洢�߼�(setAttribute �� getAttribute)
 *   ���е�servlet����Ҫ����  ������Ҫ����ʱ��ܳ�  д��  ServletContext
 *   ����ʹ��״̬�� ��ͬ���û�ӵ�в�ͬ������   д�� HttpSession
 *   ���ݵĲ���  ���� ����ת����ת���ݴ���   д��HttpServletRequest Ӧ�����
 * @author Administrator
 *
 */
public class MyServletContext implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("�����Ķ�������");
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("�����Ķ��� ����");
	}

	
}
