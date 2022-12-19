package com.spicejet.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	private Workbook book;
	private FileInputStream fisexcel;
	
	/**
	 * This method is used to open the excel sheet
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void openExcel() throws EncryptedDocumentException, IOException
	{
		
		fisexcel= new FileInputStream(IConstantPath.EXCEL_PATH);
		book= WorkbookFactory.create(fisexcel);
		
	}
	/**
	 * This method is used to get the Data from the Excel

	 * @param sheetName
	 * @param RowNumber
	 * @param cellNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
		public String getDataFromExcel( String sheetName, int RowNumber,int cellNumber) 
	{
		
		DataFormatter df= new DataFormatter();
		String data = df.formatCellValue(book.getSheet(sheetName).getRow(RowNumber).getCell(cellNumber));
		return data;
		
	}
	/**
	 * This method is used to set the into the excel
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param message
	 * @throws IOException
	 */
	public void setDataToExcel( String excelPath, String sheetName,int rowNumber,int cellNumber,String message) 
	{
		book.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).setCellValue(message);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(excelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method is used to close the excel sheet
	 * @throws IOException 
	 */
	
	public void closeExcel() throws IOException
	{
	
			book.close();
		fisexcel.close();
		
		
	}


}
