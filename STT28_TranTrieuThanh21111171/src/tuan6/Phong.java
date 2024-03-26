package tuan6;

public abstract class Phong {
	protected String maPhong;
	protected String dayNha;
	protected double dienTich;
	protected int soDen;
	public abstract boolean DatChuan();
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getDayNha() {
		return dayNha;
	}
	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	public int getSoDen() {
		return soDen;
	}
	public void setSoDen(int soDen) {
		this.soDen = soDen;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
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
		Phong other = (Phong) obj;
		if (maPhong == null) {
			if (other.maPhong != null)
				return false;
		} else if (!maPhong.equals(other.maPhong))
			return false;
		return true;
	}
	public Phong(String maPhong, String dayNha, double dienTich, int soDen) {
		super();
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soDen = soDen;
	}
	public Phong() {
		super();
	}
	public  boolean fullAnhSang()
	{
		double dt= this.getDienTich();
		int soDen= this.getSoDen();
		return soDen >= (dt/10)? true : false;
	}
	@Override
	public String toString() {
		String str = String.format("%-15s %-10s %-15.2f%-10d",getMaPhong(),getDayNha(),getDienTich(),getSoDen());
		return str;
	}

}
