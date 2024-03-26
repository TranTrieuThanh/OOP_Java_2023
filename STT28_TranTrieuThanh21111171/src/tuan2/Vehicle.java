package tuan2;

public class Vehicle {
String Tenchuxe;
String Loaixe;
int Dungtich;
long Trigia;
public String getTenchuxe() {
	return Tenchuxe;
}
public void setTenchuxe(String tenchuxe) {
	Tenchuxe = tenchuxe;
}
public String getLoaixe() {
	return Loaixe;
}
public void setLoaixe(String loaixe) {
	Loaixe = loaixe;
}
public int getDungtich() {
	return Dungtich;
}
public void setDungtich(int dungtich) {
	Dungtich = dungtich;
}
public long getTrigia() {
	return Trigia;
}
public void setTrigia(long trigia) {
	Trigia = trigia;
}
public Vehicle() {
	super();
	// TODO Auto-generated constructor stub
}
public Vehicle(String tenchuxe, String loaixe, int dungtich, long trigia) {
	super();
	Tenchuxe = tenchuxe;
	Loaixe = loaixe;
	Dungtich = dungtich;
	Trigia = trigia;
}
public double ThueXe() {
	double Thuexe;
	int dt=this.getDungtich();
	long tg=this.getTrigia();
	if(dt>200) 
	{
		Thuexe=0.05*tg;
	}
	else 
	{
		if(100 <= dt&& dt<=200) 
		{
			Thuexe=0.03*tg;
		}
		else 
		{
			Thuexe=0.01*tg;
		}
	}
	return Thuexe;
}
@Override
public String toString() {
	String str=String.format("%7s %14s %14d %17d %16.2f",getTenchuxe(),getLoaixe(),getDungtich(),getTrigia(),ThueXe());
	return str;
}


}
