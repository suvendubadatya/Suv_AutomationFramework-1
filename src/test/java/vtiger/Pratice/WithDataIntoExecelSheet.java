package vtiger.Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WithDataIntoExecelSheet {
public static void main(String[] args) throws Throwable {
	
	FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh = wb.createSheet("Trialcon");
	 Row rw = sh.createRow(4);
	 Cell ce = rw.createCell(3);
	ce.setCellValue("Spider man");
	
	
	FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	wb.write(fos);
	System.out.println("data added");
	
	wb.close();
	System.out.println("successfully created");
	
}
}
