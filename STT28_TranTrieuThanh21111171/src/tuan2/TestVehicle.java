package tuan2;

import java.util.Scanner;

public class TestVehicle {
public static void main(String[] args) {
	

	System.out.println("Chương trình tính thuế xe!");
	int choice;
	Vehicle xe[]=new Vehicle[3];
	do {
		choice=menu();
		
		
		switch(choice)
		{
		case 1:
		{
			for(int i=0;i<3;i++)
			{
				System.out.println("Nhập thông tin xe "+ i +":");
				xe[i]=nhapXe();
			}
		
			break;
		}
		case 2:
		{
			xuatTieuDeCot();
			for(int i=0;i<3;i++)
			{
				System.out.println(xe[i]);
			}
			break;
		}
		case 3:
		{
			System.out.println("Kết thúc chương trình!");
			break;
		}
		}
		
	}while(choice !=3);
}
static int nhapSoNguyen(String str) {
	System.out.println(str);
	Scanner scn=new Scanner(System.in);
	int x;
	x=scn.nextInt();
	return x;
}
static Vehicle nhapXe() {
	String cx,lx;
	int dt;
	long tg;
	Scanner scn=new Scanner(System.in);
	System.out.println("Nhập tên chủ xe:");
	cx=scn.next();
	System.out.println("Nhập loại xe:");
	lx=scn.next();
	dt=nhapSoNguyen("Nhập dung tích xe:");
	System.out.println("Nhập giá tiền xe:");
	tg=scn.nextLong();
	Vehicle xe4= new Vehicle();
	xe4.setTenchuxe(cx);
	xe4.setLoaixe(lx);
	xe4.setDungtich(dt);
	xe4.setTrigia(tg);
	return xe4;
}

public static int menu() {
	int a;
	System.out.println("*****MENU*****\n"
			+ "1.Nhập thông tin xe.\n"
			+ "2.Xuất bảng kê khai tiền thuế.\n"
			+ "3.Thoát!\n");
	do {
		a=nhapSoNguyen("Vui lòng nhập lựa chọn:");
		if(a>=4 || a<=0)
		{
			System.out.println("Chọn lại, lựa chọn không phù hợp!");
		}
	}while(a>=4|| a<=0);
	return a;
}
static void xuatTieuDeCot() {
	System.out.println("Tên chủ xe\t Loại xe\t Dung tích\t Trị giá\t Thuế xe\n");
}
}
