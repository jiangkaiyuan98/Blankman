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
		System.out.println("����һ��������"+ (end -begin) +"����" );		
	}
/*@SuppressWarnings("resource")
public static void main(String[] args) {
		
	student_operation op1=new student_operation();
	
	System.out.println("*************ĳĳ����ϵͳ**************");
	System.out.println("�������û���");//1 or 1 =1
	
	Scanner input=new Scanner(System.in);
	String s_id=input.nextLine();
	
	System.out.println("����������");//1' or '1' ='1
	String password = input.nextLine();
	
	//Student stu = op1.login(s_id, password);//ע�����
	Student stu = op1.safe_login(s_id, password);//��ȫ��½����
	
	if(stu!=null) {
		System.out.println("*************ĳĳ����ϵͳ**************");
		System.out.println("��¼�ɹ�");
		Student stu_select=op1.getStudentby_s_id( Integer.parseInt(s_id));
		stu_select=op1.show_student_msg(stu_select.getSchool_id());
		System.out.println("��ѡ�� 1 ����û�     2 ɾ����    3 ��ѯ��  ...");
		System.out.println("************************************");
	}
	
	else {
		System.out.println("*************ĳĳ����ϵͳ**************");
		System.out.println("�Բ���,��¼ʧ��~");
		System.out.println("��ѡ�� 1 �˳�ϵͳ     2 ���µ�¼  " );
		System.out.println("************************************");
	}
	
		/*	
			student_operation op1=new student_operation();
			//��Ӳ���
			Student stu_add=new Student();
			stu_add.setS_id(20166004);
			stu_add.setName("��ʦ��");
			stu_add.setSex("��");
			stu_add.setScore(55);
			
			int result =op1.addStudent(stu_add);
			
			if(result==1) {
				System.out.println("ѧ����ӳɹ�");
			}
			
			//ɾ������
			int result1 =op1.delStudent(1);
			if(result1==1) {
				System.out.println("ѧ��ɾ���ɹ�");
			}
			
			
			//���Բ�ѯ
			System.out.print("ID=2��ѧ��");
			Student stu_select=op1.getStudent(2);
			System.out.println(stu_select);
			
			//�����޸�
			Student stu_update=op1.getStudent(2);
			stu_update.setName("lzl");
			stu_update.setScore(10);
			result=op1.updateStudent(stu_update);
			if(result==1) {
				System.out.println("ѧ���޸ĳɹ�");
			}
			//���Բ�ѯ
			System.out.print("ID=2��ѧ��");
			stu_select=op1.getStudent(2);
			System.out.println(stu_select);*/
	//	}
}


