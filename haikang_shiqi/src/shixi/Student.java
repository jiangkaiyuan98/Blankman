package shixi;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	private Integer id;
	private int s_id;
	private String name;
	private String sex;
	private int score;
	private String password;
	private int school_id;
	private String school_name;
	public Student() {
		
	}
	public Student(ResultSet rs) throws SQLException {
		this.id = rs.getInt("id");
		this.s_id = rs.getInt("s_id");
		this.name = rs.getString("name");
		this.sex = rs.getString("sex");
		this.score = rs.getInt("score");
		this.password = rs.getString("password");
		this.school_id = rs.getInt("school_id");
		//this.school_name=rs.getString("school_name");
		/*Student stu=new Student();
		stu.setId(rs.getInt("id"));
		stu.setS_id(rs.getInt("s_id"));
		stu.setName(rs.getString("name"));
		stu.setSex(rs.getString("sex"));
		stu.setScore(rs.getInt("score"));
		stu.setSchool_id(rs.getInt("school_id"));
		*/
	}

	public String toString() {
		return "Student [id=" + id + ", s_id=" + s_id + ", name=" + name + ", sex=" + sex + ", score=" + score
				+ ", password=" + password + ", school_id=" + school_id + ", school_name=" + school_name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSchool_id() {
		return school_id;
	}
	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

}
