package vtiger.Pratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileEx {

	public static void main(String[] args) throws IOException   {
		
		//step 1- load the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
				
		//step 2- create object of properties class from java.util
		Properties pObj = new Properties();
		
		//step 3 - load the file into properties class
		pObj.load(fis);
		
		//step 4- provide the key and get the value
		String value = pObj.getProperty("username");
		System.out.println(value);
		
		
		
		
		
		

	}

}
