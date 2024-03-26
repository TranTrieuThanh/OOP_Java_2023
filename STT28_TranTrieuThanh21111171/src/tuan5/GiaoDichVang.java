package tuan5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GiaoDichVang extends GiaoDich {
	private String loaiVang;

    public String getLoaiVang() {
        return loaiVang;
    }

    public void setLoaiVang(String loaiVang) {
        this.loaiVang = loaiVang;
    }

    public GiaoDichVang(int maGD, int soLuong, LocalDate ngayGD, double donGia, String loaiVang) {
        super(maGD, soLuong, ngayGD, donGia);
        this.loaiVang = loaiVang;
    }

    @Override
    public double getThanhTien() {
        return getDonGia() * getSoLuong();
    }

	@Override
	public String toString() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String manufacturingDateString = ngayGD.format(dateFormatter);
	    String str = String.format("%-20d %-20d %-20s %-20f %-20s %20f ", getMaGD(), getSoLuong(),manufacturingDateString, getDonGia(), getLoaiVang(), getThanhTien());
		return str;
	}
}
