package cn.et.lesson03;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
/**
 * ���� request����Ĳ���������
 * request����������  �������������  ����request����  ��Ӧ��  request������
 * @author Administrator
 *
 */
public class RequestCycleListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
	   System.out.println("��������");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request=(HttpServletRequest)sre.getServletRequest();
		System.out.println("���������"+request.getRequestURL());
	}

}
