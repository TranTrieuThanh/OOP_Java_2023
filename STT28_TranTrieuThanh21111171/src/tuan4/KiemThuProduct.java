package tuan4;

import java.time.LocalDate;
import java.util.Scanner;

public class KiemThuProduct {
	static ProductArray productList;
	public static void main(String[] args) throws Exception {
		System.out.println("Chương trình kiểm tra Hàng hóa!");
		productList =new ProductArray();
		int choice;
		 HangThucPham[] dsProduct;
	do {
			
			choice=menu();
			switch(choice)
			{
				case 1:
				{
					createDefaultProductList();
					dsProduct=productList.getProducts();
					displayTitle();
					displayProduct(dsProduct);
					break;
				}
				case 2:
				{
					HangThucPham ProMoiThem= createProduct();
					productList.add(ProMoiThem);
					displayTitle();
					dsProduct=productList.getProducts();
					displayProduct(dsProduct);
					break;
				}
				case 3:
				{
					updateProduct();
					dsProduct=productList.getProducts();
					System.out.println("Hàng hóa sau khi cập nhật!");
					displayTitle();
					displayProduct(dsProduct);
					break;
				}
				case 4:
				{
					deleteProduct();
					break;
					
				}
				case 5:
				{
					System.out.println("Mảng sau khi sắp xếp:\n");
					dsProduct=productList.sortByproductPriceCompartor();
					displayTitle();
					displayProduct(dsProduct);
					break;
				}
				case 6:
				{
					displayTitle();
					dsProduct=productList.getProducts();
					displayProduct(dsProduct);
					break;
				}
				case 7:
				{
					Expiration();
					break;
				}
				case 8:
				{
					System.out.println("Kết thúc chương trình!");
					break;
				}
				
			}
	}while(choice != 8);
	}
	public static void displayTitle() {
		String title=String.format("\t%-7s %-20s %-22s %-20s %-20s %-20s","STT", "Mã hàng","Tên hàng hóa","Giá","Ngày sản xuất","Ngày hết hạn");
		System.out.println(title);
		
	}
	public static void createDefaultProductList() throws Exception{
		HangThucPham pro1 = new HangThucPham("DAUAN","Dầu ăn",17000,LocalDate.of(2023, 1, 14),LocalDate.of(2024, 9, 14));
		HangThucPham pro2 = new HangThucPham("MITOM","Mì tôm",7000,LocalDate.of(2022, 5, 14),LocalDate.of(2023, 2, 14));
		HangThucPham pro3 = new HangThucPham("GAO","Gạo",170000,LocalDate.of(2022, 4, 14),LocalDate.of(2023, 1, 14));
		HangThucPham pro4 = new HangThucPham("DAUGOI","Dầu gội",14000,LocalDate.of(2022, 9, 14),LocalDate.of(2024, 9, 14));
		productList.add(pro1);
		productList.add(pro2);
		productList.add(pro3);
		productList.add(pro4);
		
		
	}
	public static HangThucPham createProduct() throws Exception{
		HangThucPham pro;
		String productCode;
		String name;
		double price;
		productCode=inputString("Nhập mã hàng: ");
		while(productList.isExistingProductCode(productCode))
		{
			System.out.println("Số tài khoản đã tồn tại!");
			productCode=inputString("Nhập lại mã hàng: ");
		}
		name=inputString("Nhập tên hàng hóa: ");
		price=inputDouble("Nhập số tiền: ");
		LocalDate ngaysx,ngayhh;
		
		ngaysx=nhapNgay("Nhập ngày sản xuất: ");
		ngayhh=nhapNgay("Nhập ngày hết hạn: ");
		
		pro =new HangThucPham(productCode,name,price,ngaysx,ngayhh);
		return pro;
		
		
	}
	public static void Expiration() throws Exception{
		String productCode=inputString("Nhập mã hàng cần kiểm tra: ");
		HangThucPham pro=productList.searchProduct(productCode);
		if(pro!=null)
		{
			if(pro.checkExpiration()==1)
			{
				System.out.println("\nSản phẩm này còn hạn!");
			}
			else
			{
				System.out.println("\n Sản phẩm này đã hết hạn");
			}
		}
	}
	public static void deleteProduct()throws Exception{
		String productCode=inputString("Nhập mã hàng cần xóa: ");
		HangThucPham pro=productList.searchProduct(productCode);
		if(pro!=null)
		{
			String confirm=inputString("\n Bạn có chắc chắn muốn xóa tài khoản không? (y/Y): ");
			if(confirm.equalsIgnoreCase("y"))
			{
				productList.deleteProduct(productCode);
				System.out.println("Đã xóa thành công!");
				
			}
			else {
				System.out.println("Xóa thất bại!");
			}
			
		}
		else {
		System.out.println("Không tìm thấy hàng hóa!");
		}
	}
	public static void updateProduct() throws Exception{
		String productCode=inputString("\n Nhập mã hàng cần sửa");
		HangThucPham pro=productList.searchProduct(productCode);
		int index=productList.searchIndexOfProduct(productCode);
		if(pro!=null) {
			System.out.println("\nTrước khi sửa: ");
			displayTitle();
			System.out.printf("\t %-7d ",index);
			System.out.println(pro);
			String name=inputString("\n Nhập lại tên hàng hóa: ");
			double price= inputDouble("Nhập giá mới: ");
			LocalDate ngaysx,ngayhh;
			ngaysx=nhapNgay("Nhập ngày sản xuất mới: ");
			ngayhh=nhapNgay("Nhập ngày hết hạn mới: ");
			pro.setName(name);
			pro.setPrice(price);
			pro.setManufacturingDate(ngaysx);
			pro.setExpirationDate(ngayhh);
			
			productList.update(pro);
			
		}
		else {
			System.out.println("Không tìm thấy tài khoản để sửa!");
		}
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
						+ "2.Thêm hàng hóa\n"
						+ "3.Sửa hàng hóa\n"
						+ "4.Xóa háng hóa\n"
						+ "5.Sắp xếp\n"
						+ "6.Xuất danh sách hàng hóa\n"
						+ "7.Kiểm tra hàng hết hạn\n"
						+ "8.Thoát\n");
	do {
			a=nhapsonguyen("Nhập lựa chọn: ");
			if(a>=9||a<=0)
			{
				System.out.println("Không hợp lệ ! Yêu cầu nhập lại! ");
			}
	}
	while(a<=0&&a>=9);

		return a;
	}
	public static void displayProduct(HangThucPham[] list) {
		for(int i=0;i<productList.SPTT;i++)
		{
			System.out.printf("\t %-7d ",i+1);
			System.out.println(list[i]);
		}
	}
}
