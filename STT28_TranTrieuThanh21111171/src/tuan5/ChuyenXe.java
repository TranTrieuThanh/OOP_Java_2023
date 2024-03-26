package tuan5;

import java.text.DecimalFormat;

public class ChuyenXe {
	protected String maChuyenxe,tenTaixe;
	protected int Soxe;
	protected double Doanhthu;
	public String getMaChuyenxe() {
		return maChuyenxe;
	}
	public void setMaChuyenxe(String maChuyenxe) {
		this.maChuyenxe = maChuyenxe;
	}
	public String getTenTaixe() {
		return tenTaixe;
	}
	public void setTenTaixe(String tenTaixe) {
		this.tenTaixe = tenTaixe;
	}
	public int getSoxe() {
		return Soxe;
	}
	public void setSoxe(int soxe) {
		Soxe = soxe;
	}
	public double getDoanhthu() {
		return Doanhthu;
	}
	public void setDoanhthu(double doanhthu) {
		Doanhthu = doanhthu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maChuyenxe == null) ? 0 : maChuyenxe.hashCode());
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
		ChuyenXe other = (ChuyenXe) obj;
		if (maChuyenxe == null) {
			if (other.maChuyenxe != null)
				return false;
		} else if (!maChuyenxe.equals(other.maChuyenxe))
			return false;
		return true;
	}
	public ChuyenXe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChuyenXe(String maChuyenxe, String tenTaixe, int soxe, double doanhthu) {
		super();
		this.maChuyenxe = maChuyenxe;
		this.tenTaixe = tenTaixe;
		Soxe = soxe;
		Doanhthu = doanhthu;
	}
	@Override
		public String toString() {
			DecimalFormat df= new DecimalFormat("#,##0.00VND");
			String doanhthu= df.format(Doanhthu);
			String str=String.format("%-15s %-25s %-15d %-20s", getMaChuyenxe(),getTenTaixe(),getSoxe(),doanhthu);
			return str;
		}
}
