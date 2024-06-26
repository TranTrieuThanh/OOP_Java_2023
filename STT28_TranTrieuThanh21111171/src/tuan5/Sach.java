package tuan5;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class Sach {
protected String maSach;
protected LocalDate ngayNhap;
protected double donGia;
protected int soLuong;
protected String nhaXB;
public String getMaSach() {
	return maSach;
}
public void setMaSach(String maSach) {
	this.maSach = maSach;
}
public LocalDate getNgayNhap() {
	return ngayNhap;
}
public void setNgayNhap(LocalDate ngayNhap) {
	this.ngayNhap = ngayNhap;
}
public double getDonGia() {
	return donGia;
}
public void setDonGia(double donGia) {
	this.donGia = donGia;
}
public int getSoLuong() {
	return soLuong;
}
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}
public String getNhaXB() {
	return nhaXB;
}
public void setNhaXB(String nhaXB) {
	this.nhaXB = nhaXB;
}
@Override
public int hashCode() {
	return Objects.hash(maSach);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Sach other = (Sach) obj;
	return Objects.equals(maSach, other.maSach);
}
public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXB) {
	super();
	this.maSach = maSach;
	this.ngayNhap = ngayNhap;
	this.donGia = donGia;
	this.soLuong = soLuong;
	this.nhaXB = nhaXB;
}
public Sach() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String importDateString =ngayNhap.format(dateFormatter);
	Locale localeVN=new Locale("vi","VN");
	
	String str= String.format("%-10s%-14s%-18.2f%-10d%-10s", getMaSach(),importDateString,getDonGia(),getSoLuong(),getNhaXB());
	return str;
}

}
