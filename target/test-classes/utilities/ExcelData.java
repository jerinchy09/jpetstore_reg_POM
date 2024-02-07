package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	String filepath="E:\\Nexvalli\\Eclipse Wrokspace\\jpetstore_reg_POM\\POM_jepetstore_reg.xlsx";
	
	public String[] readExcel() throws IOException {
		String[] data = new String[5];
		
		FileInputStream fis = new FileInputStream(filepath);
		 //read the workbook
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//random string generator fr username 
		//String un = RandomStringUtils.randomAlphabetic(3); 
		
		Row row = sheet.getRow(1);
		
		Cell cell1 = row.getCell(0);
		String username = cell1.getStringCellValue();

		Cell cell2 = row.getCell(1);
		String password= cell2.getStringCellValue();
		
		Cell cell3 = row.getCell(2);
		String rep_password= cell3.getStringCellValue();
		
		data[0]=username;		
		data[1]=password;
		data[2]=rep_password;
		
		return data;
		
	}
}
