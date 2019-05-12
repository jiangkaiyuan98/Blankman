package shixi_jdbc;

import java.sql.*;
import java.util.*;

public class MyDataSource {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//���ӳ�
	private LinkedList<Connection> connPool =new LinkedList<Connection>();
	
	//��ʼ����ʱ�򴴽�10������
	public MyDataSource(){
		for(int i=0;i<10;i++) {
			try {
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/haikang?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&autoReconnect=true", "root", "jky123");
				connPool.add(conn);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
	
	//�ӳ����еõ�һ������
	public Connection getConnection() {
		return  connPool.removeFirst();
	}
	
	//���ù������ӹ黹
	public void closeConnection(Connection conn) {
		connPool.addLast(conn);
	}
}
