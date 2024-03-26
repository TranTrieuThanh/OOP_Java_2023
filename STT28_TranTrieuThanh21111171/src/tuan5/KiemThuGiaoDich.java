package tuan5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class KiemThuGiaoDich {
	static DanhSachGiaoDich giaodichtList;
	public static void main(String[] args) {
		System.out.println("Chương trình Quản lý Giao Dịch !");
		giaodichtList = new DanhSachGiaoDich();
		Scanner scn= new Scanner(System.in);
		while (true) {
            System.out.println("Menu:");
            System.out.println("1. Nhập cứng giao dịch");
            System.out.println("2. Xuất giao dịch");
            System.out.println("3. Tổng số lượng giao dịch Vàng");
            System.out.println("4. Tổng số lượng giao dịch Tiền Tệ");
            System.out.println("5. Trung bình thành tiền giao dịch Tiền Tệ");
            System.out.println("6. Hien Thi Danh Sach Giao Dich co Don Gia > 1 tỷ");
            System.out.println("7. Thoát");
            
            int choice = scn.nextInt();
            scn.nextLine(); 
            switch (choice) {
            case 1:
                createDefault();
                break;
            case 2:
                System.out.println("Danh sách giao dịch tiền: \n");
                displayTitleTien();
                displayGiaoDich(giaodichtList.getDanhSachGDTien());
                System.out.println("Danh sách Giao dịch Vaàng\n");
                displayTitleVang();
                displayGiaoDich(giaodichtList.getDanhSachGDVang());
                break;

            case 3:
                int tongTien = giaodichtList.tongGDTien();
                System.out.println("Tổng số lượng giao dịch tiền: " + tongTien);
                break;

            case 4:
                int tongVang = giaodichtList.tongGDVang();
                System.out.println("Tổng số lượng giao dịch vàng: " + tongVang);
                break;

            case 5:
                double trungBinhThanhTienTien = giaodichtList.trungBinhThanhTienGDTien();
                System.out.println("Trung bình thành tiền giao dịch tiền: " + trungBinhThanhTienTien);
                break;

            case 6:
                System.out.println("Các giao dịch Vàng có đơn giiá trên 1 tỷ là:");
                displayTitleVang();
                displayGiaoDich(giaodichtList.xuatGiaoDichDonGiaVang());
                System.out.println("Các giao dịch Vàng có đơn giá trên 1 tỷ là:");
                displayTitleTien();
                displayGiaoDich(giaodichtList.xuatGiaoDichDonGiaTien());
                break;
            case 7:
                System.out.println("Chương trình kết thúc.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                break;
            }
		}	
	}
	public static void displayTitleTien() {
        String title = String.format("\t%-20s %-20s %-20s %-20s %-20s %20s","Mã Giao dịch", "Số lượng", "Ngày giao dịch", "Đơn giá", "Tỉ giá", "Loại tiền tệ", "Thanh Tiền");
        System.out.println(title);
    }

	public static void displayTitleVang() {
	    String title = String.format("\t%-20s %-20s %-20s %-20s %-20s %20s", "Mã Giao dịch","Số lượng", "Ngày giao dịch", "Đơn giá","Loại vàng", "Thanh Tiền");
	    System.out.println(title);
	}
    public static void createDefault() {
        GiaoDichTien gd1 = new GiaoDichTien(1, 100, LocalDate.of(2023, 10, 1), 2000, 1.00f, "VienNam");
        GiaoDichTien gd2 = new GiaoDichTien(2, 200, LocalDate.of(2023, 9, 15), 1000, 0.51f, "USD");
        GiaoDichTien gd3 = new GiaoDichTien(3, 150, LocalDate.of(2023, 11, 5), 200, 0.6f, "Euro");
        GiaoDichVang gd4 = new GiaoDichVang(4, 300, LocalDate.of(2023, 10, 2), 500, "18K");
        GiaoDichVang gd5 = new GiaoDichVang(5, 250, LocalDate.of(2023, 8, 20), 1200, "24K");
        GiaoDichVang gd6 = new GiaoDichVang(6, 200, LocalDate.of(2023, 9, 30), 2000, "9999K");

        giaodichtList.addGiaoDich(gd1);
        giaodichtList.addGiaoDich(gd2);
        giaodichtList.addGiaoDich(gd3);
        giaodichtList.addGiaoDich(gd4);
        giaodichtList.addGiaoDich(gd5);
        giaodichtList.addGiaoDich(gd6);
    }

    public static void displayGiaoDich(ArrayList<GiaoDich> list) {
        int i = 0;
        for (GiaoDich giaoDich : list) {
            i++;
            System.out.printf("\t%-7d ", i);
            System.out.println(giaoDich);
        }
    }
}
