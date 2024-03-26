package tuan6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachPhong {
	List<Phong> Danhsach;
	List k;
	public DanhSachPhong() {
		Danhsach = new ArrayList<Phong>();
	}
	public List<Phong> getDanhSach(){
		return Danhsach;
	}
	
	public List<Phong> getDanhSachLyThuyet(){
		List<Phong> DSLyThuyet= new ArrayList<Phong>();
		for(Phong room : Danhsach) {
			if(room instanceof PhongLyThuyet) {
				DSLyThuyet.add( room);
			}
		}
		return DSLyThuyet;
	}
	public List<Phong> getDanhSachMayTinh(){
		List<Phong> DSMayTinh= new ArrayList<Phong>();
		for(Phong room : Danhsach) {
			if(room instanceof PhongMayTinh) {
				DSMayTinh.add( room);
			}
		}
		return DSMayTinh;
	}
	public List<Phong> getDanhSachThiNghiem(){
		List<Phong> DSThiNghiem= new ArrayList<Phong>();
		for(Phong room : Danhsach) {
			if(room instanceof PhongThiNghiem) {
				DSThiNghiem.add( room);
			}
		}
		return DSThiNghiem;
	}
	
	//------------Add------------
	public void addPhong(Phong room) throws Exception{
		if(Danhsach.contains(room)==false)
		{
			Danhsach.add(room);
		}
		else
			throw new Exception("Không thể thêm do trùng mã phòng!");
	}
	public Phong findPhong(String maPhong)throws Exception {
		for (Phong room : Danhsach)
		{
			if(room.getMaPhong().equals(maPhong)==true) {
				return room;
			}
		}
			throw new Exception("Không tìm thấy phòng");
	}
	public int findViTri(String maPhong)throws Exception {
		for (Phong room : Danhsach)
		{
			if(room.getMaPhong().equals(maPhong)==true) {
				return Danhsach.indexOf(room);
			}
		}
			throw new Exception("Không tìm thấy  vị trí phòng");
	}
	public void deletePhong(Phong room) {
		Danhsach.remove(room);
	}
	public void updatePhong(Phong room)throws Exception {
		int vt= findViTri(room.getMaPhong());
		Danhsach.set(vt, room);
	}
	
//	public void sortTheoDoanhThu() {
//		Collections.sort(Danhsach, new Comparator<Phong>() {
//			@Override
//			public int compare(Phong o1, Phong o2) {
//				Double doanhThuXe1=(Double) o1.getDoanhthu();
//				Double doanhThuXe2=(Double) o2.getDoanhthu();
//				return doanhThuXe1.compareTo(doanhThuXe2);
//			};
//		} );
//	}

public void sortTheoDayNha()
	{
		Collections.sort(Danhsach, new Comparator<Phong>() {
			public int compare(Phong o1, Phong o2) {
				String day1=(String) o1.getDayNha();
				String day2=(String) o2.getDayNha();
				return day1.compareToIgnoreCase(day2);
			}
		});
	}
	public void sortDienTich()
	{
		Collections.sort(Danhsach, new Comparator<Phong>() {
			public int compare(Phong o1, Phong o2) {
				Double dt1=(Double) o1.getDienTich();
				Double dt2=(Double) o2.getDienTich();
				return dt2.compareTo(dt1);
			}
		});
	}
	public void sortSoDen()
	{
		Collections.sort(Danhsach, new Comparator<Phong>() {
			public int compare(Phong o1, Phong o2) {
				Integer den1=(Integer) o1.getSoDen();
				Integer den2=(Integer) o2.getSoDen();
				return den1.compareTo(den2);
			}
		});
	}
public int tongsoPhong() {
	int i=0;
	for(Phong room: Danhsach)
	{
		i++;
	}
	return i;
}
public List<Phong> getPhongMaytinh10May()
{
	List<Phong> DSMayTinh10= new ArrayList<Phong>();
	for(Phong room : Danhsach) {
		if(room instanceof PhongMayTinh) {
			PhongMayTinh roomMT=(PhongMayTinh) room;
			if(roomMT.getComputer()==60) {
				DSMayTinh10.add( room);
			}
		}
	}
	return DSMayTinh10;
}

}
