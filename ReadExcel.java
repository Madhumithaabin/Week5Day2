package Assignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String[][] readData(String fileName) throws IOException {
		//step1: setup the path of the workbook
		XSSFWorkbook wb = new XSSFWorkbook("./snap/"+fileName+".xlsx");
		
		//step2: get into the worksheet
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rowCount = ws.getLastRowNum();
		int cellCount = ws.getRow(0).getLastCellNum();
		
		//declare the String[][]
		String[][] data = new String[rowCount][cellCount];
				
		//to navigate with rows
		for (int i = 1; i <= rowCount; i++) {
			//columns
			for(int j = 0; j < cellCount; j++) { //4
				String text = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
				//0,0
				data[i-1][j] = text;
			}
			
		}
			
		//final step
		wb.close();
		
		return data;
		
	}
}
