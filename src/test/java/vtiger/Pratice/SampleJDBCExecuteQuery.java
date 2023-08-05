package vtiger.Pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

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
		ResultSet result = state.executeQuery("select * from customerinfo;");
		while(result.next())
		{
			System.out.println(result.getString(2));
		}
		
		//State 5 close the database 
		con.close();
		
		
		
		

	}

}
