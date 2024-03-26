package tuan2;

import java.util.Scanner;



public class KiemThuAccount {
static AccountArray accountList;
public static void main(String[] args) throws Exception {
	System.out.println("Chương trình Account");
	accountList =new AccountArray();
	int choice;
	 Account[] dsAccount;
do {
		
		choice=menu();
		switch(choice)
		{
			case 1:
			{
				createDefaultAccountList();
				dsAccount=accountList.getAccounts();
				displayTitle();
				displayAccount(dsAccount);
				break;
			}
			case 2:
			{
				Account AccMoiThem= createAccount();
				accountList.add(AccMoiThem);
				displayTitle();
				dsAccount=accountList.getAccounts();
				displayAccount(dsAccount);
				break;
			}
			case 3:
			{
				updateAccount();
				dsAccount=accountList.getAccounts();
				System.out.println("Tài khoản sau khi cập nhật!");
				displayTitle();
				displayAccount(dsAccount);
				break;
			}
			case 4:
			{
				deleteAccount();
				break;
				
			}
			case 5:
			{
				System.out.println("Mảng sau khi sắp xếp:\n");
				dsAccount=accountList.sortByaccountNumberCompartor();
				displayTitle();
				displayAccount(dsAccount);
				break;
			}
			case 6:
			{
				displayTitle();
				dsAccount=accountList.getAccounts();
				displayAccount(dsAccount);
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
public static void displayTitle() {
	String title=String.format("\t%-7s %-15s %-15s %-15s %-15s","STT", "Số tài khoản","Họ và tên","Số dư");
	System.out.println(title);
	
}
public static void createDefaultAccountList() throws Exception{
	Account Acc1= new Account(101010232,"Triệu Thạnh",9999999);
	Account Acc2= new Account(101015675,"Hoàng Phúc",9969999);
	Account Acc3= new Account(101018998,"Duy Điền",9999979);
	Account Acc4= new Account(101010000,"Nguyển",9999995);
	accountList.add(Acc1);
	accountList.add(Acc2);
	accountList.add(Acc3);
	accountList.add(Acc4);
	
}
public static Account createAccount() throws Exception{
	Account acc;
	long accountNumber;
	String name;
	double balance;
	accountNumber=inputlong("Nhập số tài khoản: ");
	while(accountList.isExistingAccNumber(accountNumber))
	{
		System.out.println("Số tài khoản đã tồn tại!");
		accountNumber=inputlong("Vui lòng nhập lại: ");
	}
	name=inputString("Nhập tên tài khoản: ");
	balance=inputDouble("Nhập số dư tài khoản: ");
	acc =new Account(accountNumber,name,balance);
	return acc;
	
	
}
public static void deleteAccount()throws Exception{
	long accountNumber=inputlong("Nhập số tài khoản cần xóa: ");
	Account acc=accountList.searchAccount(accountNumber);
	if(acc!=null)
	{
		String confirm=inputString("\n Bạn có chắc chắn muốn xóa tài khoản không? (y/Y): ");
		if(confirm.equalsIgnoreCase("y"))
		{
			accountList.deleteAccount(accountNumber);
			System.out.println("Đã xóa thành công!");
			
		}
		else {
			System.out.println("Xóa thất bại!");
		}
		
	}
	else {
	System.out.println("Không tìm thấy tài khoản!");
	}
}
public static void updateAccount() throws Exception{
	long accountNumber=inputlong("\n Nhập số tài khoản cần sửa: ");
	Account acc=accountList.searchAccount(accountNumber);
	int index=accountList.searchIndexOfAccount(accountNumber);
	if(acc!=null) {
		System.out.println("\nTrước khi sửa: ");
		
		displayTitle();
		System.out.printf("\n \t %-7d ",index);
		System.out.println(acc);
		String name=inputString("\n Nhập lại tên tài khoản: ");
		double balance= inputDouble("Nhập số dư mới: ");
		acc.setTenTaiKhoan(name);
		acc.setSoTienTrongTK(balance);
		accountList.update(acc);
		
	}
	else {
		System.out.println("Không tìm thấy tài khoản để sửa!");
	}
}

public static long inputlong(String str)
{
	System.out.println(str);
	Scanner scn= new Scanner(System.in);
	long x;
	x=scn.nextLong();
	return x;
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
					+ "1.Nhập cứng\n"
					+ "2.Thêm tài khoản\n"
					+ "3.Sửa tài khoản\n"
					+ "4.Xóa tài khoản\n"
					+ "5.Sắp xếp\n"
					+ "6.Xuất danh sách tài khoản\n"
					+ "7.Thoát\n");
do {
		a=nhapsonguyen("Nhập lựa chọn: ");
		if(a>=8||a<=0)
		{
			System.out.println("Không hợp lệ ! Yêu cầu nhập lại! ");
		}
}
while(a<=0&&a>=8);

	return a;
}
public static void displayAccount(Account[] list) {
	for(int i=0;i<accountList.SPTT;i++)
	{
		System.out.printf("\t %-7d ",i+1);
		System.out.println(list[i]);
	}
}
}

