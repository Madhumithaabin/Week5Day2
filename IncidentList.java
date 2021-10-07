package Assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;
import java.awt.*;
import java.awt.Label;

public class IncidentList {

	public static void createexport(String incnum, String fileName) throws InvalidFormatException, IOException {
		File excelFile = new File("./snap/" + fileName + ".xlsx");

		XSSFWorkbook wb = null;// =new XSSFWorkbook(excelFile);
		XSSFSheet ws = null;// =wb.createSheet("CreatedIncident");
		XSSFWorkbook existingBook = null;
		FileInputStream fileInputStream = new FileInputStream("./snap/" + fileName + ".xlsx");
			int a = 5, b = 10;
		String text = "Hello";
		if (!excelFile.exists()) {
			wb = new XSSFWorkbook();
			ws = wb.createSheet("Deleted");

			XSSFRow header = ws.createRow(0);
			XSSFCell headervalue = header.createCell(0);
			headervalue.setCellValue("Incident Number");

			XSSFRow deleteInc = ws.createRow(1);
			XSSFCell deletevalue = deleteInc.createCell(0);
			deletevalue.setCellValue(incnum);

		} else {
			wb = new XSSFWorkbook(fileInputStream);

			// step2: get into the worksheet
			ws = wb.getSheet("Deleted");

			int rowCount = ws.getLastRowNum();
			int cellCount = ws.getRow(0).getLastCellNum();
			XSSFRow deleteInc = ws.createRow(rowCount+1);
			XSSFCell deletevalue = deleteInc.createCell(0);
			deletevalue.setCellValue(incnum);
		}

		FileOutputStream fileOutputStream = new FileOutputStream("./snap/" + fileName + ".xlsx");
		wb.write(fileOutputStream);

		wb.close();

	}


