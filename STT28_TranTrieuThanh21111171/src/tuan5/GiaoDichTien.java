package tuan5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GiaoDichTien extends GiaoDich{
	private float tiGia;
	private String loaiTienTe;
	
	
	public String getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(String loaiTienTe) {
		this.loaiTienTe = loaiTienTe;
	}

	public float getTiGia() {
		return tiGia;
	}

	public void setTiGia(float tiGia) {
		this.tiGia = tiGia;
	}

	public GiaoDichTien(int maGD, int soLuong, LocalDate ngayGD, double donGia) {
		super(maGD, soLuong, ngayGD, donGia);
	}

	public GiaoDichTien(int maGD, int soLuong, LocalDate ngayGD, double donGia, float tiGia, String loaiTienTe) {
		super(maGD, soLuong, ngayGD, donGia);
		this.tiGia = tiGia;
		this.loaiTienTe = loaiTienTe;
	}

	@Override
	public double getThanhTien() {
		
		if(loaiTienTe=="VietNam")
			return getSoLuong()*getDonGia();
		
		else {
			return getSoLuong()*getDonGia()*getTiGia();
		}
	}

	@Override
	public String toString() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String manufacturingDateString = ngayGD.format(dateFormatter);
	    String str = String.format("%-20d %-20d %-20s %-20f %-20f %-20s %20f ", getMaGD(), getSoLuong(),manufacturingDateString, getDonGia(), getTiGia(), getLoaiTienTe(), getThanhTien());
		return str;
	}
}
