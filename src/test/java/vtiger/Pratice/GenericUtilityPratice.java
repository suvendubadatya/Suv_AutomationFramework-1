package vtiger.Pratice;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtillity;

public class GenericUtilityPratice {

	public static void main(String[] args) throws Throwable {
		
		JavaUtility jutil = new JavaUtility();
		int value = jutil.getRandomNumber();
		System.out.println(value);
		
		System.out.println(jutil.getSystemDate());
		
		System.out.println(jutil.getSystemDateFormat());
		
		PropertyFileUtillity putil = new PropertyFileUtillity();
		String value2= putil.getDataFromPropertyFile("url");
		System.out.println(value2);
		
		ExcelFileUtility eutil = new ExcelFileUtility();
		String data = eutil.getDataFromExcel("Organization", 1, 2);
		System.out.println(data);
		
		eutil.writeDataIntoExcel("sample", 3, 4, "BatMan");
		System.out.println("Data added");
		
	}
}


