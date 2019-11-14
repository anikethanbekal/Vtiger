package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static int getRow(String path, String sheet) {
		FileInputStream fis;
		int rc=-1;
		try {
			fis = new FileInputStream(path);
			Workbook w = WorkbookFactory.create(fis);
			rc = w.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rc;
	}
	public static int getColumn(String path, String sheet) {
		FileInputStream fis;
		int cc =-1;
		try {
			fis = new FileInputStream(path);
			Workbook w = WorkbookFactory.create(fis);
			cc = w.getSheet(sheet).getRow(0).getLastCellNum();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return cc;
	}
	public static String getData(String path, String sheet,int row , int col) {
		String value ="";
		Workbook w;
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			w = WorkbookFactory.create(fis);
			value = w.getSheet(sheet).getRow(row).getCell(col).toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	public static void createFile(String path,String sheetName) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {
		Workbook w = WorkbookFactory.create(new FileInputStream(path));
		 Sheet sh = w.createSheet(sheetName);
		 sh.createRow(0).createCell(0).setCellValue("Name");
		 sh.getRow(0).createCell(1).setCellValue("Status");
		 FileOutputStream fos = new FileOutputStream(path);
		 w.write(fos);
		 fos.close();
		 w.close();
	}
	public static void report(String name, String path, String sheet_name, int row, int col, int testcasestatus) throws IOException, EncryptedDocumentException, InvalidFormatException {
		Workbook w = WorkbookFactory.create(new FileInputStream(path));
		Sheet sh = w.getSheet(sheet_name);
		sh.createRow(row).createCell(col).setCellValue(name);
		col++;
		sh.getRow(row).createCell(col).setCellValue(testcasestatus);
		FileOutputStream fio = new FileOutputStream(path);
		w.write(fio);
		w.close();
		
	}
} 
