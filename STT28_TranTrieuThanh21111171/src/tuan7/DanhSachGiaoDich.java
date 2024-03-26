package tuan7;

import java.util.ArrayList;
import java.util.List;


public class DanhSachGiaoDich {
	List<GiaoDich> Danhsach;
	List k;
	public DanhSachGiaoDich()
	{
		Danhsach= new ArrayList<GiaoDich>();
	}
	public List<GiaoDich> getDanhSach(){
		return Danhsach;
	}
	public List<GiaoDich> getDanhSachGDDat(){
		List<GiaoDich> DSGiaoDichDat= new ArrayList<GiaoDich>();
		for(GiaoDich giaodich : Danhsach) {
			if(giaodich instanceof GiaoDichDat) {
				DSGiaoDichDat.add( giaodich);
			}
		}
		return DSGiaoDichDat;
	}
	public List<GiaoDich> getDanhSachGDNha(){
		List<GiaoDich> DSGiaoDichNha= new ArrayList<GiaoDich>();
		for(GiaoDich giaodich : Danhsach) {
			if(giaodich instanceof GiaoDichNha) {
				DSGiaoDichNha.add( giaodich);
			}
		}
		return DSGiaoDichNha;
	}
	//------------Add------------
	public void addGiaoDich(GiaoDich giaodich) throws Exception{
		if(Danhsach.contains(giaodich)==false)
		{
			Danhsach.add(giaodich);
		}
		else
			throw new Exception("Không thể thêm do trùng mã Giao dịch!");
	}
	public GiaoDich findBook(String maGD)throws Exception {
		for (GiaoDich giaodich : Danhsach)
		{
			if(giaodich.getMaGd().equals(maGD)==true) {
				return giaodich;
			}
		}
			throw new Exception("Không tìm thấy sách");
	}
	public int findViTri(String maGD)throws Exception {
		for (GiaoDich giaodich : Danhsach)
		{
			if(giaodich.getMaGd().equals(maGD)==true) {
				return Danhsach.indexOf(giaodich);
			}
		}
			throw new Exception("Không tìm thấy  vị trí Giao dịch");
	}
	public int tongSoGDDat()
	{
		int i=0;
		for(GiaoDich giaodich : Danhsach) {
			if(giaodich instanceof GiaoDichDat) {
				i++;
			}
		}
		return i;
	}
	public int tongSoGDNha()
	{
		int i=0;
		for(GiaoDich giaodich : Danhsach) {
			if(giaodich instanceof GiaoDichNha) {
				i++;
			}
		}
		return i;
	}
	public double AvgThanhTienDat()
	{
		double total=0;
		int i=0;
		for(GiaoDich giaodich : Danhsach) {
			if(giaodich instanceof GiaoDichDat) {
				i++;
				GiaoDichDat giaodich1=(GiaoDichDat) giaodich;
				total=total+giaodich1.thanhTien();
			}
		}
		return total/i;
	}
	public List<GiaoDich> getDanhSachGDNhaThang9(){
		List<GiaoDich> DSGiaoDichNhaT9= new ArrayList<GiaoDich>();
		for(GiaoDich giaodich : Danhsach) {
			if(giaodich instanceof GiaoDichNha && giaodich.getNgayGD().getYear()==2013&&giaodich.getNgayGD().getMonthValue()==9) {
				DSGiaoDichNhaT9.add( giaodich);
				
			}
			
	}
		return DSGiaoDichNhaT9;
	}

}
	
