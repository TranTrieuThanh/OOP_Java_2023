package tuan7;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class KiemThuGiaoDich {
	static DanhSachGiaoDich giaodichtList;
	public static void main(String[] args) throws Exception {
		System.out.println("Chương trình Quản lý Giao Dịch!");
		giaodichtList =new DanhSachGiaoDich();
		int choice;
		 
	do {
			
			choice=menu();
			switch(choice)
			{
				case 1:
				{
				   createDefault();
					System.out.println("Danh sách Giao dịch đất: \n");
					displayTitleDat();
					displayGiaoDich(giaodichtList.getDanhSachGDDat());
					System.out.println("Danh sách Giao dịch nhà\n");
					displayTitleNha();
					displayGiaoDich(giaodichtList.getDanhSachGDNha());
					break;
				}
				case 2:
				{
					GiaoDich giaodich= createGiaoDich();
					giaodichtList.addGiaoDich(giaodich);
					System.out.println("Danh sách Giao dịch đất: \n");
					displayTitleDat();;
					displayGiaoDich(giaodichtList.getDanhSachGDDat());
					System.out.println("Danh sách Giao dịch nhà\n");
					displayTitleNha();;
					displayGiaoDich(giaodichtList.getDanhSachGDNha());
					break;
				}
				case 3:
				{
					System.out.println("Danh Sách các giao dịch\n");
					System.out.println("Danh sách Giao dịch đất: \n");
					displayTitleDat();
					displayGiaoDich(giaodichtList.getDanhSachGDDat());
					System.out.println("Danh sách Giao dịch nhà\n");
					displayTitleNha();
					displayGiaoDich(giaodichtList.getDanhSachGDNha());
					break;
				}
				case 4:
				{
					System.out.printf("Số giao dịch đất: %d\n",giaodichtList.tongSoGDDat());
					System.out.printf("Số giao dịch nhà: %d\n",giaodichtList.tongSoGDNha());
					break;
					
				}
				case 5:
				{
					System.out.printf("Trung bình thành tiền của giao dịch đất: %.2f\n",giaodichtList.AvgThanhTienDat());
					break;
				}
				case 6:
				{
					DanhSachGDThang9();
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
	public static void displayTitleDat() {
		String title=String.format("\t%-7s %-15s %-18s %-15s %-12s %-18s","STT", "Mã Giao dịch","Ngày giao dịch","Đơn giá","Diện tích","Loại đất");
		System.out.println(title);
	}
	public static void displayTitleNha() {
		String title=String.format("\t%-7s %-15s %-18s %-15s %-15s %-15s %-12s","STT", "Mã Giao dịch","Ngày giao dịch","Đơn giá","Diện tích","Loại nhà ","Địa chỉ");
		System.out.println(title);
	}
	public static void displayGiaoDich(List<GiaoDich> list) {
		int i=0;
			for(GiaoDich giaoDich: list) {
				i++;
					System.out.printf("\t %-7d ",i);
					System.out.println(giaoDich);
				
				
			}
		
	}
	public  static void createDefault() throws Exception {
		GiaoDich giaodich1= new GiaoDichDat("A004",LocalDate.of(2023, 9, 14) , 1300000000, 500, "A");
		GiaoDich giaodich2= new GiaoDichDat("A001",LocalDate.of(2013, 9, 30) , 1200000000, 300, "B");
		GiaoDich giaodich3= new GiaoDichDat("A007",LocalDate.of(2022, 12, 14) , 130000000, 400, "c");
		GiaoDich giaodich4= new GiaoDichNha("A009",LocalDate.of(2023, 9, 14) , 1400000000, 200, "Cao cấp", "12 Nguyễn Văn Bảo,GV");
		GiaoDich giaodich5= new GiaoDichNha("A002",LocalDate.of(2022, 9, 14) , 1300000000, 400, "Cao cấp", "24 Nguyễn Văn Bảo,GV");
		GiaoDich giaodich6= new GiaoDichNha("A005",LocalDate.of(2013, 9, 21) , 100000000, 200, "Thường", "14/12 Nguyễn Văn Bảo,GV");
		giaodichtList.addGiaoDich(giaodich1);
		giaodichtList.addGiaoDich(giaodich2);
		giaodichtList.addGiaoDich(giaodich3);
		giaodichtList.addGiaoDich(giaodich4);
		giaodichtList.addGiaoDich(giaodich5);
		giaodichtList.addGiaoDich(giaodich6);
	}
	public static GiaoDich createGiaoDich() throws Exception {
		GiaoDich giaodich;
		String maGd=inputString("Nhập mã giao dịch: ");
		LocalDate ngayGD=nhapNgay("Nhập ngày giao dịch: ");
		double donGia=inputDouble("Nhập đơn giá: ");
		double dienTich=inputDouble("Nhập diện tích: ");
		String chon;
		chon=inputString("Nhập thông tin cho giao dịch đất(GDD) hay giao dịch nhà(GDN): ");
		if(chon.equalsIgnoreCase("GDD")) 
		{
			
			String typeDat=inputString("Nhập loại đất: ");
			giaodich = new GiaoDichDat(maGd, ngayGD, donGia, dienTich, typeDat);
		}
		else
		{
			String typeNha=inputString("Nhập loại nhà: ");
			String address= inputString("Nhập địa chỉ: ");
			giaodich= new GiaoDichNha(maGd, ngayGD, donGia, dienTich, typeNha, address);
		}
		return giaodich;
	}
	
	public static void DanhSachGDThang9()
	{
		System.out.println("Danh sách giao dịch tháng 9 năm 2013:\n");
		System.out.println("Danh sách Giao dịch đất: \n");
		displayTitleDat();;
		displayGiaoDich(giaodichtList.getDanhSachGDNhaThang9());
		System.out.println("Danh sách Giao dịch nhà\n");
		displayTitleNha();;
		displayGiaoDich(giaodichtList.getDanhSachGDNhaThang9());
	}
	public static LocalDate nhapNgay(String str) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(str);
	    System.out.print("Nhập ngày: ");
	    int ngay = scanner.nextInt();

	    System.out.print("Nhập tháng : ");
	    int thang = scanner.nextInt();

	    System.out.print("Nhập năm: ");
	    int nam = scanner.nextInt();

	    
	    LocalDate ngayNhap = LocalDate.of(nam, thang, ngay);
	    return ngayNhap;
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
						+ "2.Nhập mềm\n"
						+ "3.Danh sách giao dịch\n"
						+ "4.Tổng số lượng cho từng loại giao dịch\n"
						+ "5.Trung bình thành tiền của giao dịch đất\n"
						+ "6.Xuất ra các giao dịch của tháng 9 năm 2023\n"
						+ "7.Thoát\n");
	do {
			a=nhapsonguyen("Nhập lựa chọn: ");
			if(a>=8||a<=0)
			{
				System.out.println("Không hợp lệ ! Yêu cầu nhập lại! ");
			}
	}
	while(a<=0||a>=8);

		return a;
	}

}
