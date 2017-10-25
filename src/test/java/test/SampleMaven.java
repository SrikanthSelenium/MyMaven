package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleMaven {
	
	public static WebDriver d;
	
	@Test
	public void test() throws InvalidFormatException, IOException
	{
		d=new FirefoxDriver();
		File file = new File("E:\\EclipseNeon\\maven-test-artifact\\src\\test\\java\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("Sheet1");
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		System.out.println(rows+" "+cols);
		
		System.out.println("TestNG run success");
		
		d.get("https://www.google.com");
		List<WebElement> links = d.findElements(By.tagName("a"));
		System.out.println(links.size());		
		for(int i=0;i<links.size();i++)
		{
			if(links.get(i).isDisplayed() && links.get(i).isEnabled()){
			links.get(i).click();
			System.out.println(d.getTitle());
			d.get("https://www.google.com");
			links=d.findElements(By.tagName("a"));
			}
		}
		
		d.quit();
		
		
		
		
	}

}
