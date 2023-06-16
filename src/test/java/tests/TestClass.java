package tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public static void main (String args[])
	{
		File file = new File("C:\\Automation-Selenium\\Book1.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
//			XSSFSheet sheet = workbook.getSheetAt(0);
			sheet = workbook.getSheet("testsheet");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sheet.getLastRowNum());
		Row row = sheet.getRow(1);
		System.out.println(row.getLastCellNum());
		
		for(int i=0; i<=sheet.getLastRowNum(); i++) 
		{
			row = sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++) 
			{
				System.out.print(sheet.getRow(i).getCell(j));
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("data of row 2");

		List<String> list = getData(3);
		System.out.println(list);
		
		Object [][] arr = getData();
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[0].length; j++) {
			System.out.println(arr[i][j]);
			}
			}
	}
	public static List<String> getData(int rownum)
	{
		Row row = sheet.getRow(rownum);
		List<String> list = new ArrayList<String>();
		for(int j=0; j<row.getLastCellNum(); j++) 
		{
			list.add(sheet.getRow(rownum).getCell(j).toString());
		}
		 return list;
	}
	public static int getrowNum()
	{
		return sheet.getLastRowNum();
	}
	
	public static int getcolNum()
	{
		return sheet.getRow(0).getLastCellNum();
	}
	
	public static Object[][] getData()
	{

		Object[][] arr = new Object[getrowNum()+1][getcolNum()];
		
		for(int i=0; i<= getrowNum(); i++) 
		{
			Row row = sheet.getRow(i);
			for(int j=0; j<getcolNum(); j++) 
			{
				arr[i][j] = sheet.getRow(i).getCell(j);
			}
		}
		return arr;
		
	}
}

