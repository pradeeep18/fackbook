package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	private static TakesScreenshot takesScreenshot;
	private static DateTimeFormatter dtf;
	
	public Utility(WebDriver driver) {
		this.takesScreenshot=(TakesScreenshot)driver;
		dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss");
	}
		
	public static void screenShot(int TestId ) throws IOException {

	LocalDateTime now = LocalDateTime.now();	
	File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
	File test = new File("C:\\Testing\\ScreenShot\\test"+TestId+dtf.format(now)+".PNG");
	FileHandler.copy(src, test);	
	}
	
	public static String getExcelData(String sheetname,int cellno,int row) throws EncryptedDocumentException, IOException {
		Sheet sheet;
		Cell cell;
		String path="C:\\Testing\\mock Question.xlsx";	
		FileInputStream  file= new FileInputStream(path);
		Workbook wbf=WorkbookFactory.create(file);
		cell=wbf.getSheet(sheetname).getRow(row).getCell(cellno);
		try {
			String s=cell.getStringCellValue();
			return s;
		}
		catch(IllegalStateException e)
		{
			double d=cell.getNumericCellValue();
			String s=Double.toString(d);
			return s;
		}
		
	}
	


}
