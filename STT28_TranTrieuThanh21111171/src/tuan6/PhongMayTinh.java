package tuan6;

public class PhongMayTinh extends Phong {
	private int computer;

	public int getComputer() {
	return computer;
}

public void setComputer(int computer) {
	this.computer = computer;
}


	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soDen, int computer) {
	super(maPhong, dayNha, dienTich, soDen);
	this.computer = computer;
}

	public PhongMayTinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soDen) {
		super(maPhong, dayNha, dienTich, soDen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean DatChuan() {
		double dt= this.getDienTich();
		int soMT=this.getComputer();
		return dt/soMT <=1.5? true: false;
	}
	@Override
	public String toString() {
		String str = String.format("%4d", getComputer());
		return super.toString() + str;
	}


}
