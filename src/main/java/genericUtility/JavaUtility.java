package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class JavaUtility {
	
	/**
	 * This method is used to read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fi = new FileInputStream("D:\\eclipse\\Assignment\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fi);
		String value = p.getProperty(key);
		return value;
	}
	
	/**
	 * This method is used to read data from excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("D:\\eclipse\\Assignment\\src\\test\\resources\\AssignmentData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNo);
		Cell cl = rw.getCell(cellNo);
		String value = cl.getStringCellValue();
		return value;
	}

}
