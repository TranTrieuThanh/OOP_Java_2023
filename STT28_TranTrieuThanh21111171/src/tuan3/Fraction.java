package tuan3;

public class Fraction {
	private int Numerator,Denominator;

	public int getNumerator() {
		return Numerator;
	}

	public void setNumerator(int numerator) {
		Numerator = numerator;
	}

	public int getDenominator() {
		return Denominator;
	}

	public void setDenominator(int denominator) {
		Denominator = denominator;
	}

	public Fraction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fraction(int numerator, int denominator) throws Exception{
		super();
		Numerator = numerator;
		if(denominator!=0)
		{
			Denominator = denominator;
		}
		else
		{
			throw new Exception("Mẫu số phải khác 0");
		}
	}
	 public int gcd(int a, int b){
	    
	    if (a == 0 || b == 0){
	        return a + b;
	    }
	    while (a != b){
	        if (a > b){
	            a -= b; 
	        }else{
	            b -= a;
	        }
	    }
	    return a; 
	}
	public Fraction reduceFraction() throws Exception {
		int Numerator,Denominator;
		Numerator=this.getNumerator();
		Denominator=this.getDenominator();
		int same;
		same=gcd(Numerator, Denominator);
		Numerator=Numerator/same;
		Denominator=Denominator/same;
		Fraction frac1= new Fraction(Numerator,Denominator);
		return frac1;
		
		
	}
	public Fraction reciprocalFraction() throws Exception {
		int Numerator,Denominator;
		Numerator=this.getDenominator();
		Denominator=this.getNumerator();
		Fraction frac1= new Fraction(Numerator,Denominator);
		return frac1;
		
	}
	public Fraction addFraction(Fraction frac2) throws Exception{
		int Numerator,Denominator;
		Numerator=(this.getNumerator()*frac2.getDenominator())+(frac2.getNumerator()*this.getDenominator());
		Denominator=this.getDenominator()*frac2.getDenominator();
		Fraction frac= new Fraction(Numerator,Denominator);
		frac=frac.reduceFraction();
		return frac;
	}
	public Fraction subtractFraction(Fraction frac2) throws Exception{
		int Numerator,Denominator;
		Numerator=(this.getNumerator()*frac2.getDenominator())-(frac2.getNumerator()*this.getDenominator());
		Denominator=this.getDenominator()*frac2.getDenominator();
		Fraction frac= new Fraction(Numerator,Denominator);
		frac=frac.reduceFraction();
		return frac;
	}
	public Fraction multiplyFraction(Fraction frac2) throws Exception{
		int Numerator,Denominator;
		Numerator=this.getNumerator()*frac2.getNumerator();
		Denominator=this.getDenominator()*frac2.getDenominator();
		Fraction frac= new Fraction(Numerator,Denominator);
		frac=frac.reduceFraction();
		return frac;
	}
	public Fraction divideFraction(Fraction frac2) throws Exception{
		Fraction frac= new Fraction();
		frac=multiplyFraction( frac2.reciprocalFraction());
		frac=frac.reduceFraction();
		return frac;
	}
	public String Comparisons(Fraction frac2)
	{
	    float num1 = (float) this.getNumerator()/this.getDenominator();
	    float num2 = (float) frac2.getNumerator()/frac2.getDenominator();
	    float subtract = num1-num2;
	    String str1="Lớn";
	    String str2="Nhỏ";
	    if(subtract > 0 )
	    {

	    			
	        return str1;
	    }
	    return str2;
	}

	@Override
	public String toString() {
		String str=String.format("%d"+"/"+"%-10d", getNumerator(),getDenominator());
		return str;
	}
	
}
