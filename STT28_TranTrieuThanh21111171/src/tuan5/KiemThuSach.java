package tuan5;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class KiemThuSach {
	static DanhSachSach sachtList;
	public static void main(String[] args) throws Exception {
		System.out.println("Chương trình Quản lý sách!");
		sachtList =new DanhSachSach();
		int choice;
		 
	do {
			
			choice=menu();
			switch(choice)
			{
				case 1:
				{
				   createDefault();
					System.out.println("Danh sách Sách Giáo Khoa");
					displayTitleGK();;
					displaySach(sachtList.getDanhSachGiaoKhoa());
					System.out.println("Danh sách Sách Tham Khảo");
					displayTitleTK();;
					displaySach(sachtList.getDanhSachThamKhao());
					break;
				}
				case 2:
				{
					Sach book= createSach();
					sachtList.addBook(book);
					System.out.println("Danh sách Sách Giáo Khoa");
					displayTitleGK();;
					displaySach(sachtList.getDanhSachGiaoKhoa());
					System.out.println("Danh sách Sách Tham Khảo");
					displayTitleTK();;
					displaySach(sachtList.getDanhSachThamKhao());
					break;
				}
				case 3:
				{
					System.out.printf("Tổng tiền của sách giáo khoa: %.2f\n",sachtList.totalSachGK());
					System.out.printf("Tổng tiền của sách tham khảo: %.2f\n ",sachtList.totalSachTK());
					break;
				}
				case 4:
				{
					System.out.printf("Trung bình cộng đơn giá của các sách tham khảo: %.2f\n",sachtList.avgSachThamKhao());;
					break;
					
				}
				case 5:
				{
					SGKofnhaxuatban();
					break;
				}
				case 6:
				{
					System.out.println("Danh sách Sách Giáo Khoa");
					displayTitleGK();;
					displaySach(sachtList.getDanhSachGiaoKhoa());
					System.out.println("Danh sách Sách Tham Khảo");
					displayTitleTK();;
					displaySach(sachtList.getDanhSachThamKhao());
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
	public static void displayTitleGK() {
		String title=String.format("\t%-7s %-12s %-12s %-12s %-12s %-18s %-12s","STT", "Mã Sách","Ngày nhập","Đơn giá","Số lượng","Nhà xuất bản","Tình trạng");
		System.out.println(title);
	}
	public static void displayTitleTK() {
		String title=String.format("\t%-7s %-12s %-12s %-12s %-12s %-18s %-12s","STT", "Mã Sách","Ngày nhập","Đơn giá","Số lượng","Nhà xuất bản","Thuế");
		System.out.println(title);
	}
	public static void displaySach(List<Sach> list) {
		int i=0;
			for(Sach book: list) {
				i++;
					System.out.printf("\t %-7d ",i);
					System.out.println(book);
				
				
			}
		
	}
	public  static void createDefault() throws Exception {
		Sach book1= new SachGiaoKhoa("TOAN",LocalDate.of(2023, 1, 14),17000, 3,"Tuấn Khang", true);
		Sach book2= new SachGiaoKhoa("VAN",LocalDate.of(2021, 2, 19),17000, 3,"Tuấn Khang", false);
		Sach book3= new SachThamKhao("TINHOC",LocalDate.of(2021, 2, 19),13000, 3,"Nobel", 3000);
		Sach book4= new SachThamKhao("DIA",LocalDate.of(2023, 10, 1),24000, 3,"AKAKA", 7000);
		sachtList.addBook(book1);
		sachtList.addBook(book2);
		sachtList.addBook(book3);
		sachtList.addBook(book4);
	}
	public static Sach createSach() {
		Sach book;
		String maSach=inputString("Nhập mã sách: ");
		 LocalDate ngayNhap= nhapNgay("Nhập ngày nhập hàng: ");
		double donGia= inputDouble("Nhập đơn giá: ");
		int soLuong =nhapsonguyen("Nhập số lượng: ");
		String nhaXB = inputString("Nhập tên nhà xuất bản: ");
		String chon;
		chon=inputString("Nhập thông tin cho sách giáo khoa(GK) hay tham khảo(TK): ");
		if(chon.equalsIgnoreCase("GK")) 
		{
			boolean tinhtrang = inputBoolean("Nhập tình trạng(true/false):");
			book= new SachGiaoKhoa(maSach,ngayNhap,donGia,soLuong,nhaXB,tinhtrang);
		}
		else
		{
			double thue= inputDouble("Nhập thuế: ");
			book = new SachThamKhao(maSach,ngayNhap,donGia,soLuong,nhaXB,thue);
		}
		return book;
	}
	public static void SGKofnhaxuatban()
	{
		String name= inputString("Nhập tên của nhà xuất bản: ");
		for (Sach book: sachtList.getDanhSach())
		{
			if(book instanceof SachGiaoKhoa)
			{
				SachGiaoKhoa books = (SachGiaoKhoa) book;
				if(books.getNhaXB().equals(name))
				{
					String title=String.format(" %-12s %-12s %-12s %-12s %-18s %-12s", "Mã Sách","Ngày nhập","Đơn giá","Số lượng","Nhà xuất bản","Tình trạng");
					System.out.println(title);
					System.out.println(books);
				}
			}
		}
	}
	public static boolean inputBoolean(String str)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(str);
		boolean x;
		x= scanner.nextBoolean();
		return x;
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
						+ "3.Tổng thành tiền cho từng loại\n"
						+ "4.Trung bình cộng đơn giá của các sách tham khảo\n"
						+ "5.Xuất ra các sách giáo khoa của nhà xuất bản X\n"
						+ "6.Xuất danh sách Sách\n"
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
