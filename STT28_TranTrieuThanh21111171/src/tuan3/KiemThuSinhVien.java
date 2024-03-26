package tuan3;

import java.util.Scanner;

public class KiemThuSinhVien {
static SinhVienArray studentList;
public static void main(String[] args)throws Exception {
	studentList= new SinhVienArray();
	System.out.println("Chương trình quản lý sinh viên");
	int choice;
	 SinhVien[] dsStudent;
do {
		
		choice=menu();
		switch(choice)
		{
			case 1:
			{
				int n;
				n=nhapsonguyen("Nhập số lượng sinh viên: ");
				for(int i=0;i<n;i++)
				{
					System.out.println("Nhập thông tin sinh viên thứ "+ i+":\n");
					studentList.add(createStudent());
					
					
				}
				dsStudent=studentList.getStudents();
				displayTitle();
				displayStudent(dsStudent);
				break;
			}
			case 2:
			{
				dsStudent=studentList.sortByIDStudent();
				System.out.println("Mảng sắp xếp tăng dần theo MSV\n");
				displayTitle();
				displayStudent(dsStudent);
				break;
			}
			case 3:
			{
				System.out.println("Kết thúc chương trình!");
				break;
			}
			
		}
}while(choice != 3);

}
public static String inputString(String str)
{
	System.out.println(str);
	Scanner scn= new Scanner(System.in);
	String x;
	x=scn.nextLine();
	return x;
}
public static double inputDouble(String str)
{
	System.out.println(str);
	Scanner scn= new Scanner(System.in);
	double x;
	x=scn.nextDouble();
	return x;
}
static int nhapsonguyen(String str)
{
	System.out.println(str);
	int x;
	Scanner scn=new Scanner(System.in);
	 x= scn.nextInt();
	 return x;
}
public static int menu() {
	int a;
	System.out.println("*****MENU*****\n"
					+ "1.Nhập sinh viên\n"
					+ "2.Xuất danh sách theo thứ tự tăng dần của msv\n"
					+ "3.Thoát\n");
do {
		a=nhapsonguyen("Nhập lựa chọn: ");
		if(a>=4||a<=0)
		{
			System.out.println("Không hợp lệ ! Yêu cầu nhập lại! ");
		}
}
while(a<=0&&a>=4);

	return a;
}
public static SinhVien createStudent() throws Exception{
	SinhVien sv;
	int IDstudent;
	String studentName,address;
	String phoneNumber;
	IDstudent=nhapsonguyen("Nhập mã sinh viên: ");
	while(studentList.IsExistingIDStudent(IDstudent)) {
	IDstudent=nhapsonguyen("Trùng mã! Nhập lại mã: ");
	}
	studentName=inputString("Nhập tên sinh viên: ");
	address=inputString("Nhập địa chỉ: ");
	phoneNumber=inputString("Nhập số điện thoại: ");
	sv= new SinhVien(IDstudent,studentName,address,phoneNumber);
	return sv;
}
public static void displayTitle() {
	String title=String.format("\t%-7s %-20s %-20s %-20s %-20s","STT", "Mã sinh viên","Họ và tên","Địa chỉ","Số điện thoại");
	System.out.println(title);
}

public static void displayStudent(SinhVien[] list) {
	for(int i=0;i<studentList.SPTT;i++)
	{
		System.out.printf("\t %-7d ",i+1);
		System.out.println(list[i]);
	}
}
}
