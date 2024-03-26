package tuan5;

import java.util.ArrayList;
import java.util.List;

public class DanhSachSach {
	List<Sach> Danhsach;
	List k;
	public DanhSachSach()
	{
		Danhsach= new ArrayList<Sach>();
	}
	public List<Sach> getDanhSach(){
		return Danhsach;
	}
	public List<Sach> getDanhSachGiaoKhoa(){
		List<Sach> DSGiaoKhoa= new ArrayList<Sach>();
		for(Sach book : Danhsach) {
			if(book instanceof SachGiaoKhoa) {
				DSGiaoKhoa.add( book);
			}
		}
		return DSGiaoKhoa;
	}
	public List<Sach> getDanhSachThamKhao(){
		List<Sach> DSThamKhao= new ArrayList<Sach>();
		for(Sach book : Danhsach) {
			if(book instanceof SachThamKhao) {
				DSThamKhao.add( book);
			}
		}
		return DSThamKhao;
	}
	//------------Add------------
	public void addBook(Sach book) throws Exception{
		if(Danhsach.contains(book)==false)
		{
			Danhsach.add(book);
		}
		else
			throw new Exception("Không thể thêm do trùng mã xe!");
	}
	public Sach findBook(String maSach)throws Exception {
		for (Sach book : Danhsach)
		{
			if(book.getMaSach().equals(maSach)==true) {
				return book;
			}
		}
			throw new Exception("Không tìm thấy sách");
	}
	public int findViTri(String maSach)throws Exception {
		for (Sach book : Danhsach)
		{
			if(book.getMaSach().equals(maSach)==true) {
				return Danhsach.indexOf(book);
			}
		}
			throw new Exception("Không tìm thấy  vị trí chuyến xe");
	}
	public double totalSachGK()
	{
	 double  total=0;
	 for(Sach book : Danhsach)
	 {
		 if(book instanceof SachGiaoKhoa)
		 {
			 SachGiaoKhoa books= (SachGiaoKhoa) book;
			 total= total+ books.thanhTienGK();
		 }
	 }
	 return total;
	}
	public double totalSachTK()
	{
	 double  total=0;
	 for(Sach book : Danhsach)
	 {
		 if(book instanceof SachThamKhao)
		 {
			 SachThamKhao books= (SachThamKhao) book;
			 total= total+ books.thanhTien();
		 }
	 }
	 return total;
	}
	public double avgSachThamKhao()
	{
		double total=0;
		int i=0;
		for(Sach book : Danhsach)
		 {
			 if(book instanceof SachThamKhao)
			 {
				 i++;
				 SachThamKhao books= (SachThamKhao) book;
				 total=total+books.getDonGia();
			 }
		 }
		 return total/i ;
		
	}
}
