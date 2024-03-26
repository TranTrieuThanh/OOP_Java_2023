package tuan5;

public class NgoaiThanh extends ChuyenXe {
	private String noiDen;
	private int soNgayDiDuoc;
	public String getNoiDen() {
		return noiDen;
	}
	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}
	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}
	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	
	public NgoaiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NgoaiThanh(String maChuyenxe, String tenTaixe, int soxe, double doanhthu) {
		super(maChuyenxe, tenTaixe, soxe, doanhthu);
		// TODO Auto-generated constructor stub
	}
	public NgoaiThanh(String maChuyenxe, String tenTaixe, int soxe, double doanhthu,String noiDen, int soNgayDiDuoc) {
		super(maChuyenxe, tenTaixe, soxe, doanhthu);
		this.noiDen = noiDen;
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	@Override
	public String toString() {
		
		String str=String.format("%-15s %-15d", getNoiDen(),getSoNgayDiDuoc());
		return super.toString()+str;
	}
}
