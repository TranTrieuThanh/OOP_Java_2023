package tuan7;

import java.time.LocalDate;

public class GiaoDichDat extends GiaoDich {
	private String typeDat;

	public String getTypeDat() {
		return typeDat;
	}

	public void setTypeDat(String typeDat) {
		this.typeDat = typeDat;
	}

	public GiaoDichDat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaoDichDat(String maGd, LocalDate ngayGD, double donGia, double dienTich) {
		super(maGd, ngayGD, donGia, dienTich);
		// TODO Auto-generated constructor stub
	}

	public GiaoDichDat(String maGd, LocalDate ngayGD, double donGia, double dienTich, String typeDat) throws Exception{
		super(maGd, ngayGD, donGia, dienTich);
		if((typeDat.equalsIgnoreCase("b")||typeDat.equalsIgnoreCase("a")||typeDat.equalsIgnoreCase("c")))
		{
			this.typeDat = typeDat;
		}
		else
		{
			throw new Exception("Loại đất phải là A,B hoặc C!");
		}
	}
	public double thanhTien()
	{
		double dienTich= this.getDienTich();
		double donGia= this.getDonGia();
		String type= this.getTypeDat();
		return type.equalsIgnoreCase("B")||type.equalsIgnoreCase("C")? dienTich*donGia : dienTich*donGia*1.5;
	}

	@Override
	public String toString() {
		String str= String.format("%-10s", getTypeDat());
		return super.toString() + str;
	}

}
