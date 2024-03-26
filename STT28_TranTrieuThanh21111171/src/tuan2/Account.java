package tuan2;


import java.text.DecimalFormat;

public class Account {
 private long soTaiKhoan;
private double soTienTrongTK;
private String tenTaiKhoan;
private final double LAISUAT=0.035;
public long getSoTaiKhoan() {
	return soTaiKhoan;
}
public void setSoTaiKhoan(long soTaiKhoan) {
	this.soTaiKhoan = soTaiKhoan;
}
public double getSoTienTrongTK() {
	return soTienTrongTK;
}
public void setSoTienTrongTK(double soTienTrongTK) {
	this.soTienTrongTK = soTienTrongTK;
}
public String getTenTaiKhoan() {
	return tenTaiKhoan;
}
public void setTenTaiKhoan(String tenTaiKhoan) {
	this.tenTaiKhoan = tenTaiKhoan;
}
public Account() {
	super();
	// TODO Auto-generated constructor stub
}
public Account(long soTaiKhoan, String tenTaiKhoan , double soTienTrongTK) {
	super();
	this.soTaiKhoan = soTaiKhoan;
	this.soTienTrongTK = soTienTrongTK;
	this.tenTaiKhoan = tenTaiKhoan;
}
public Account(long soTaiKhoan, String tenTaiKhoan) {
	super();
	this.soTaiKhoan = soTaiKhoan;
	this.soTienTrongTK = 50000;
	this.tenTaiKhoan = tenTaiKhoan;
}
public void napTienTaiKhoan(double tienThemVao) throws Exception
{
	if(tienThemVao >0)
	{
		this.soTienTrongTK+=tienThemVao;
		
	}
	else
		throw new Exception("Tiền nạp phải >0");
}
public void rutTienTaiKhoan(double tienRutRa,double phiRutTien) {
	if(tienRutRa>0 &&this.soTienTrongTK-tienRutRa-phiRutTien>=50000)
	{
		this.soTienTrongTK-=(tienRutRa+phiRutTien);
	}
}
public boolean chuyenKhoanToi(Account nguoiNhan, double soTienChuyen) throws Exception {
	if (soTienChuyen>0 && this.soTienTrongTK-soTienChuyen-(soTienChuyen*003)>50000)
	{
		this.rutTienTaiKhoan(soTienChuyen,soTienChuyen*0.003);
		nguoiNhan.napTienTaiKhoan(soTienChuyen);
		return true;
		
	}
	return false;
}
public void daoHan() {
	this.soTienTrongTK+=(this.soTienTrongTK*LAISUAT);
	
}
@Override
public String toString() {
	DecimalFormat formatter = new DecimalFormat("###,###,###.00");
	return String.format("%-20d%-15s%20s", soTaiKhoan,tenTaiKhoan,formatter.format(soTienTrongTK)+"VND");
}

}
