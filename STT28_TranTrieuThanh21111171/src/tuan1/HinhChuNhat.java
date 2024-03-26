package tuan1;

public class HinhChuNhat {
	private int chieuDai;
	
	private int chieuRong;
	public int getChieuDai() {
		return chieuDai;
	}
	public void setChieuDai(int cDai) {
		this.chieuDai = cDai;
	}
	public int getChieuRong() {
		return chieuRong;
	}
	public void setChieuRong(int cRong) {
		this.chieuRong = cRong;
	}
	public HinhChuNhat() {
	 super();
	}
	public HinhChuNhat(int cDai, int cRong) {
		super();
		this.chieuDai = cDai;
		this.chieuRong = cRong;
	}
	public int chuVi() {
		int cd=this.getChieuDai();
		int cr=this.getChieuRong();
		int cv=(cd+cr)*2;
		return cv;
	}
	public long dienTich() {
		int cd=this.getChieuDai();
		int cr=this.getChieuRong();
		long dt=cd*cr;
		return dt;
	}
	@Override
	public String toString() {
		String str=String.format("%10d %10d %13d %10d",getChieuDai(),getChieuRong(),chuVi(),dienTich());
		return str;
	}
	
	
	
}
