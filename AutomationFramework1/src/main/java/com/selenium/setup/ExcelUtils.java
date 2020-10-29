package com.selenium.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;
	private static FileInputStream excelFile;
	private static String filePath;
	private static XSSFCell Cell;

	private static XSSFRow Row;
	// reads data from excel and sends to the data provider
	public static Object[][] readExcelData(String testData, String testCaseName) throws Exception {

		String[][] arrayExcelData ;

		String value="";

		String workingDir = System.getProperty("user.dir");

		filePath = workingDir+File.separator+"TataAig_RunManger.xlsx";

		excelFile = new FileInputStream(filePath);

		ExcelWBook = new XSSFWorkbook(excelFile);

		ExcelWSheet = ExcelWBook.getSheet(testData);

		ArrayList<Integer> coun = new ArrayList<Integer>();

		int rowCount = ExcelWSheet.getLastRowNum();
		int colCount = ExcelWSheet.getRow(1).getLastCellNum();
		

		for(int k=0; k< rowCount; k++)
		{
			try {
				Row = ExcelWSheet.getRow(k);
				Cell = Row.getCell(0);
				String Value = Cell.getStringCellValue();
				if(Value.equalsIgnoreCase(testCaseName))
				{
					coun.add(k);	
				}
				
			}catch (Exception e){
				e.printStackTrace();
				
			}
		}


		int len = coun.size();
		arrayExcelData = new String[len][colCount-1];
		
		for(int l =0; l< len; l++)
		{
			Row row = ExcelWSheet.getRow(coun.get(l));

			for(int j=2;j<=colCount;j++)

			{
				Cell cell = row.getCell(j);


				if(cell.getCellType()== cell.CELL_TYPE_NUMERIC)
				{
					value = ""+cell.getNumericCellValue();
					
				}
				else
				{
					value = cell.getStringCellValue();
					
				}
				
				arrayExcelData[l][j-2] = value;
			}

		}


		return arrayExcelData;
	}

// gets property value from run manager
	public static final String readProperty(int RowNum,int ColNum)
	{


		try {
			String[][] arrayExcelData = null;

			String value="";

			String workingDir = System.getProperty("user.dir");

			filePath = workingDir+File.separator+"TataAig_RunManger.xlsx";

			excelFile = new FileInputStream(filePath);

			ExcelWBook = new XSSFWorkbook(excelFile);

			ExcelWSheet = ExcelWBook.getSheet("runSetting");

		} catch (Exception e){
			e.printStackTrace();

		}

		try {
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			String Value = Cell.getStringCellValue();
			return Value;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}

	}

	// verified execution permission
	public static boolean getRunPermission(String testData, String testCaseName) throws IOException
	{
		String[][] arrayExcelData = null;

		String value="";

		String workingDir = System.getProperty("user.dir");

		filePath = workingDir+File.separator+"TataAig_RunManger.xlsx";

		excelFile = new FileInputStream(filePath);

		ExcelWBook = new XSSFWorkbook(excelFile);

		ExcelWSheet = ExcelWBook.getSheet(testData);

		ArrayList<Integer> coun = new ArrayList<Integer>();

		int rowCount = ExcelWSheet.getLastRowNum();
		int colCount = ExcelWSheet.getRow(1).getLastCellNum()-1;
		arrayExcelData = new String[rowCount][colCount];



		
		for(int k=0; k< rowCount; k++)
		{
			try {
				Row = ExcelWSheet.getRow(k);
				Cell = Row.getCell(0);
				String Value = Cell.getStringCellValue();
				if(Value.equalsIgnoreCase(testCaseName))
				{
					coun.add(k);	
				}
				
			}catch (Exception e){
				e.printStackTrace();
				
			}
		}
		int len = coun.size();


		for(int l =0; l< len; l++)
		{
			Row row = ExcelWSheet.getRow(coun.get(l));

			
				Cell cell = row.getCell(1);


				if(cell.getCellType()== cell.CELL_TYPE_NUMERIC)
				{
					value = ""+cell.getNumericCellValue();
				}
				else
				{
					value = cell.getStringCellValue();
				}


		}
		if(value.equalsIgnoreCase("yes"))
		{
			return true;
		}
		else
		{
			return false;
		}

	}


}



