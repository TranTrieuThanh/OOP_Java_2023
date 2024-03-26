package tuan4;

import java.util.Arrays;
import java.util.Comparator;

public class CDDiscArray {
	private CDDisc[] discs;
	public int SPTT=0;
	public CDDisc[] getDiscs() {
		return discs;
	}
	public CDDiscArray() {
		super();
		discs=new CDDisc[1];
	}
	public boolean isExistingCDCode(int CDCode) {
		for(int i=0;i<SPTT;i++)
		{
			if(CDCode==discs[i].getCDCode())
			{
				return true;
			}
		}
		return false;
	}
	public void add(CDDisc disc) throws Exception{
		if(!isExistingCDCode(disc.getCDCode()))
		{
			if(SPTT==discs.length)
			{
				discs=copyArray(discs,discs.length*2);
				
			}
			discs[SPTT++]=disc;
		}
		else
		{
			throw new Exception("Mã CD đã tồn tại!.");
		}
	}
	public CDDisc[] copyArray(CDDisc[] arr, int length) {
		CDDisc[] newArr = new CDDisc[length];
		for(int i=0;i<SPTT;i++) {
			newArr[i]=arr[i];

		}
		return newArr;
	}
	public int searchIndexOfCD(int CDCode) {
		for(int i=0;i<SPTT;i++) {
			if(discs[i].getCDCode()==CDCode)
			{
				return i;
			}
		}
		return -1;
	}
	public int totalCD() {
		int total=0;
		for(int i=0;i<SPTT;i++)
		{
			total++;
			
		}
		return total;
	}
	public double totalPrice() {
		double total=0;
		for(int i=0;i<SPTT;i++)
		{
			total=total+discs[i].getPrice();
			
		}
		return total;
	}
	public CDDisc[] sortByCDCodeCompartor() {
		CDDisc[] newdisc = new CDDisc[SPTT];
		for (int i=0;i<SPTT;i++)
		{
			newdisc[i]=discs[i];
		}
		Arrays.sort(newdisc, new Comparator<CDDisc>() {
			@Override
			public int compare(CDDisc disc1, CDDisc disc2) {
				// TODO Auto-generated method stub
				Double gia1=(Double)disc1.getPrice();
				Double gia2=(Double)disc2.getPrice();
				return gia2.compareTo(gia1);
			}
		});
		return newdisc;
	}
	public CDDisc[] sortByCDName() {
		CDDisc[] sortedArr=copyArray(discs, SPTT);
		CDDisc temp;
		int n=SPTT;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++)
			{
				if(sortedArr[i].getCDName().compareTo(sortedArr[j].getCDName())<0)
				{
					temp=sortedArr[j];
					sortedArr[j]=sortedArr[i];
					sortedArr[i]=temp;
				}
			}
		}
		return sortedArr;
	}
}
