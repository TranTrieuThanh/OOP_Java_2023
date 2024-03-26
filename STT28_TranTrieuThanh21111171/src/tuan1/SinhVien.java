package tuan1;

public class SinhVien {
	int MSV;
	String Hoten;
	double Diemlt,DiemTH;
	public int getMSV() {
		return MSV;
	}
	public void setMSV(int mSV) {
		MSV = mSV;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public double getDiemlt() {
		return Diemlt;
	}
	public void setDiemlt(double diemlt) {
		Diemlt = diemlt;
	}
	public double getDiemTH() {
		return DiemTH;
	}
	public void setDiemTH(double diemTH) {
		DiemTH = diemTH;
	}
	public SinhVien() 
	{
		super();
	}
	public SinhVien(int mSV, String hoten, double diemlt, double diemTH) {
		super();
		MSV = mSV;
		Hoten = hoten;
		Diemlt = diemlt;
		DiemTH = diemTH;
	}
	public double TinhdiemTB() {
		double lt=this.getDiemlt();
		double th=this.getDiemTH();
		double tb= (lt+th) /2;
		return tb;
	}
	@Override
	public String toString() {
		String str=String.format("%5d %10s %10f %15f %15.2f",getMSV(),getHoten(),getDiemlt(),getDiemTH(),TinhdiemTB());
		return str;
	}
}
