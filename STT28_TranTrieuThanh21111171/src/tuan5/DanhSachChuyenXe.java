package tuan5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachChuyenXe {
	List<ChuyenXe> Danhsach;
	List k;
	public DanhSachChuyenXe() {
		Danhsach = new ArrayList<ChuyenXe>();
	}
	public List<ChuyenXe> getDanhSach(){
		return Danhsach;
	}
	
	public List<ChuyenXe> getDanhSachNoiThanh(){
		List<ChuyenXe> DSNoiThanh= new ArrayList<ChuyenXe>();
		for(ChuyenXe cx : Danhsach) {
			if(cx instanceof NoiThanh) {
				DSNoiThanh.add( cx);
			}
		}
		return DSNoiThanh;
	}
	public List<ChuyenXe> getDanhSachNgoaiThanh(){
		List<ChuyenXe> DSNgoaiThanh= new ArrayList<ChuyenXe>();
		for(ChuyenXe cx : Danhsach) {
			if(cx instanceof NgoaiThanh) {
				DSNgoaiThanh.add( cx);
			}
		}
		return DSNgoaiThanh;
	}
	//------------Add------------
	public void addChuyenXe(ChuyenXe Cxe) throws Exception{
		if(Danhsach.contains(Cxe)==false)
		{
			Danhsach.add(Cxe);
		}
		else
			throw new Exception("Không thể thêm do trùng mã xe!");
	}
	public ChuyenXe findChuyenXe(String maChuyenXe)throws Exception {
		for (ChuyenXe cx : Danhsach)
		{
			if(cx.getMaChuyenxe().equals(maChuyenXe)==true) {
				return cx;
			}
		}
			throw new Exception("Không tìm thấy chuyến xe");
	}
	public int findViTri(String maChuyenXe)throws Exception {
		for (ChuyenXe cx : Danhsach)
		{
			if(cx.getMaChuyenxe().equals(maChuyenXe)==true) {
				return Danhsach.indexOf(cx);
			}
		}
			throw new Exception("Không tìm thấy  vị trí chuyến xe");
	}
	public void deleteChuyenXe(ChuyenXe cx) {
		Danhsach.remove(cx);
	}
	public void updateChuyenXe(ChuyenXe cx)throws Exception {
		int vt= findViTri(cx.getMaChuyenxe());
		Danhsach.set(vt, cx);
	}
	public double totalDanhthu() {
		double total=0;
		for (ChuyenXe cx:  Danhsach) {
			total=total+cx.getDoanhthu();
		}
		return total;
	}
	public void sortTheoDoanhThu() {
		Collections.sort(Danhsach, new Comparator<ChuyenXe>() {
			public int compare(ChuyenXe o1, ChuyenXe o2) {
				Double doanhThuXe1=(Double) o1.getDoanhthu();
				Double doanhThuXe2=(Double) o2.getDoanhthu();
				return doanhThuXe1.compareTo(doanhThuXe2);
			};
		} );
	}
	public  int dodai() {
	 return Danhsach.size();
	}
}
