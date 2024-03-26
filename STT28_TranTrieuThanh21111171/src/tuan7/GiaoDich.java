package tuan7;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class GiaoDich {
	protected String maGd;
	protected LocalDate ngayGD;
	protected double donGia;
	protected double dienTich;
	public abstract double thanhTien();
	public String getMaGd() {
		return maGd;
	}
	public void setMaGd(String maGd) {
		this.maGd = maGd;
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
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maGd == null) ? 0 : maGd.hashCode());
		return result;
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
		if (maGd == null) {
			if (other.maGd != null)
				return false;
		} else if (!maGd.equals(other.maGd))
			return false;
		return true;
	}
	public GiaoDich(String maGd, LocalDate ngayGD, double donGia, double dienTich) {
		super();
		this.maGd = maGd;
		this.ngayGD = ngayGD;
		this.donGia = donGia;
		this.dienTich = dienTich;
	}
	public GiaoDich() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String ngayGiaoDich=ngayGD.format(dateFormatter);
		Locale localeVN=new Locale("vi","VN");
		String str= String.format("%-15s%-18s%-18.2f%-16.2f", getMaGd(),ngayGiaoDich,getDonGia(),getDienTich());
		return str;
	}

}
