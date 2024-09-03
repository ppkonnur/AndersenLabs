package Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadExcelData {
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		// TODO Auto-generated method stub
//		ReadExcelData rd = new ReadExcelData();		
//		rd.getData("Login");
//	}
	
	@DataProvider(name="testData")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		String sheetName = m.getName();		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fs = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sheetname = wb.getSheet(sheetName);
		
		int totalRow = sheetname.getLastRowNum();
		Row rowCells = sheetname.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		
		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRow][totalCols];
		
		for(int i = 1; i<=totalRow; i++) {
			for(int j = 0; j<totalCols; j++) {
				testData[i-1][j]=format.formatCellValue(sheetname.getRow(i).getCell(j));
				//System.out.println(testData[i-1][j]);
			}
		}
		return testData;
	}
}
