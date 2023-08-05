package vtiger.Pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws Throwable {
		
	//Get a driver from my SQL jar Register this in driver manager 
	Driver driverRef=  new Driver();
		
	//step 1 : register the driver
	DriverManager.registerDriver(driverRef);
				
	//step 2.Get the connection of the driver provide Db name  
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "tiger", "tiger");
						
	// Step 3 issue create statement 
	Statement state = con.createStatement();
				
	//Step 4 execute the query provide table name  
	String query = "insert into customerinfo values('hulk', 4, 'delhi');";
	int result= state.executeUpdate(query);
	
	//validate
	if(result==1)
	{
		System.out.println("data added");	
	}
	else
	{
		System.out.println("data not added");
	}
	
	}

}
