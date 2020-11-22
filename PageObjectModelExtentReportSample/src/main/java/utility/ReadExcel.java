package utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String[][] excelData(String fileName) throws IOException
	{
		//to get into the workbook
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");   
		//to get into right sheet using index
		XSSFSheet sheet = wb.getSheetAt(0); 
		//to find the rows excluding first one
		int rowcount=sheet.getLastRowNum();
		//cell count
		int cellcount=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[rowcount][cellcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				String cellValue=sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=cellValue;
			}
		}
		
		
		
		wb.close();	
		return data;
		
	}

}
