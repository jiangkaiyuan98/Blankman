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
	
	//连接池
	private LinkedList<Connection> connPool =new LinkedList<Connection>();
	
	//初始化的时候创建10个连接
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
	
	//从池子中得到一个连接
	public Connection getConnection() {
		return  connPool.removeFirst();
	}
	
	//将用过的连接归还
	public void closeConnection(Connection conn) {
		connPool.addLast(conn);
	}
}
