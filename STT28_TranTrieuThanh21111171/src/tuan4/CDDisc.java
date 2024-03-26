package tuan4;

public class CDDisc {
private int CDCode;
private String CDName,Singer;
private int numberSong;
private double Price;
public int getCDCode() {
	return CDCode;
}
public void setCDCode(int cDCode) {
	CDCode = cDCode;
}
public String getCDName() {
	return CDName;
}
public void setCDName(String cDName) {
	CDName = cDName;
}
public String getSinger() {
	return Singer;
}
public void setSinger(String singer) {
	Singer = singer;
}
public int getNumberSong() {
	return numberSong;
}
public void setNumberSong(int numberSong) {
	this.numberSong = numberSong;
}
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}
public CDDisc() {
	super();
	// TODO Auto-generated constructor stub
}
public CDDisc(int cDCode, String cDName, String singer, int numberSong, double price) throws Exception {
	super();
	CDCode = cDCode;
	CDName = cDName;
	Singer = singer;
	if(numberSong >0) {
	this.numberSong = numberSong;
	}
	else 
		throw new Exception("Số bài hát phải >0");
	if(price>0) {
	Price = price;
	}
	else
		throw new Exception("Giá thành phải >0");
}
@Override
public String toString() {
	String str=String.format("%-15d %-15s %-15s %-15d %-10.2f",getCDCode(),getCDName(),getSinger(),getNumberSong(),getPrice());
	return str;
}

}
