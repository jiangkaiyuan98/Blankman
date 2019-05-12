package shixi_jdbc;
import java.sql.*;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class DBUtil {
	private DBUtil() {
	} // 私有化构造函数

	static DataSource dataSource = null;
	
	static {
		dataSource = new ComboPooledDataSource("mysql");
	}

	// 得到连接
	public static Connection getConn() {
		Connection conn=null;
		try {
			conn= dataSource.getConnection();  //代理模式
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	// 关连接
	public static void close(ResultSet rs, Statement stm, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();  //由于conn已经是代理对象,所以可以这样关闭
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}