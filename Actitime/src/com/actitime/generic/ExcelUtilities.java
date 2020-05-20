package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Sneha
 * Created on 4th Jan 2019 at 5:09pm	
 */
public class ExcelUtilities {

	String filepath;
	public ExcelUtilities(String filepath)
	{
		this.filepath=filepath;
	}

	 /**
	  * @author Sneha
	  * @param sheetName
	  * @param row
	  * @param cell
	  * @return String
	  */
	public String readData(String sheetName, int row, int cell)
	{
		String value = null;
		
		try{
			FileInputStream fis = new FileInputStream(new File(filepath));
			Workbook wb = WorkbookFactory.create(fis);
			Cell cl = wb.getSheet(sheetName).getRow(row).getCell(cell);
			
			switch (cl.getCellType()) //4.1.0
			{
			
			case STRING:
				value = cl.getStringCellValue();
				break;
				
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(cl))
				{
					SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
					value= sdf.format(cl.getDateCellValue());
				}
				else
				{
					long longValue = (long) cl.getNumericCellValue();
					value= Long.toString(longValue);
				}
				break;
				
			case BOOLEAN:
				
				value= Boolean.toString(cl.getBooleanCellValue());
				break;
				
			default:
				break;
			}
		}
		catch(EncryptedDocumentException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		return value;
		
		
		
		
		
		
		
	}
	
	
	
	
}
