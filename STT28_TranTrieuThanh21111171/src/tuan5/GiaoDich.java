package tuan5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class GiaoDich {
	protected int maGD, soLuong;
	protected LocalDate ngayGD;
	protected double donGia;
	public int getMaGD() {
		return maGD;
	}
	public void setMaGD(int maGD) {
		this.maGD = maGD;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public LocalDate getNgayGD() {
		return ngayGD;
	}
	public void setNgayGD(LocalDate ngayGD) {
		this.ngayGD = ngayGD;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public GiaoDich(int maGD, int soLuong, LocalDate ngayGD, double donGia) {
		super();
		this.maGD = maGD;
		this.soLuong = soLuong;
		this.ngayGD = ngayGD;
		this.donGia = donGia;
	}
	public GiaoDich() {
		super();
	}
	@Override
	public int hashCode() {
	    return Objects.hash(maGD);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    GiaoDich other = (GiaoDich) obj;
	    return maGD == other.maGD;
	}
	public abstract double getThanhTien();
	@Override
	public String toString() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String manufacturingDateString = ngayGD.format(dateFormatter);
	    String str = String.format("%-20d %-20d %-20s %-20f ", getMaGD(), getSoLuong(),manufacturingDateString, getDonGia());
		return str;
	}
}
