package tuan5;

import java.text.DecimalFormat;

public class NoiThanh extends ChuyenXe{
	private int soTuyen,soKm;

	public int getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(int soTuyen) {
		this.soTuyen = soTuyen;
	}

	public int getSoKm() {
		return soKm;
	}

	public void setSoKm(int soKm) {
		this.soKm = soKm;
	}

	public NoiThanh(String maChuyenxe, String tenTaixe, int soxe, double doanhthu ,int soTuyen, int soKm) {
		super(maChuyenxe, tenTaixe, soxe, doanhthu);
		this.soTuyen = soTuyen;
		this.soKm = soKm;
	}

	public NoiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoiThanh(String maChuyenxe, String tenTaixe, int soxe, double doanhthu) {
		super(maChuyenxe, tenTaixe, soxe, doanhthu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		DecimalFormat df= new DecimalFormat("###Km");
		String soKmdiduoc= df.format(soKm);
		String str=String.format("%5d %17s", getSoTuyen(),soKmdiduoc);
		return super.toString()+str;
	}
}
