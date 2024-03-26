package tuan6;

public class PhongThiNghiem extends Phong {
	private String chuyenNganh;
	private int sucChua;
	private boolean bonRua;
		public String getChuyenNganh() {
		return chuyenNganh;
	}
	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	public int getSucChua() {
		return sucChua;
	}
	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}
	public boolean isBonRua() {
		return bonRua;
	}
	public void setBonRua(boolean bonRua) {
		this.bonRua = bonRua;
	}
		public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soDen, String chuyenNganh, int sucChua,
			boolean bonRua) {
		super(maPhong, dayNha, dienTich, soDen);
		this.chuyenNganh = chuyenNganh;
		this.sucChua = sucChua;
		this.bonRua = bonRua;
	}
		
		public PhongThiNghiem() {
			super();
			// TODO Auto-generated constructor stub
		}
		public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soDen) {
			super(maPhong, dayNha, dienTich, soDen);
			// TODO Auto-generated constructor stub
		}
		@Override
		public boolean DatChuan() {
			// TODO Auto-generated method stub
					return this.fullAnhSang()&& this.isBonRua()?true :false;
		}
		@Override
		public String toString() {
			String str = String.format("%10s%13d%12b",getChuyenNganh(),getSucChua(),isBonRua());;
			return super.toString() + str;
		}

}
