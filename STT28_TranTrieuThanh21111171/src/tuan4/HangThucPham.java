package tuan4;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HangThucPham {
private String code,name;
private double price;
private LocalDate manufacturingDate;
private LocalDate expirationDate;
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public LocalDate getManufacturingDate() {
	return manufacturingDate;
}
public void setManufacturingDate(LocalDate manufacturingDate) {
	this.manufacturingDate = manufacturingDate;
}
public LocalDate getExpirationDate() {
	return expirationDate;
}
public void setExpirationDate(LocalDate expirationDate) {
	this.expirationDate = expirationDate;
}
public HangThucPham() {
	super();
	// TODO Auto-generated constructor stub
}
public HangThucPham(String code, String name, double price, LocalDate manufacturingDate, LocalDate expirationDate)throws Exception {
	super();
	this.code = code;
	this.name = name;
	this.price = price;
	this.manufacturingDate = manufacturingDate;
	this.expirationDate = expirationDate;
	
}
public HangThucPham(String code) {
	super();
	this.code = code;

}
public int checkExpiration() {
	LocalDate ngayHetHan= this.getExpirationDate();
	LocalDate ngayHienTai=LocalDate.now();
	if(ngayHienTai.isBefore(ngayHetHan))
	{
		return 1;
	}
	else {
		return -1;
	}
}
@Override
public String toString() {
	DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String manufacturingDateString=manufacturingDate.format(dateFormatter);
	String expirationsDateString =expirationDate.format(dateFormatter);
	Locale localeVN=new Locale("vi","VN");
	NumberFormat currencyFormat=NumberFormat.getCurrencyInstance(localeVN);
	String formattedPrice=currencyFormat.format(getPrice());
	
	String str=String.format("%-20s %-20s %-22s %-20s %-20s", getCode(),getName(),formattedPrice,manufacturingDateString,expirationsDateString);
	return str;
}

}
