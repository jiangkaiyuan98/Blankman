package shixi_jdbc;
import java.sql.*;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class DBUtil {
	private DBUtil() {
	} // ˽�л����캯��

	static DataSource dataSource = null;
	
	static {
		dataSource = new ComboPooledDataSource("mysql");
	}

	// �õ�����
	public static Connection getConn() {
		Connection conn=null;
		try {
			conn= dataSource.getConnection();  //����ģʽ
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	// ������
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
				conn.close();  //����conn�Ѿ��Ǵ������,���Կ��������ر�
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}