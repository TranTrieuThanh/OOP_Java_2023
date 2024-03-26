package tuan5;

import java.time.LocalDate;

public class SachGiaoKhoa extends Sach {
private boolean tinhTrang;

public boolean isTinhTrang() {
	return tinhTrang;
}

public void setTinhTrang(boolean tinhTrang) {
	this.tinhTrang = tinhTrang;
}

public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXB, boolean tinhTrang) {
	super(maSach, ngayNhap, donGia, soLuong, nhaXB);
	this.tinhTrang = tinhTrang;
}

public SachGiaoKhoa() {
	super();
	// TODO Auto-generated constructor stub
}

public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXB) {
	super(maSach, ngayNhap, donGia, soLuong, nhaXB);
	// TODO Auto-generated constructor stub
}
public double thanhTienGK() {
	int soluong= this.getSoLuong();
	double giatien= this.getDonGia();
	boolean tinhtrang= this.isTinhTrang();
	return tinhtrang? soluong*giatien : soluong*giatien*0.5;
}
@Override
public String toString() {
	String str= String.format("%16b",isTinhTrang());
	return super.toString()+str;
}

}
