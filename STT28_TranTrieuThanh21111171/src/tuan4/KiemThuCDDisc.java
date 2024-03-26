package tuan4;

import java.util.Scanner;

public class KiemThuCDDisc {
static CDDiscArray discList;
public static void main(String[] args) throws Exception {
	System.out.println("Chương trình CD");
	discList =new CDDiscArray();
	int choice;
	 CDDisc[] dsDisc;
do {
		
		choice=menu();
		switch(choice)
		{
			case 1:
			{
				CDDisc disc =createCD();
				discList.add(disc);
				dsDisc=discList.getDiscs();
				displayTitle();
				displayCD(dsDisc);
				break;
			}
			case 2:
			{
				System.out.printf("Tổng số lượng CD có trong danh sách: %d\n",discList.totalCD());
				break;
			}
			case 3:
			{
				System.out.printf("Tổng giá thành của các CD : %.2f\n" ,discList.totalPrice());
				break;
			}
			case 4:
			{
				dsDisc=discList.sortByCDCodeCompartor();
				System.out.println("Mảng CD sắp xếp giảm dần theo giá\n");
				displayTitle();
				displayCD(dsDisc);
				break;
				
			}
			case 5:
			{
				dsDisc=discList.sortByCDName();
				System.out.println("Mảng CD sắp xếp tăng dần theo tựa CD\n");
				displayTitle();
				displayCD(dsDisc);
				break;
			}
			case 6:
			{
				displayTitle();
				dsDisc=discList.getDiscs();
				displayCD(dsDisc);
				break;
			}
			case 7:
			{
				System.out.println("Kết thúc chương trình!");
				break;
			}
			
		}
}while(choice != 7);
}
public static CDDisc createCD() throws Exception {
	CDDisc disc;
	 int CDCode;
	 String CDName,Singer;
	 int numberSong;
	 double Price;
	 CDCode=inputInt("Nhập mã CD: ");
	 while(discList.isExistingCDCode(CDCode))
	 {
		 CDCode=inputInt("Trùng mã, nhập lại: ");
	 }
	 CDName=inputString("Nhập tựa CD: ");
	 Singer=inputString("Nhập tên ca sĩ: ");
	 numberSong=inputInt("Nhập số lượng bài hát: ");
	 Price=inputDouble("Nhập giá thành: ");
	 disc= new CDDisc(CDCode,CDName,Singer,numberSong,Price);
	 return disc;
}


public static void displayTitle() {
	String title=String.format("\t%-7s %-15s %-15s %-15s %-15s %-15s","STT", "Mã CD","Tựa CD","Ca Sĩ","Số lượng","Giá thành\n");
	System.out.println(title);
}
public static void displayCD(CDDisc[] list) {
	for(int i=0;i<discList.SPTT;i++)
	{
		System.out.printf("\t %-7d ",i+1);
		System.out.println(list[i]);
	}
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
static int inputInt(String str)
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
					+ "1.Thêm CD\n"
					+ "2.Tính số lượng CD có trong danh sách\n"
					+ "3.Tổng giá thành các CD\n"
					+ "4.Sắp xếp danh sách giảm dần theo giá thành\n"
					+ "5.Sắp xếp danh sách tăng dần theo tựa CD\n"
					+ "6.Xuất danh sách CD\n"
					+ "7.Thoát\n");
do {
		a=inputInt("Nhập lựa chọn: ");
		if(a>=8||a<=0)
		{
			System.out.println("Không hợp lệ ! Yêu cầu nhập lại! ");
		}
}
while(a<=0&&a>=8);

	return a;
}
}
