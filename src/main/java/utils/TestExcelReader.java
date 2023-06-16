package utils;

public class TestExcelReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelReader excel = new ExcelReader("Book1.xlsx","testsheet");
//		Object[][] data1 = excel1.getData();
		ExcelReader excel2 = new ExcelReader("Book2.xlsx");
//		Object[][] data2 = excel2.getData();
		//Book1.xlsx
		System.out.println(excel.getrowNum());
		System.out.println(excel.getcolNum());
		//Book2.xlsx
		System.out.println(excel2.getrowNum());
		System.out.println(excel2.getcolNum());
		System.out.println(excel.getData(2));
		System.out.println(excel2.getData(5));
		
		ExcelReader cred = new ExcelReader("credentials.xlsx");
		System.out.println(cred.getDataInMap(1));
		System.out.println(cred.getDataInMap(2));
		System.out.println(cred.getDataInMap(4));
		System.out.println(cred.getDataInMap(5));
	}

}
