package tuan3;

import java.util.Arrays;
import java.util.Comparator;

public class SinhVienArray {
private SinhVien[] students;
public int SPTT=0;
public SinhVien[] getStudents() {
	return students;
}
public SinhVienArray()
{
	super();
	students= new SinhVien[1];
}
public boolean IsExistingIDStudent(int IDStudent) {
	for(int i=0;i<SPTT;i++)
	{
		if(IDStudent==students[i].getIDstudent())
		{
			return true;
		}
	}
	return false;
}
public void add(SinhVien sv1) throws Exception
{
	if(!IsExistingIDStudent(sv1.getIDstudent())) {
		if(SPTT==students.length)
		{
			students=copyArray(students,students.length*2);
		}
		students[SPTT++]=sv1;
	}
	else 
		throw new Exception("Mã sinh viên đã tồn tại!");
}
public SinhVien[] copyArray(SinhVien[] arr, int length) {
	SinhVien[] newArr= new SinhVien[length];
	for(int i=0;i<SPTT;i++)
	{
		newArr[i]=arr[i];
	}
	return newArr;
}
public SinhVien[] sortByIDStudent() {
	SinhVien[] sortedArr=copyArray(students, SPTT);
	SinhVien temp;
	int n=SPTT;
	for(int i=0;i<n-1;i++) {
		for(int j=i+1;j<n;j++)
		{
			if(sortedArr[i].getIDstudent()>sortedArr[j].getIDstudent())
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
