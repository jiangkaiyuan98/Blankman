package shixi;
//import shixi.Student;
import shixi_jdbc.DBUtil;

import java.sql.*;
//import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		long begin=System.currentTimeMillis();
		
		for(int i=0;i<10000;i++) {
			Connection conn=DBUtil.getConn();
			DBUtil.close(null, null, conn);
		}
		
		long end =System.currentTimeMillis();		
		System.out.println("程序一共运行了"+ (end -begin) +"毫秒" );		
	}
/*@SuppressWarnings("resource")
public static void main(String[] args) {
		
	student_operation op1=new student_operation();
	
	System.out.println("*************某某管理系统**************");
	System.out.println("请输入用户名");//1 or 1 =1
	
	Scanner input=new Scanner(System.in);
	String s_id=input.nextLine();
	
	System.out.println("请输入密码");//1' or '1' ='1
	String password = input.nextLine();
	
	//Student stu = op1.login(s_id, password);//注入测试
	Student stu = op1.safe_login(s_id, password);//安全登陆测试
	
	if(stu!=null) {
		System.out.println("*************某某管理系统**************");
		System.out.println("登录成功");
		Student stu_select=op1.getStudentby_s_id( Integer.parseInt(s_id));
		stu_select=op1.show_student_msg(stu_select.getSchool_id());
		System.out.println("请选择 1 添加用户     2 删除用    3 查询用  ...");
		System.out.println("************************************");
	}
	
	else {
		System.out.println("*************某某管理系统**************");
		System.out.println("对不起,登录失败~");
		System.out.println("请选择 1 退出系统     2 重新登录  " );
		System.out.println("************************************");
	}
	
		/*	
			student_operation op1=new student_operation();
			//添加测试
			Student stu_add=new Student();
			stu_add.setS_id(20166004);
			stu_add.setName("康师傅");
			stu_add.setSex("男");
			stu_add.setScore(55);
			
			int result =op1.addStudent(stu_add);
			
			if(result==1) {
				System.out.println("学生添加成功");
			}
			
			//删除测试
			int result1 =op1.delStudent(1);
			if(result1==1) {
				System.out.println("学生删除成功");
			}
			
			
			//测试查询
			System.out.print("ID=2的学生");
			Student stu_select=op1.getStudent(2);
			System.out.println(stu_select);
			
			//测试修改
			Student stu_update=op1.getStudent(2);
			stu_update.setName("lzl");
			stu_update.setScore(10);
			result=op1.updateStudent(stu_update);
			if(result==1) {
				System.out.println("学生修改成功");
			}
			//测试查询
			System.out.print("ID=2的学生");
			stu_select=op1.getStudent(2);
			System.out.println(stu_select);*/
	//	}
}


