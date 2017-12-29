package cn.et.lesson01;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
/**
 * jdbc封装类
 * @author Administrator
 *
 */
public class DbUtils {
    static Properties p = new Properties();
	static{
		InputStream is = DbUtils.class.getResourceAsStream("/jdbcm.properties");
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 * @throws Exception 
	 */
	public static Connection getConnectoin() throws Exception{
		String url = p.getProperty("url");
		String driverClass = p.getProperty("driverClass");
		String userName = p.getProperty("username");
		String password = p.getProperty("password");
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(url, userName, password);
		return conn;
	}
	
}
