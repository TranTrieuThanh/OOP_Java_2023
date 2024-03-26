package tuan3;

import java.util.Scanner;

public class KiemThuFraction {
	public static void main(String[] args) throws Exception{
		System.out.println("Chương trình tính Phân số!");
		int choice;
		do {
			choice=menu();
			
			switch(choice)
			{
			case 1:
			{
				System.out.println("Nhập phân số cần tối giản: ");
				Fraction frac1=createFraction();
				System.out.println("Phân số tối giản: \n");
				frac1=frac1.reduceFraction();
				if(frac1.getNumerator()==frac1.getDenominator())
				{
					System.out.println("1");
				}
				else
				System.out.println(frac1);
				
				break;
			}
			case 2:
			{
				System.out.println("Nhập phân số cần nghịch đảo: ");
				Fraction frac1=createFraction();
				System.out.println("Phân số nghịch đảo: \n");
				frac1=frac1.reciprocalFraction();
				if(frac1.getNumerator()==frac1.getDenominator())
				{
					System.out.println("1");
				}
				else
				System.out.println(frac1);
				break;
			}
			case 3:
			{
				System.out.println("Nhập phân số thứ 1: ");
				Fraction frac1=createFraction();
				System.out.println("Nhập phân số thứ 2: ");
				Fraction frac2=createFraction();
				System.out.println("Tổng hai phân số: ");
				System.out.println(frac1.addFraction(frac2));
				break;
			}
			case 4:
			{
				System.out.println("Nhập phân số thứ 1: ");
				Fraction frac1=createFraction();
				System.out.println("Nhập phân số thứ 2: ");
				Fraction frac2=createFraction();
				System.out.println("Trừ hai phân số: ");
				System.out.println(frac1.subtractFraction(frac2));
				break;
			}
			case 5:
			{
				System.out.println("Nhập phân số thứ 1: ");
				Fraction frac1=createFraction();
				System.out.println("Nhập phân số thứ 2: ");
				Fraction frac2=createFraction();
				System.out.println("Tích hai phân số: ");
				System.out.println(frac1.multiplyFraction(frac2));
				break;
			}
			case 6:
			{
				System.out.println("Nhập phân số thứ 1: ");
				Fraction frac1=createFraction();
				System.out.println("Nhập phân số thứ 2: ");
				Fraction frac2=createFraction();
				System.out.println("Thương hai phân số: ");
				System.out.println(frac1.divideFraction(frac2));
				break;
			}
			case 7:
			{
				System.out.println("Nhập phân số thứ 1: ");
				Fraction frac1=createFraction();
				System.out.println("Nhập phân số thứ 2: ");
				Fraction frac2=createFraction();
				String str=frac1.Comparisons(frac2);
				System.out.println("Phân số thứ 1 "+str+" hơn Phân số thứ 2\n");
				break;
			}
			case 8:
			{
				System.out.println("Kết thúc chương trình!");
				break;
			}
			}
			
		}while(choice !=8);
	}
	static int nhapSoNguyen(String str) {
		System.out.println(str);
		Scanner scn=new Scanner(System.in);
		int x;
		x=scn.nextInt();
		return x;
	}
	public  static Fraction createFraction() throws Exception {
		
		int Numerator,Denominator;
		Numerator= nhapSoNguyen("Nhập tử số: ");
		Denominator=nhapSoNguyen("Nhập mẩu số: ");
		Fraction frac= new Fraction(Numerator,Denominator);
		return frac;
	}
	public static int menu() {
		int a;
		System.out.println("*****MENU*****\n"
				+ "1.Tối giản phân số.\n"
				+ "2.Nghịch đảo phân số.\n"
				+ "3.Cộng 2 phân số\n"
				+ "4.Trừ 2 phân số\n"
				+ "5.Nhân 2 phân số\n"
				+ "6.Chia 2 phân số\n"
				+ "7.So sánh 2 phân số\n"
				+ "8.Thoát!\n");
		do {
			a=nhapSoNguyen("Vui lòng nhập lựa chọn:");
			if(a>=9 || a<=0)
			{
				System.out.println("Chọn lại, lựa chọn không phù hợp!");
			}
		}while(a>=9|| a<=0);
		return a;
	}
}
