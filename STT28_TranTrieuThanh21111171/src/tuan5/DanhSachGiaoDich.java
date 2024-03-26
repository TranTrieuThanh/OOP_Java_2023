package tuan5;

import java.util.ArrayList;

public class DanhSachGiaoDich {
	private ArrayList<GiaoDich> DS;
	public DanhSachGiaoDich() {
		DS = new ArrayList<GiaoDich>();
	}

	public ArrayList<GiaoDich> getDS() {
		return DS;
	}
	public boolean addGiaoDich(GiaoDich GD) {
        for (GiaoDich c : DS) {
            if (c.getMaGD()==(GD.getMaGD())) {
                return false;
            }
        }
        DS.add(GD);
        return true;
    }
	public ArrayList<GiaoDich> getDanhSachGDVang(){
		ArrayList<GiaoDich> DSGiaoDichVang= new ArrayList<GiaoDich>();
		for(GiaoDich giaodich : DS) {
			if(giaodich instanceof GiaoDichVang) {
				DSGiaoDichVang.add( giaodich);
			}
		}
		return DSGiaoDichVang;
	}
	public ArrayList<GiaoDich> getDanhSachGDTien(){
		ArrayList<GiaoDich> DSGiaoDichTien= new ArrayList<GiaoDich>();
		for(GiaoDich giaodich : DS) {
			if(giaodich instanceof GiaoDichTien) {
				DSGiaoDichTien.add( giaodich);
			}
		}
		return DSGiaoDichTien;
	}
	public int tongGDTien() {
		int slGdtien=0;
        for (GiaoDich c : DS) {
            if (c instanceof GiaoDichTien ) {
            	slGdtien=slGdtien+1;
            }
        }
        return slGdtien;
    }
	public int tongGDVang() {
		int slGdVang=0;
        for (GiaoDich c : DS) {
            if (c instanceof GiaoDichTien ) {
            	slGdVang=slGdVang+1;
            }
        }
        return slGdVang;
    }
	public double trungBinhThanhTienGDTien() {
		double trungbinh=0;
        for (GiaoDich c : DS) {
            if (c instanceof GiaoDichTien ) {
            	trungbinh+=c.getThanhTien();
            }
        }
        return trungbinh/tongGDTien();
    }
	public ArrayList<GiaoDich> xuatGiaoDichDonGiaVang() {
		ArrayList<GiaoDich> DSGiaoDichDonGia= new ArrayList<GiaoDich>();
	    for (GiaoDich c : DS) {
	    		if(c.getDonGia()>1000) {
	    			if (c instanceof GiaoDichVang) {
	    				DSGiaoDichDonGia.add(c);
	                }
	    		}
           }
	    return DSGiaoDichDonGia;
	}
	public ArrayList<GiaoDich> xuatGiaoDichDonGiaTien() {
		ArrayList<GiaoDich> DSGiaoDichDonGia= new ArrayList<GiaoDich>();
	    for (GiaoDich c : DS) {
	    		if(c.getDonGia()>1000) {
	    			if (c instanceof GiaoDichTien) {
	    				DSGiaoDichDonGia.add(c);
	                }
	    		}
           }
	    return DSGiaoDichDonGia;
	}
}
