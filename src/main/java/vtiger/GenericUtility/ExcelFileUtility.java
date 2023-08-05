
package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author suvendu
 *
 */
public class ExcelFileUtility {
	/**
	 * this method will read data from excel sheet based on sheetName rowNo
	 * @param sheetName
	 * @param rowNum
	 * @param celNo
	 * @return
	 * @throws IOException
	 */
		public String getDataFromExcel(String sheetName, int rowNum, int celNo) throws IOException 
	{
		FileInputStream fis = new FileInputStream(Iconstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(celNo).getStringCellValue();
		wb.close();
		return value;
	}
		/**
		 * this method write data into the excel sheet
		 * @param sheetName
		 * @param rowNo
		 * @param celNo
		 * @param data
		 * @throws Throwable 
		 * @throws EncryptedDocumentException 
		 */
	public  void writeDataIntoExcel(String sheetName, int rowNo, int celNo, String data) throws EncryptedDocumentException, Throwable 
	{
		FileInputStream fis = new FileInputStream(Iconstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetName);
		Row rw = sh.createRow(rowNo);
		Cell cl= rw.createCell(celNo);
		cl.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(Iconstant.excelfilepath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 *this method Will read all the data Inside a sheet to used in data provider 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleData(String sheetName) throws Throwable
	{
	FileInputStream fis = new FileInputStream("Iconstant.excelfilepath");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int lastRow = sh.getLastRowNum();
	int lastCel = sh.getRow(0).getLastCellNum();
	Object [][] data= new Object[lastRow][lastCel];
	
	for(int i=0; i<lastRow; i++)
	{
		for(int j=0; j<lastCel; j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			
		}
	}
	
	return data;
	
	}
	
}
