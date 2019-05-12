package shixi;
import java.sql.*;
import shixi.Student;
import shixi_jdbc.DBUtil;
public class student_operation {
	public int  addStudent(Student stu) {
		int result=0;
		
		Connection conn =null;
		Statement stm=null;
		
		try {
			conn=DBUtil.getConn();
			stm=conn.createStatement();
			String sql="insert into student (s_id,name,sex,score,password,school_id) values ("+stu.getS_id()+", '"+stu.getName()+"', '"+stu.getSex()+"', "+stu.getScore()+",'"+stu.getPassword()+"',"+stu.getSchool_id()+") ";
			result=stm.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.close(null, stm, conn);
		}

		return result;
	}
	public int delStudent(int id ) {
		int result=0;
		Connection conn=null;
		Statement stm=null;
		try {
			conn=DBUtil.getConn();
			stm=conn.createStatement();
			String sql="delete from student where id =" +id;
			result=stm.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.close(null, stm, conn);
		}
		return result;
	}
	public int updateStudent(Student stu ) {
		int result=0;
		Connection conn=null;
		Statement stm=null;
		try {
			conn=DBUtil.getConn();
			stm=conn.createStatement();
			
			String sql="update student set s_id="+stu.getS_id()+",name='"+stu.getName()+"', sex='"+stu.getSex()+"', score="+stu.getScore()+",password='"+stu.getPassword()+"',school_id="+stu.getSchool_id()+" where id ="+stu.getId();
			
			result=stm.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.close(null, stm, conn);
		}
		return result;
	}
	public  Student getStudent(int id) {
		Student stu=null;
		Connection conn=null;
		Statement stm=null;
		ResultSet rs= null;
		try {
			conn=DBUtil.getConn();
			stm=conn.createStatement();
			String sql="select * from student where id =" +id;
			rs =stm.executeQuery(sql);
			
			if(rs.next()) {
				stu=new Student(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stm, conn);
		}
		
		return stu; 
	}
	public Student login(String s_id, String password) {
		Student stu = null;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn=DBUtil.getConn();
			stm=conn.createStatement();
			String sql="select * from student where s_id ="+s_id+"  and password= '"+password+"'" ; 
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			
			if(rs.next()) {
				stu=new Student(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stm, conn);
		}
		
		return stu;
	}
	public Student safe_login(String s_id, String password) {
		Student stu=null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn=DBUtil.getConn();
			String sql="select * from student where s_id =?  and password=?" ; 
			stm=conn.prepareStatement(sql);
			stm.setString(1, s_id);
			stm.setString(2, password);
			System.out.println(sql);
			rs=stm.executeQuery();
			
			if(rs.next()) {
				stu=new Student(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stm, conn);
		}
		return stu;
	}
	public Student show_student_msg(int school_id) {
		Student stu=null;
		Connection conn=null;
		Statement stm=null;
		ResultSet rs= null;
		try {
			conn=DBUtil.getConn();
			stm=conn.createStatement();
			String sql="select stu.*,sch.school_name from student stu,school sch where stu.school_id =sch.school_id and stu.school_id=" +school_id;
			rs=stm.executeQuery(sql);
			if(rs.next()) {
				stu=new Student(rs);
				stu.setSchool_name(rs.getString("school_name"));
				System.out.println(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stm, conn);
		}
		
		return stu;
	}
	public Student getStudentby_s_id(int s_id) {
		Student stu=null;
		Connection conn=null;
		Statement stm=null;
		ResultSet rs= null;
		try {
			conn=DBUtil.getConn();
			stm=conn.createStatement();
			String sql="select * from student where s_id =" +s_id;
			rs =stm.executeQuery(sql);
			
			if(rs.next()) {
				stu=new Student(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stm, conn);
		}
		
		return stu; 
	}


}
