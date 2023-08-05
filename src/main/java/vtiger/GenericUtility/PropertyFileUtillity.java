package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * this method consist of generic methods related to property file
 * @author suvendu
 *
 */
public class PropertyFileUtillity {

	/**
	 * this method reads the data from property file based on given key
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getDataFromPropertyFile(String  key) throws Throwable 
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		
		
	}

}
