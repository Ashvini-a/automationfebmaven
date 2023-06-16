package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

		XSSFWorkbook workbook;
		XSSFSheet sheet;
		
		public static String path = System.getProperty("user.dir") + "\\src\\test\\resources\\";
		
		public ExcelReader(String fileName, String sheetname)
		{
			String filePath = path+fileName;
			System.out.println(path);
		    System.out.println(filePath);
			File file = new File(filePath);
			
			try {
				FileInputStream fis = new FileInputStream(file);
				workbook = new XSSFWorkbook(fis);
//				XSSFSheet sheet = workbook.getSheetAt(0);
				sheet = workbook.getSheet(sheetname);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public ExcelReader(String fileName)
		{
			String filePath = path + fileName;
			System.out.println(filePath);
			File file = new File(filePath);
			
			try {
				FileInputStream fis = new FileInputStream(file);
				workbook = new XSSFWorkbook(fis);
//				XSSFSheet sheet = workbook.getSheetAt(0);
				sheet = workbook.getSheetAt(0);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public int getrowNum()
		{
			return sheet.getLastRowNum();
		}
		
		public int getcolNum()
		{
			return sheet.getRow(0).getLastCellNum();
		}
		public Object[][] getData() {
			Object[][] arr = new Object[getrowNum() + 1][getcolNum()]; // 3,4

			for (int i = 0; i <= getrowNum(); i++) {
				for (int j = 0; j < getcolNum(); j++) {

					arr[i][j] = sheet.getRow(i).getCell(j);
				}
			}
			return arr;
		}
		
		public Map<String , String> getDataInMap(int rownum){
			Map<String , String> map = new HashMap<String , String>();
			
//			List<String> keys = getData(0);
//			Iterator<String> itr= keys.iterator();
//			Row keys = sheet.getRow(0);
			
			for(int j=0; j<getcolNum(); j++) {
				String value = sheet.getRow(rownum).getCell(j).toString();
//				String key = itr.next();
				String key = sheet.getRow(0).getCell(j).toString();
				map.put(key, value);
			}
			return map;
		}
		
		public List<String> getData(int rownum)
		{
			Row row = sheet.getRow(rownum);
			List<String> list = new ArrayList<String>();
			for(int j=0; j<getcolNum(); j++) 
			{
				list.add(sheet.getRow(rownum).getCell(j).toString());
			}
			 return list;
		}
		
		public String getCellData(int row, int col)
		{
			return sheet.getRow(row).getCell(col).toString();
		}
		
		
}