	public static void createexport(String incnum,String urgencyState,String incidentState, String fileName) throws InvalidFormatException, IOException {
		File excelFile = new File("./snap/" + fileName + ".xlsx");

		XSSFWorkbook wb = null;// =new XSSFWorkbook(excelFile);
		XSSFSheet ws = null;// =wb.createSheet("CreatedIncident");
		XSSFWorkbook existingBook = null;
			int a = 5, b = 10;
		String text = "Hello";
		if (!excelFile.exists()) {
			wb = new XSSFWorkbook();
			ws = wb.createSheet("Updated");

			XSSFRow header = ws.createRow(0);
			XSSFCell headervalue = header.createCell(0);
			headervalue.setCellValue("Incident Number");
			XSSFCell headervalue1 = header.createCell(1);
			headervalue1.setCellValue("Prioty");
			XSSFCell headervalue2 = header.createCell(2);
			headervalue2.setCellValue("Status");

			XSSFRow deleteInc = ws.createRow(1);
			XSSFCell deletevalue = deleteInc.createCell(0);
			deletevalue.setCellValue(incnum);
			XSSFCell deletevalue1 = deleteInc.createCell(1);
			deletevalue1.setCellValue(urgencyState);
			XSSFCell deletevalue2 = deleteInc.createCell(2);
			deletevalue2.setCellValue(incidentState);

		} else {
			FileInputStream fileInputStream = new FileInputStream("./snap/" + fileName + ".xlsx");

			wb = new XSSFWorkbook(fileInputStream);

			// step2: get into the worksheet
			ws = wb.getSheet("Updated");

			int rowCount = ws.getLastRowNum();
			int cellCount = ws.getRow(0).getLastCellNum();
			XSSFRow deleteInc = ws.createRow(rowCount+1);
			XSSFCell deletevalue = deleteInc.createCell(0);
			deletevalue.setCellValue(incnum);
			XSSFCell deletevalue1 = deleteInc.createCell(1);
			deletevalue1.setCellValue(urgencyState);
			XSSFCell deletevalue2 = deleteInc.createCell(2);
			deletevalue2.setCellValue(incidentState);
	
		}

		FileOutputStream fileOutputStream = new FileOutputStream("./snap/" + fileName + ".xlsx");
		wb.write(fileOutputStream);

		wb.close();

	}

	
	public static void createexport(String incnum,String workNotes,String assignedGroup, String titleName,String fileName) throws InvalidFormatException, IOException {
		File excelFile = new File("./snap/" + fileName + ".xlsx");

		XSSFWorkbook wb = null;// =new XSSFWorkbook(excelFile);
		XSSFSheet ws = null;// =wb.createSheet("CreatedIncident");
		XSSFWorkbook existingBook = null;
			int a = 5, b = 10;
		String text = "Hello";
		if (!excelFile.exists()) {
			wb = new XSSFWorkbook();
			ws = wb.createSheet("Assigned Incident");

			XSSFRow header = ws.createRow(0);
			XSSFCell headervalue = header.createCell(0);
			headervalue.setCellValue("Incident Number");
			XSSFCell headervalue1 = header.createCell(1);
			headervalue1.setCellValue("Work Notes");
			XSSFCell headervalue2 = header.createCell(2);
			headervalue2.setCellValue(titleName);

			XSSFRow deleteInc = ws.createRow(1);
			XSSFCell deletevalue = deleteInc.createCell(0);
			deletevalue.setCellValue(incnum);
			XSSFCell deletevalue1 = deleteInc.createCell(1);
			deletevalue1.setCellValue(workNotes);
			XSSFCell deletevalue2 = deleteInc.createCell(2);
			deletevalue2.setCellValue(assignedGroup);

		} 
		else {
			FileInputStream fileInputStream = new FileInputStream("./snap/" + fileName + ".xlsx");

			wb = new XSSFWorkbook(fileInputStream);

			// step2: get into the worksheet
			ws = wb.getSheet("Assigned Incident");

			int rowCount = ws.getLastRowNum();
			int cellCount = ws.getRow(0).getLastCellNum();
			XSSFRow deleteInc = ws.createRow(rowCount+1);
			XSSFCell deletevalue = deleteInc.createCell(0);
			deletevalue.setCellValue(incnum);
			XSSFCell deletevalue1 = deleteInc.createCell(1);
			deletevalue1.setCellValue(workNotes);
			XSSFCell deletevalue2 = deleteInc.createCell(2);
			deletevalue2.setCellValue(assignedGroup);
	
		}

		FileOutputStream fileOutputStream = new FileOutputStream("./snap/" + fileName + ".xlsx");
		wb.write(fileOutputStream);

		wb.close();

	}

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		/*
		 * File excelFile = new File("D:\\DEMO.xlsx");
		 * 
		 * XSSFWorkbook wb = null;// =new XSSFWorkbook(excelFile); XSSFSheet ws =
		 * null;// =wb.createSheet("CreatedIncident"); XSSFWorkbook existingBook = null;
		 * int a = 5, b = 10; String text = "Hello"; if (!excelFile.exists()) { wb = new
		 * XSSFWorkbook(); ws = wb.createSheet("TESTRESULTS"); } else { // existingBook
		 * = new XSSFWorkbook(excelFile); // wb.c // wb=new XSSFWorkbook(excelFile,
		 * existingBook); // sheet = book.getSheet("TESTRESULTS");
		 * 
		 * }
		 * 
		 * Label v = new Label(text);
		 * 
		 * String[][] valuename = new String[3][3];
		 * 
		 * valuename[0][0] = "test"; valuename[0][1] = "Arun"; valuename[0][2] =
		 * "lakshmi"; valuename[1][0] = "seetha"; valuename[1][1] = "vasuki";
		 * valuename[1][2] = "harish";
		 * 
		 * for (int i = 0; i <3; i++) { XSSFRow createRow = ws.createRow(i); for (int j
		 * = 0; j <3; j++) { XSSFCell createCell = createRow.createCell(j); {
		 * createCell.setCellValue(valuename[i][j]); } }
		 * 
		 * } FileOutputStream fileOutputStream = new
		 * FileOutputStream("./snap/createincident.xlsx"); wb.write(fileOutputStream);
		 * 
		 * wb.close();
		 * 
		 */ }

}
