package vtiger.Pratice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {

	@Test
	public void read()
	{
		String un = System.getProperty("username");
		System.out.println(un);
		String pwd = System.getProperty("password");
		System.out.println(pwd);
	}
	
}
