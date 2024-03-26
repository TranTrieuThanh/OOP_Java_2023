package tuan6;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class KiemThuPhong {
	static DanhSachPhong roomList;
	public static void main(String[] args) throws Exception {
		System.out.println("Chương trình Quản lý phòng học!");
		roomList =new DanhSachPhong();
		int choice;
		 
	do {
			
			choice=menu();
			switch(choice)
			{
				case 1:
				{
				   createDefault();
					System.out.println("Danh sách Phòng lý thuyết\n");
					displayTitleLT();;
					displayPhong(roomList.getDanhSachLyThuyet());
					System.out.println("Danh sách Phòng máy tính\n");
					displayTitleMT();;
					displayPhong(roomList.getDanhSachMayTinh());
					System.out.println("Danh sách Phòng thí nghiệm:\n");
					displayTitleTN();;
					displayPhong(roomList.getDanhSachThiNghiem());
					break;
				}
				case 2:
				{
					Phong room = createPhong();
					roomList.addPhong(room);
					System.out.println("Danh sách Phòng lý thuyết\n");
					displayTitleLT();;
					displayPhong(roomList.getDanhSachLyThuyet());
					System.out.println("Danh sách Phòng máy tính\n");
					displayTitleMT();;
					displayPhong(roomList.getDanhSachMayTinh());
					System.out.println("Danh sách Phòng thí nghiệm:\n");
					displayTitleTN();;
					displayPhong(roomList.getDanhSachThiNghiem());
					break;
				}
				case 3:
				{
					findPhongHoc();
					break;
				}
				case 4:
				{
					System.out.println("Danh sách Phòng lý thuyết\n");
					displayTitleLT();;
					displayPhong(roomList.getDanhSachLyThuyet());
					System.out.println("Danh sách Phòng máy tính\n");
					displayTitleMT();;
					displayPhong(roomList.getDanhSachMayTinh());
					System.out.println("Danh sách Phòng thí nghiệm:\n");
					displayTitleTN();;
					displayPhong(roomList.getDanhSachThiNghiem());
					break;
					
				}
				case 5:
				{
					DanhSachPhong list = new DanhSachPhong();
					for(Phong room : roomList.getDanhSach())
					{
						 if(room.DatChuan())
						 {
							 list.addPhong(room);
						 }
					}
					System.out.println("Danh sách phòng đạt chuẩn: ");
					System.out.println("Danh sách Phòng lý thuyết\n");
					if(list.getDanhSachLyThuyet()==null)
					{
						System.out.println("Không có phòng lý thuyết nào đạt chuẩn!\n");
					}
					else
					{
						displayTitleLT();
						displayPhong(list.getDanhSachLyThuyet());
					}
					System.out.println("Danh sách Phòng máy tính\n");
					if(list.getDanhSachMayTinh()==null)
					{
						System.out.println("Không có phòng máy tính nào đạt chuẩn!\n");
					}
					else
					{
					displayTitleMT();;
					displayPhong(list.getDanhSachMayTinh());
					}
					
					System.out.println("Danh sách Phòng thí nghiệm:\n");
					if(list.getDanhSachThiNghiem()==null)
					{
						System.out.println("Không có phòng thí nghiệm nào đạt chuẩn!\n");
					}
					else
					{
					displayTitleTN();;
					displayPhong(list.getDanhSachThiNghiem());
					}
					
					break;
				}
				case 6:
				{
					System.out.println("Sắp xếp tăng theo dãy nhà: \n");
					roomList.sortTheoDayNha();
					System.out.println("Danh sách Phòng lý thuyết\n");
					displayTitleLT();;
					displayPhong(roomList.getDanhSachLyThuyet());
					System.out.println("Danh sách Phòng máy tính\n");
					displayTitleMT();;
					displayPhong(roomList.getDanhSachMayTinh());
					System.out.println("Danh sách Phòng thí nghiệm:\n");
					displayTitleTN();;
					displayPhong(roomList.getDanhSachThiNghiem());
					
					break;
				}
				case 7:
				{
					System.out.println("Sắp xếp giảm theo diện tích: \n");
					roomList.sortDienTich();
					System.out.println("Danh sách Phòng lý thuyết\n");
					displayTitleLT();;
					displayPhong(roomList.getDanhSachLyThuyet());
					System.out.println("Danh sách Phòng máy tính\n");
					displayTitleMT();;
					displayPhong(roomList.getDanhSachMayTinh());
					System.out.println("Danh sách Phòng thí nghiệm:\n");
					displayTitleTN();;
					displayPhong(roomList.getDanhSachThiNghiem());
					break;
				}
				case 8:
				{
					System.out.println("Sắp xếp tăng theo số bóng đèn: \n");
					roomList.sortSoDen();;
					System.out.println("Danh sách Phòng lý thuyết\n");
					displayTitleLT();;
					displayPhong(roomList.getDanhSachLyThuyet());
					System.out.println("Danh sách Phòng máy tính\n");
					displayTitleMT();;
					displayPhong(roomList.getDanhSachMayTinh());
					System.out.println("Danh sách Phòng thí nghiệm:\n");
					displayTitleTN();;
					displayPhong(roomList.getDanhSachThiNghiem());
					break;
				}
				case 9:
				{
					updateComputer();
					break;
				}
				case 10:
				{
					deletePhong();
					break;
				}
case 11:
				{
					System.out.printf("Tổng số phòng học là: %d\n",roomList.tongsoPhong());
					break;
				}
				case 12:
				{
					System.out.println("Danh sách phòng máy tính có 60 máy: \n");
					displayTitleMT();;
					displayPhong(roomList.getPhongMaytinh10May());
					break;
				}
				case 13:
				{
					System.out.println("Kết thúc chương trình!");
					break;
				}
				
			}
	}while(choice != 13);
	}
	public static void displayTitleLT() {
		String title=String.format("\t%-7s %-12s %-12s %-12s %-12s %-18s ","STT", "Mã Phòng","Dãy nhà","Diện tích","Số bóng đèn","Tình trạng máy chiếu");
		System.out.println(title);
	}
	public static void displayTitleMT() {
		String title=String.format("\t%-7s %-12s %-12s %-12s %-12s %-18s ","STT", "Mã Phòng","Dãy nhà","Diện tích","Số bóng đèn","Số máy tính");
		System.out.println(title);
	}
	public static void displayTitleTN() {
		String title=String.format("\t%-7s %-12s %-12s %-12s %-12s %-18s%-12s%-10s ","STT", "Mã Phòng","Dãy nhà","Diện tích","Số bóng đèn","Chuyên ngành","Sức chứa","TT bồn rửa");
		System.out.println(title);
	}
	public static void displayPhong(List<Phong> list) {
		int i=0;
			for(Phong room: list) {
				
				System.out.printf("\t %-7d ",list.indexOf(room)+1);
					System.out.println(room);
				
				
			}
		
	}
	public  static void createDefault() throws Exception {
		Phong room1= new PhongLyThuyet("TOAN", "F", 200, 30, false);
		Phong room2= new PhongLyThuyet("SU", "B", 180, 15, true);
		Phong room3= new PhongMayTinh("H001", "H", 200, 40, 200);
		Phong room4=  new PhongMayTinh("K004", "K",150, 40,20);
		Phong room5= new PhongThiNghiem("D003", "D", 130, 40, "Sinh học", 40, true);
		Phong room6= new PhongThiNghiem("C004", "C", 170, 40, "Sinh học", 30, false);
		roomList.addPhong(room1);
		roomList.addPhong(room2);
		roomList.addPhong(room3);
		roomList.addPhong(room4);
		roomList.addPhong(room5);
		roomList.addPhong(room6);
	}
	public static Phong createPhong()
	{
		Phong room;
		String maPhong;
		String dayNha;
		 double dienTich;
		 int soDen;
		 maPhong=inputString("Nhập mã phòng: ");
		 dayNha=inputString("Nhập dãy nhà: ");
		 dienTich=inputDouble("Nhập diện tích phòng: ");
		 soDen=nhapsonguyen("Nhập số bóng đèn: ");

		 String choice=inputString("Bạn muốn nhập thông tin cho phòng nào?(Phòng LT=PLT; Phòng MT=PMT; Phòng TN=PTN) : ");
		 if(choice.equalsIgnoreCase("PLT"))
		 {
			 boolean mayChieu=inputBoolean("Nhập tình trạng máy chiếu(true/false): ");
			 room= new PhongLyThuyet(maPhong, dayNha, dienTich, soDen, mayChieu);
		 }
		 else
		 {
			 if(choice.equalsIgnoreCase("PMT"))
			 {
				 int computer = nhapsonguyen("Nhập số lượng máy tính: ");
				 room= new PhongMayTinh(maPhong, dayNha, dienTich, soDen, computer);
			 }
			 else
			 {
				 String chuyenNganh=inputString("Nhập chuyên ngành: ");
					 int sucChua= nhapsonguyen("Nhập sức chứa: ");
					 boolean bonRua= inputBoolean("Nhập tình trạng bồn rửa(true/false): ");
					 room = new PhongThiNghiem(maPhong, dayNha, dienTich, soDen, chuyenNganh, sucChua, bonRua);
			 }
		 }
		 return room;
	}
	public static void findPhongHoc() throws Exception
	{
		String maPhong= inputString("Nhập mã phòng cần tìm: ");
		Phong room= roomList.findPhong(maPhong);
		if(room!=null)
		{
			System.out.println("Đã tìm thấy phòng!\n");
			if(room instanceof PhongLyThuyet)
			{
				displayTitleLT();
				System.out.printf("\t%-7d",roomList.getDanhSachLyThuyet().indexOf(room)+1);
				System.out.println(room);
			}
			else
			{
				if(room instanceof PhongMayTinh)
				{
					displayTitleMT();
					System.out.printf("\t%-7d",roomList.getDanhSachMayTinh().indexOf(room)+1);
					System.out.println(room);
				}
				else
				{
					displayTitleTN();
					System.out.printf("\t%-7d",roomList.getDanhSachThiNghiem().indexOf(room)+1);
					System.out.println(room);
				}
			}
		}
		else
		{
			System.out.println("Không tìm thấy phòng!\n");
		}
		
	}
	public static void updateComputer() throws Exception
	{
		String maPhong=inputString("Nhập mã phòng cần sửa: ");
		Phong room= roomList.findPhong(maPhong);
		if(room!=null && room instanceof PhongMayTinh)
		{
			System.out.println("Thông tin phòng trước khi sửa: \n");
			displayTitleMT();
			System.out.printf("\t%-7d",roomList.getDanhSachMayTinh().indexOf(room)+1);
			System.out.println(room);
			PhongMayTinh room1= (PhongMayTinh) room;
			int Computer=nhapsonguyen("Nhập số máy tính cập nhật: ");
			room1.setComputer(Computer);
			System.out.println("Cập nhật thành công!\n");
		}
		else
		{
			System.out.println("Không tìm thấy phòng!\n");
		}
		
		
	}
	public static void deletePhong()throws Exception
	{
		String maPhong=inputString("Nhập mã phòng cần xóa: ");
		Phong room= roomList.findPhong(maPhong);
		if(room!=null)
		{
			System.out.println("Đã tìm thấy phòng: \n");
			if(room instanceof PhongLyThuyet)
			{
				displayTitleLT();
				System.out.printf("\t%-7d",roomList.getDanhSachLyThuyet().indexOf(room)+1);
				System.out.println(room);
			}
			else
			{
				if(room instanceof PhongMayTinh)
				{
					displayTitleMT();
					System.out.printf("\t%-7d",roomList.getDanhSachMayTinh().indexOf(room)+1);
					System.out.println(room);
				}
				else
				{
					displayTitleTN();
					System.out.printf("\t%-7d",roomList.getDanhSachThiNghiem().indexOf(room)+1);
					System.out.println(room);
				}
			}
			String choice= inputString("Bạn có chắc chắn muốn xóa không(y/n): ");
			if(choice.equalsIgnoreCase("y"))
			{
				roomList.deletePhong(room);
				System.out.println("Xóa thành công!\n");
			}
			else
			{
				System.out.println("Xóa thất bại!\n");
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
						+ "3.Tìm kiếm một phòng học nào đó khi biết mã phòng\n"
						+ "4.In toàn bộ danh sách các phòng học\n"
						+ "5.In danh sách các phòng học đạt chuẩn\n"
						+ "6.Sắp xếp danh sách tăng dần theo cột dãy nhà\n"
						+ "7.Sắp xếp danh sách giảm dần theo cột diện tích\n"
						+ "8.Sắp xếp danh sách tăng dần theo cột số bóng đèn\n"
						+ "9.Cập  nhật  số  máy  tính  cho  một  phòng  máy  tính  nào  đó  khi  biết  mã \r\n"
						+ "phòng\n"
						+ "10.Xóa một phòng học nào đó khi biết mã phòng\n"
						+ "11.In ra tổng số phòng học\n"
						+ "12.In danh sách các phòng máy có 60 máy\n"
						+ "13.Thoát\n");
	do {
			a=nhapsonguyen("Nhập lựa chọn: ");
			if(a>=14||a<=0)
			{
				System.out.println("Không hợp lệ ! Yêu cầu nhập lại! ");
			}
	}
	while(a<=0||a>=14);

		return a;
	}

}
