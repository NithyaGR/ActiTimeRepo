package com.qa.acti.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviderReadExcel {
	
	XSSFWorkbook wb1;
	
	public DataProviderReadExcel() {
		
		try{
			File src1 = new File("C:\\workspace\\MavenProject\\src\\main\\java\\com\\qa\\acti\\utility\\TestData.xlsx");
			FileInputStream fis1 = new FileInputStream(src1);
			wb1 = new XSSFWorkbook(fis1);
			
					
		}
		catch (Exception e) {
			System.out.println("File not found: "+e.getMessage());
		}
		
		
		}
	public int getRowCount(int SheetNum){
		
		int rowCount = wb1.getSheetAt(SheetNum).getLastRowNum()+1;
		return rowCount;
	}
	
	public String getCellData(int SheetNum, int row, int col){
		
		String cellData = wb1.getSheetAt(SheetNum).getRow(row).getCell(col).toString();
		return cellData;
	}

}
