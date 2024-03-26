package tuan2;

import java.util.Arrays;
import java.util.Comparator;

public class AccountArray {
private Account[] accounts;
public int SPTT=0;
public Account[] getAccounts() {
	return accounts;
}
public AccountArray() {
	super();
	accounts=new Account[1];
}
public boolean isExistingAccNumber(long accountNumber) {
	for(int i=0;i<SPTT;i++)
	{
		if(accountNumber==accounts[i].getSoTaiKhoan())
		{
			return true;
		}
	}
	return false;
}
public void add(Account acc) throws Exception{
	if(!isExistingAccNumber(acc.getSoTaiKhoan()))
	{
		if(SPTT==accounts.length)
		{
			accounts=copyArray(accounts,accounts.length*2);
			
		}
		accounts[SPTT++]=acc;
	}
	else
	{
		throw new Exception("Số tài khoản này đã tồn tại.");
	}
}
public Account[] copyArray(Account[] arr, int length) {
	Account[] newArr = new Account[length];
	for(int i=0;i<SPTT;i++) {
		newArr[i]=arr[i];

	}
	return newArr;
}
public int searchIndexOfAccount(long accountNumber) {
	for(int i=0;i<SPTT;i++) {
		if(accounts[i].getSoTaiKhoan()==accountNumber)
		{
			return i;
		}
	}
	return -1;
}
public Account searchAccount(long accountNumber) {
	int index=searchIndexOfAccount(accountNumber);
	if(index!=-1)
	{
		return accounts[index];

	}
	else {
		return null;
	}
}
public void deleteAccount(long accountNumber) throws Exception{
	int index=searchIndexOfAccount(accountNumber);
	if(index!=1) {
		for(int i=index;i<SPTT-1;i++)
		{
			accounts[i]=accounts[i+1];
		}
		SPTT--;
	}else
		throw new Exception("Không tìm thấy tài khoản");
}
public void update(Account acc) throws Exception{
	int index=searchIndexOfAccount(acc.getSoTaiKhoan());
	if(index!=1) 
		accounts[index]=acc;
	else
		throw new Exception("Không tìm thấy tài khoản");
		
}
public Account[] sortByAccountNumber() {
	Account[] sortedArr=copyArray(accounts, SPTT);
	Account temp;
	int n=SPTT;
	for(int i=0;i<n-1;i++) {
		for(int j=0;j<n-i;j++)
		{
			if(sortedArr[j].getSoTienTrongTK()>sortedArr[j-1].getSoTienTrongTK())
			{
				temp=sortedArr[i];
				sortedArr[j]=sortedArr[j+1];
				sortedArr[j+1]=temp;
			}
		}
	}
	return sortedArr;
}
public Account[] sortByaccountNumberCompartor() {
	Account[] accountMoi = new Account[SPTT];
	for (int i=0;i<SPTT;i++)
	{
		accountMoi[i]=accounts[i];
	}
	Arrays.sort(accountMoi, new Comparator<Account>() {
		@Override
		public int compare(Account acc1, Account acc2) {
			// TODO Auto-generated method stub
			Double soDu1=(Double)acc1.getSoTienTrongTK();
			Double soDu2=(Double)acc2.getSoTienTrongTK();
			return soDu1.compareTo(soDu2);
		}
	});
	return accountMoi;
}

}
