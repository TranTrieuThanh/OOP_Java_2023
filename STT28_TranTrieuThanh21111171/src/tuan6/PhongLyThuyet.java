package tuan6;

public class PhongLyThuyet extends Phong{
	private boolean mayChieu;

	public boolean isMayChieu() {
	return mayChieu;
}

public void setMayChieu(boolean mayChieu) {
	this.mayChieu = mayChieu;
}
	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soDen, boolean mayChieu) {
	super(maPhong, dayNha, dienTich, soDen);
	this.mayChieu = mayChieu;
}

	public PhongLyThuyet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soDen) {
		super(maPhong, dayNha, dienTich, soDen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean DatChuan() {
		// TODO Auto-generated method stub
		return this.fullAnhSang()&& this.isMayChieu()?true :false;
		
	}

	@Override
	public String toString() {
		String str = String.format("%10b", isMayChieu());
		return super.toString() + str;
	}

}
