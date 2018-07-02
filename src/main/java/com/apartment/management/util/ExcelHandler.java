package com.apartment.management.util;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelHandler
{

	public XSSFWorkbook createExcel()
	{
		XSSFWorkbook workbook = new XSSFWorkbook();

		return workbook;
	}

	public boolean readExcel(String path)
	{
		File file = new File(path);
		try
		{
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheetAt(0);
			for ( int i = sheet.getFirstRowNum() + 1; i <= sheet
					.getLastRowNum(); i++ )
			{
				Row row = sheet.getRow(i);
			}

			workbook.close();
			return true;
		} catch (IOException e)
		{
			return false;
		} catch (InvalidFormatException e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
