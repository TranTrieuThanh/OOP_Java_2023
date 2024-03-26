package tuan5;

import java.util.List;
import java.util.Scanner;

public class KiemThuChuyenXe {
	static DanhSachChuyenXe chuyenxetList;
	public static void main(String[] args) throws Exception {
		System.out.println("Chương trình Chuyến xe!");
		chuyenxetList =new DanhSachChuyenXe();
		int choice;
		 
	do {
			
			choice=menu();
			switch(choice)
			{
				case 1:
				{
				   createDefault();
					System.out.println("Danh sách chuyến xe nội thành");
					displayTitleNoiThanh();
					displayChuyenXe(chuyenxetList.getDanhSachNoiThanh());
					System.out.println("Danh sách chuyến xe ngoại thành");
					displayTitleNgoaiThanh();
					displayChuyenXe(chuyenxetList.getDanhSachNgoaiThanh());
				   
					break;
				}
				case 2:
				{
					ChuyenXe cx1= createChuyenXe();
					chuyenxetList.addChuyenXe(cx1);
					System.out.println("Danh sách chuyến xe nội thành");
					displayTitleNoiThanh();
					displayChuyenXe(chuyenxetList.getDanhSachNoiThanh());
					System.out.println("Danh sách chuyến xe ngoại thành");
					displayTitleNgoaiThanh();
					displayChuyenXe(chuyenxetList.getDanhSachNgoaiThanh());
					break;
				}
				case 3:
				{
					deleteChuyenXe();
					break;
				}
				case 4:
				{
					updateChuyenXe();
					break;
					
				}
				case 5:
				{
					System.out.println("Sắp xếp danh sách theo doanh thu: \n");
					chuyenxetList.sortTheoDoanhThu();
					System.out.println("Danh sách chuyến xe nội thành");
					displayTitleNoiThanh();
					displayChuyenXe(chuyenxetList.getDanhSachNoiThanh());
					System.out.println("Danh sách chuyến xe ngoại thành");
					displayTitleNgoaiThanh();
					displayChuyenXe(chuyenxetList.getDanhSachNgoaiThanh());
					
					break;
				}
				case 6:
				{
					System.out.println("Danh sách chuyến xe nội thành");
					displayTitleNoiThanh();
					displayChuyenXe(chuyenxetList.getDanhSachNoiThanh());
					System.out.println("Danh sách chuyến xe ngoại thành");
					displayTitleNgoaiThanh();
					displayChuyenXe(chuyenxetList.getDanhSachNgoaiThanh());
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
	public static void displayTitleNoiThanh() {
		String title=String.format("\t%-7s %-18s %-22s %-18s %-18s %-10s %10s","STT", "Mã Chuyến xe","Tên tài xế","Số xe","Doanh thu","Số tuyến","Số Km");
		System.out.println(title);
	}
	public static void displayTitleNgoaiThanh() {
		String title=String.format("\t%-7s %-18s %-22s %-18s %-18s %-10s %10s","STT", "Mã Chuyến xe","Tên tài xế","Số xe","Doanh thu","Nơi đến","Số Ngày đi được");
		System.out.println(title);
	}
	public static void displayChuyenXe(List<ChuyenXe> list) {
		int i=0;
			for(ChuyenXe cx: list) {
				i++;
					System.out.printf("\t %-7d ",i);
					System.out.println(cx);
				
				
			}
		
	}
	public  static void createDefault() throws Exception {
		ChuyenXe nt= new NoiThanh("CX001","Nguyễn Đăng Nguyển", 1,160000,3,100);
		ChuyenXe ngt= new NgoaiThanh("CX002","Tuấn Khang", 1,190000,"Bến Thành",4);
		ChuyenXe ngt1= new NgoaiThanh("CX003","Duy Điền ", 1,150000,"Bến Tre",10);
		ChuyenXe nt1= new NoiThanh("CX004","Phúc Phông Phanh", 1,186000,3,100);
		chuyenxetList.addChuyenXe(nt);
		chuyenxetList.addChuyenXe(nt1);
		chuyenxetList.addChuyenXe(ngt);
		chuyenxetList.addChuyenXe(ngt1);
		
	}
	public static ChuyenXe createChuyenXe() {
		ChuyenXe cx;
		String maChuyenxe,tenTaixe;
		int Soxe;
		double Doanhthu;
		maChuyenxe=inputString("Nhập Mã chuyến xe: ");
		tenTaixe=inputString("Nhập tên tài xế: ");
		Soxe=nhapsonguyen("Nhập số xe: ");
		Doanhthu=inputDouble("Nhập doanh thu: ");
		String chon;
		chon=inputString("Nhập thông tin cho chuyến xe nội thành(NT) hay ngoại thành(NGT): ");
		if(chon.equalsIgnoreCase("NT")) 
		{
			int soTuyen,soKm;
			soTuyen=nhapsonguyen("Nhập số tuyến: ");
			soKm=nhapsonguyen("Nhập số Km: ");
			cx= new NoiThanh(maChuyenxe,tenTaixe,Soxe,Doanhthu,soTuyen,soKm);
		}
		else
		{
			String noiDen;
			int soNgayDiDuoc;
			noiDen=inputString("Nhập nơi đến: ");
			soNgayDiDuoc=nhapsonguyen("Nhập số ngày đi được: ");
			cx= new NgoaiThanh(maChuyenxe,tenTaixe,Soxe,Doanhthu,noiDen,soNgayDiDuoc);
		}
		return cx;
	}
	public static void deleteChuyenXe() throws Exception
	{
		String maChuyenxe= inputString("Nhập mã chuyến xe: ");
		ChuyenXe cx = chuyenxetList.findChuyenXe(maChuyenxe);
		if(cx!=null)
		{
			String choice= inputString("Bạn có chắc chắn muốn xóa không ? (y/n): ");
			if(choice.equalsIgnoreCase("y"))
			{
				chuyenxetList.deleteChuyenXe(cx);
				System.out.println("Xóa thành công!");
				
			}
			else
			{
				System.out.println("Xóa thất bại!");
			}
		}
		else {
			System.out.println("Không tìm thấy chuyến xe!\n");
		}
	}
	public static void updateChuyenXe() throws Exception {
		String maChuyenxe= inputString("Nhập mã chuyến xe: ");
		ChuyenXe cx = chuyenxetList.findChuyenXe(maChuyenxe);
		
		if(cx!=null)
		{
			System.out.println("Thông tin trước khi sửa:\n");
			if(cx instanceof NoiThanh)
			{
		NoiThanh xes = (NoiThanh)cx;
		String title=String.format(" %-18s %-22s %-18s %-18s %-10s %10s", "Mã Chuyến xe","Tên tài xế","Số xe","Doanh thu","Số tuyến","Số Km");
		System.out.println(title);
				System.out.println("\t\t"+ xes);
				String tenTaixe;
				int Soxe;
				double Doanhthu;
				tenTaixe=inputString("Nhập tên tài xế: ");
				Soxe=nhapsonguyen("Nhập số xe: ");
				Doanhthu=inputDouble("Nhập doanh thu: ");
				int soTuyen,soKm;
				soTuyen=nhapsonguyen("Nhập số tuyến: ");
				soKm=nhapsonguyen("Nhập số Km: ");
				xes.setTenTaixe(tenTaixe);
				xes.setSoxe(Soxe);
				xes.setDoanhthu(Doanhthu);
				xes.setSoTuyen(soTuyen);
				xes.setSoKm(soKm);
			}
			else
			{
				NgoaiThanh xes= (NgoaiThanh)cx;
				String title=String.format("%-18s %-22s %-18s %-18s %-10s %10s", "Mã Chuyến xe","Tên tài xế","Số xe","Doanh thu","Nơi đến","Số Ngày đi được");
				System.out.println(title);
				System.out.println("\t\t"+xes);
				String tenTaixe;
				int Soxe;
				double Doanhthu;
				tenTaixe=inputString("Nhập tên tài xế: ");
				Soxe=nhapsonguyen("Nhập số xe: ");
				Doanhthu=inputDouble("Nhập doanh thu: ");
				String noiDen;
				int soNgayDiDuoc;
				noiDen=inputString("Nhập nơi đến: ");
				soNgayDiDuoc=nhapsonguyen("Nhập số ngày đi được: ");
				xes.setTenTaixe(tenTaixe);
				xes.setSoxe(Soxe);
				xes.setDoanhthu(Doanhthu);
				xes.setNoiDen(noiDen);
				xes.setSoNgayDiDuoc(soNgayDiDuoc);
			}
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
						+ "3.Xóa chuyến xe\n"
						+ "4.Sửa chuyến xe\n"
						+ "5.Sắp xếp\n"
						+ "6.Xuất danh sách chuyến xe\n"
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
