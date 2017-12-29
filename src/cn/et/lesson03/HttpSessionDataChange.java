package cn.et.lesson03;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class HttpSessionDataChange implements HttpSessionAttributeListener {
	/**
	 * session.setAttribute("sex","boy");
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		String key=se.getName();
		String value=se.getValue().toString();
		System.out.println(key+"="+value);
	}
	/**
	 * session.removeAttribute("sex","boy");
	 */
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub

	}
	/**
	 * ����session�� ���� sex=boy
	 * session..setAttribute("sex","girl");
	 */
	public void attributeReplaced(HttpSessionBindingEvent se) {
		String key=se.getName();
		String value=se.getValue().toString();//��ȡ��ֵ
		String val=se.getSession().getAttribute(key).toString();//��ȡ��ֵ
		System.out.println("replace=>"+key+"="+value+"="+val);
	}

}
