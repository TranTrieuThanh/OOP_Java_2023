package tuan7;

import java.time.LocalDate;

public class GiaoDichNha extends GiaoDich{
	private String typeNha;
	private String address;
	public String getTypeNha() {
		return typeNha;
	}
	public void setTypeNha(String typeNha) {
		this.typeNha = typeNha;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public GiaoDichNha() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GiaoDichNha(String maGd, LocalDate ngayGD, double donGia, double dienTich) {
		super(maGd, ngayGD, donGia, dienTich);
		// TODO Auto-generated constructor stub
	}
	public GiaoDichNha(String maGd, LocalDate ngayGD, double donGia, double dienTich, String typeNha, String address)throws Exception {
		super(maGd, ngayGD, donGia, dienTich);
		if((typeNha.equalsIgnoreCase("cao cấp")||typeNha.equalsIgnoreCase("thường")))
		{
			this.typeNha = typeNha;
		}
		else
		{
			throw new Exception("Loại nhà phải là cao cấp hoặc thường!");
		}
		this.address = address;
	}
	public double thanhTien()
	{
		double dienTich= this.getDienTich();
		double donGia= this.getDonGia();
		String type= this.getTypeNha();
		return type.equalsIgnoreCase("Cao cấp")? dienTich*donGia : dienTich*donGia*0.9;
	}
	@Override
	public String toString() {
		String str= String.format("%-13s%10s", getTypeNha(),getAddress());
		return super.toString() + str;
	}

}
