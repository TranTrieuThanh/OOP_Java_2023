package tuan1;

import java.util.Scanner;

public class KiemThuSV {
	public static void main(String[] args) {
		SinhVien sv3= nhapMemSV();
		xuatTieuDeCot();
		nhapCungSV();
		System.out.println(sv3);
		
		
		
	}
	static void nhapCungSV() {
		SinhVien sv1= new SinhVien(21117,"thanh",9.3,6.9);
		System.out.println(sv1);
		SinhVien sv2= new SinhVien(21411,"điền",7.7,8.2);
		System.out.println(sv2);
	}
	static SinhVien nhapMemSV() {
		Scanner scn=new Scanner(System.in);
		System.out.println("Nhập Mã SV:");
		int msv= scn.nextInt();
		System.out.println("Nhập họ tên:");
		String hoten=scn.next();
		System.out.println("Nhập điểm thực hành:");
		double diemth=scn.nextDouble();
		System.out.println("Nhập điểm lý thuyết:");
		double diemlt=scn.nextDouble();
		SinhVien sv3=new SinhVien();
		sv3.setMSV(msv);
		sv3.setHoten(hoten);
		sv3.setDiemlt(diemlt);
		sv3.setDiemTH(diemth);
		return sv3;
		
	}
	static void xuatTieuDeCot() {
		System.out.println("MSSV\t Họ tên\t Điểm lý thuyết\t Điểm thực hành\t Điểm trung bình \n");
	}
}
