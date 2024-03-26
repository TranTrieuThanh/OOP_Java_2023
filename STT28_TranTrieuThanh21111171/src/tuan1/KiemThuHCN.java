package tuan1;

import java.util.Scanner;

public class KiemThuHCN {
public static void main(String[] args) {
	try
	{
		System.out.println("Chương trình tính chu vi và diện tích hình chủ nhật");
		int choice;
do {
			
			choice=menu();
			switch(choice)
			{
				case 1:
				{
					xuatTieuDeCot();
					nhapCung();
					break;
				}
				case 2:
				{
					HinhChuNhat cn1= nhapMemHinhCN();
					xuatTieuDeCot();
					System.out.println(cn1);
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
	catch(Exception err)
	{
		System.out.println("Có lỗi trong việc chọn Menu");
	}
}

static void nhapCung()
{
	HinhChuNhat cn2= new HinhChuNhat(15,10);
	System.out.println(cn2);
	HinhChuNhat cn3= new HinhChuNhat(20,13);
	System.out.println(cn3);
	
}
static int nhapsonguyen(String str)
{
	System.out.println(str);
	int x;
	Scanner scn=new Scanner(System.in);
	 x= scn.nextInt();
	 return x;
}
static HinhChuNhat nhapMemHinhCN()
{
	int cr=nhapsonguyen("Nhap chieu rong: ");
	int cd=nhapsonguyen("Nhap chieu dai: ");
	HinhChuNhat cn1 =new HinhChuNhat();
	cn1.setChieuDai(cd);
	cn1.setChieuRong(cr);
	return cn1;
}
public static int menu() {
	int a;
	System.out.println("*****MENU*****\n"
					+ "1.Nhập cứng\n"
					+ "2.Nhập mềm\n"
					+ "3.Thoát\n");
do {
		a=nhapsonguyen("Nhập lựa chọn: ");
		if(a>=4)
		{
			System.out.println("Không hợp lệ ! Yêu cầu nhập lại! ");
		}
}
while(a<=0&&a>=4);

	return a;
}
static void xuatTieuDeCot() {
	System.out.println("Chiều dài\tChiều rộng\tChu vi \t Diện tích\t\n");
}
}

