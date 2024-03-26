package tuan3;

public class SinhVien {
private int IDstudent;
private String studentName,address;
private String phoneNumber;
public int getIDstudent() {
	return IDstudent;
}
public void setIDstudent(int iDstudent) {
	IDstudent = iDstudent;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public SinhVien() {
	super();
	// TODO Auto-generated constructor stub
}
public SinhVien(int iDstudent, String studentName, String address, String phoneNumber) throws Exception {
	super();
	IDstudent = iDstudent;
	this.studentName = studentName;
	this.address = address;
	if(phoneNumber.length()==7&& phoneNumber.matches("\\d+")) {
	this.phoneNumber = phoneNumber;
	}
	else throw new Exception("Số điện thoại phải đúng 7 chữ số");
}
@Override
public String toString() {
	String str=String.format("%-21d %-20s %-18s %-15s", getIDstudent(),getStudentName(),getAddress(),getPhoneNumber());
	return str;
}

}
