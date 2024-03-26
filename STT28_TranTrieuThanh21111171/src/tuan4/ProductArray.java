package tuan4;
import java.util.Arrays;
import java.util.Comparator;
public class ProductArray {
	private HangThucPham[] products;
	public int SPTT=0;
	public HangThucPham[] getProducts() {
		return products;
	}
	public ProductArray() {
		super();
		products=new HangThucPham[1];
	}
	public boolean isExistingProductCode(String productCode) {
		for(int i=0;i<SPTT;i++)
		{
			if(productCode.equals(products[i].getCode()))
			{
				return true;
			}
		}
		return false;
	}
	public void add(HangThucPham hang) throws Exception{
		if(!isExistingProductCode(hang.getCode()))
		{
			if(SPTT==products.length)
			{
				products=copyArray(products,products.length*2);
				
			}
			products[SPTT++]=hang;
		}
		else
		{
			throw new Exception("Mã hàng đã tồn tại!.");
		}
	}
	public HangThucPham[] copyArray(HangThucPham[] arr, int length) {
		HangThucPham[] newArr = new HangThucPham[length];
		for(int i=0;i<SPTT;i++) {
			newArr[i]=arr[i];

		}
		return newArr;
	}
	public int searchIndexOfProduct(String productCode) {
		for(int i=0;i<SPTT;i++) {
			if(products[i].getCode().equals(productCode))
			{
				return i;
			}
		}
		return -1;
	}
	public HangThucPham searchProduct(String productCode) {
		int index=searchIndexOfProduct(productCode);
		if(index!=-1)
		{
			return products[index];

		}
		else {
			return null;
		}
	}
	public void deleteProduct(String productCode) throws Exception{
		int index=searchIndexOfProduct(productCode);
		if(index!=1) {
			for(int i=index;i<SPTT-1;i++)
			{
				products[i]=products[i+1];
			}
			SPTT--;
		}else
			throw new Exception("Không tìm thấy hàng hóa");
	}
	public void update(HangThucPham hang) throws Exception{
		int index=searchIndexOfProduct(hang.getCode());
		if(index!=1) 
			products[index]=hang;
		else
			throw new Exception("Không tìm thấy tài khoản");
			
	}
	public HangThucPham[] sortByProductPrice() {
		HangThucPham[] sortedArr=copyArray(products, SPTT);
		HangThucPham temp;
		int n=SPTT;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-i;j++)
			{
				if(sortedArr[j].getPrice()>sortedArr[j-1].getPrice())
				{
					temp=sortedArr[i];
					sortedArr[j]=sortedArr[j+1];
					sortedArr[j+1]=temp;
				}
			}
		}
		return sortedArr;
	}
	public HangThucPham[] sortByproductPriceCompartor() {
		HangThucPham[] productMoi = new HangThucPham[SPTT];
		for (int i=0;i<SPTT;i++)
		{
			productMoi[i]=products[i];
		}
		Arrays.sort(productMoi, new Comparator<HangThucPham>() {
			@Override
			public int compare(HangThucPham pro1, HangThucPham pro2) {
				// TODO Auto-generated method stub
				Double price1=(Double)pro1.getPrice();
				Double price2=(Double)pro2.getPrice();
				return price1.compareTo(price2);
			}
		});
		return productMoi;
	}
}
