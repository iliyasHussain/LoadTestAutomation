package loadAutomation;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData extends DriverSetup {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static int rows;
	public static Row row;

	public void getData() throws IOException, InvalidFormatException {

		// String str[];

		// text file, should be opening in default text editor
		File file = new File(
				"C:\\Users\\iliyash\\OfficeTools\\LoadTestFramework\\ExcelData\\Marketing Readiness Skills Wk 1.xlsx");
		FileInputStream fis = new FileInputStream(file);

		// first check if Desktop is supported by Platform or not
		if (!Desktop.isDesktopSupported()) {
			System.out.println("Desktop is not supported");
			fis.close();
			return;
		}
		/*
		 * open the file Desktop desktop = Desktop.getDesktop(); if
		 * (file.exists()) desktop.open(file);
		 */

		wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		rows = sh.getLastRowNum();
		System.out.println("number of skills are: " + rows);
		row = sh.getRow(0);
		String cellText = row.getCell(1).getStringCellValue();
		if (cellText.equalsIgnoreCase("skill id")){
			for(int i=1;i<=rows;i++){
				Row r = sh.getRow(i);
				String skill = r.getCell(1).getStringCellValue();
				//CicPage cp = new CicPage(driver);
				//cp.CheckSkill(skill);
				
				WikiPage wp = new WikiPage(driver);
				wp.FindSkill(skill);
			}
		}
	}
		
		/*int lastColumn = row.getLastCellNum();
		System.out.println(lastColumn);
		for (int i = 0; i < lastColumn; i++) {
			if (row.getCell(i).getStringCellValue().equalsIgnoreCase("Invocation ID")) {
				System.out.println(row.getCell(i).getStringCellValue());
				for (int j = 0; j <= rows; j++) {
					row = sh.getRow(j);
					// Cell cell = row.getCell(i);
					// row.removeCell(cell);
					Cell oldCell = row.getCell(i + 1);
					System.out.println(oldCell.getStringCellValue());
					Cell newCell = row.createCell(i);
					cloneCellValue(oldCell, newCell);
					FileOutputStream fos = new FileOutputStream(file);
					wb.write(fos);
					fos.close();
					continue;
				}
			} else if (row.getCell(i).getStringCellValue().equalsIgnoreCase("Golden utterance")) {
				System.out.println(row.getCell(i).getStringCellValue());
				for (int j = 0; j <= rows; j++) {
					row = sh.getRow(j);
					Cell cell = row.getCell(i);
					row.removeCell(cell);
					// Cell oldCell = row.getCell(i + 1);
					System.out.println(cell.getStringCellValue());
					// Cell newCell = row.createCell(i);
					// cloneCellValue(oldCell, newCell);
					FileOutputStream fos = new FileOutputStream(file);
					wb.write(fos);
					fos.close();
					continue;
				}
			} else if (row.getCell(i).getStringCellValue().equalsIgnoreCase("skill stage")) {
				System.out.println(row.getCell(i).getStringCellValue());
				for (int j = 0; j <= rows; j++) {
					row = sh.getRow(j);
					Cell cell = row.getCell(i);
					row.removeCell(cell);
					// Cell oldCell = row.getCell(i + 1);
					System.out.println(cell.getStringCellValue());
					// Cell newCell = row.createCell(i);
					// cloneCellValue(oldCell, newCell);
					FileOutputStream fos = new FileOutputStream(file);
					wb.write(fos);
					fos.close();
					continue;
				}
			} else if (row.getCell(i).getStringCellValue().equalsIgnoreCase("skill stage")) {
				System.out.println(row.getCell(i).getStringCellValue());
				for (int j = 0; j <= rows; j++) {
					row = sh.getRow(j);
					Cell cell = row.getCell(i);
					row.removeCell(cell);
					// Cell oldCell = row.getCell(i + 1);
					System.out.println(cell.getStringCellValue());
					// Cell newCell = row.createCell(i);
					// cloneCellValue(oldCell, newCell);
					FileOutputStream fos = new FileOutputStream(file);
					wb.write(fos);
					fos.close();
					continue;
				}
			} else if (row.getCell(i).getStringCellValue().equalsIgnoreCase("market place")) {
				System.out.println(row.getCell(i).getStringCellValue());
				for (int j = 0; j <= rows; j++) {
					row = sh.getRow(j);
					Cell cell = row.getCell(i);
					row.removeCell(cell);
					// Cell oldCell = row.getCell(i + 1);
					System.out.println(cell.getStringCellValue());
					// Cell newCell = row.createCell(i);
					// cloneCellValue(oldCell, newCell);
					FileOutputStream fos = new FileOutputStream(file);
					wb.write(fos);
					fos.close();
					continue;
				}
			}
		}

		fis.close();
		wb.close();
	}

	void cloneCellValue(Cell oldCell, Cell newCell) {
		newCell.setCellStyle(oldCell.getCellStyle());
		switch (oldCell.getCellTypeEnum()) {
		case STRING:
			newCell.setCellValue(oldCell.getStringCellValue());
			break;
		case NUMERIC:
			newCell.setCellValue(oldCell.getNumericCellValue());
			break;
		case BOOLEAN:
			newCell.setCellValue(oldCell.getBooleanCellValue());
			break;
		case FORMULA:
			newCell.setCellFormula(oldCell.getCellFormula());
			break;
		case ERROR:
			newCell.setCellErrorValue(oldCell.getErrorCellValue());
		case BLANK:
		case _NONE:
			break;
		}
	}

	/*
	 * //let's try to open PDF file file = new File("/Users/pankaj/java.pdf");
	 * if(file.exists()) desktop.open(file);
	 */

	public static void main(String[] args) throws IOException, InvalidFormatException {
		ExcelData ex = new ExcelData();
		ex.getData();
	}

}
