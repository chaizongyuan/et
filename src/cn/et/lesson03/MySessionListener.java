package cn.et.lesson03;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * session���������� 
 *    sessionԭ����ͨ�� ���� �ڵ���getsession����ʱ �Զ�ͨ��cookieд��sessionid�ķ�ʽ������
 *    cookieĬ�ϵ���Ч���� ��������ر�֮ǰ  ��ǰsession����Ч���ǵ�ǰ��һ�����������
 *    session���ݴ���� ������ �����޷����� ������Ĺر�  ��ͨ��web.xml
 *        <session-config>
	      <session-timeout>1</session-timeout>
	  </session-config> ��������ʱ���  ����δ���ʵ�session����
 * @author Administrator
 *
 */
public class MySessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session=se.getSession();
		System.out.println("session����"+session.getId());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session=se.getSession();
		System.out.println("session������"+session.getId());
	}

}
