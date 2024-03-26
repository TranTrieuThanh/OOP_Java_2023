package tuan5;

import java.time.LocalDate;

public class SachThamKhao extends Sach {
private double thue;

public double getThue() {
	return thue;
}

public void setThue(double thue) {
	this.thue = thue;
}

public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXB, double thue) {
	super(maSach, ngayNhap, donGia, soLuong, nhaXB);
	this.thue = thue;
}

public SachThamKhao() {
	super();
	// TODO Auto-generated constructor stub
}

public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXB) {
	super(maSach, ngayNhap, donGia, soLuong, nhaXB);
	// TODO Auto-generated constructor stub
}
public double thanhTien() {
	double giatien= this.getDonGia();
	int soluong= this.getSoLuong();
	double thue= getThue();
	return soluong*giatien+thue;
}
@Override
public String toString() {
	String str= String.format("%16.2f",getThue());
	return super.toString()+str;
}
}
