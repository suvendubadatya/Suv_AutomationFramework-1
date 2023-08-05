package vtiger.GenericUtility;


import java.util.Date;

import java.util.Random;

	/**
 * this is consist of all generic method related to java
 * @author suvendu 
 *
 */
public class JavaUtility {
		/**
		 * this method will generate a random number for every execution
		 * @return Random value
		 */

		public int getRandomNumber()
		{
			Random r= new Random();
			int ran= r.nextInt(1000);
			return ran;
		}
		/**
		 * this method will generate system date
		 * @return 
		 * @return
		 */
		public String getSystemDate()
		{
			Date d= new Date();
			String date = d.toString();
			return date;			
		}
		/**
		 * this method will generate specific date in specific format
		 * @return current system date
		 */
		public String getSystemDateFormat()
		{
		Date d= new Date();
		String[] date = d.toString().split(" ");
		String currentDate= date[2];
		String month= date[1];
		String year = date[5];
		String time= date[3].replace(":", "-");
		
		String dateInFormat= currentDate+"/"+month+"/"+year+"_"+time;
		return dateInFormat;
		}
		
		
		


	
		
		
		
}


