package com.selenium.setup;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.Supplier;




public class DriverSetup {
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	private static WebDriver driver;
	public static String baseUrl = "";
	private static String filePath="";
	static String workingDir = System.getProperty("user.dir");

	
	private static final Supplier<WebDriver> chromeSupplier = () -> {
		filePath = workingDir+File.separator+"chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);
		
		return new ChromeDriver();
	};
	
	private static final Supplier<WebDriver> IESupplier = () -> {
		filePath = workingDir+File.separator+"IEDriverServer.exe";
//		System.setProperty("webdriver.ie.driver", filePath);
		return new InternetExplorerDriver();
	};
	
	private static final Supplier<WebDriver> fireFoxSupplier = () -> {
		filePath = workingDir+File.separator+"Igeckodriver.exe";
		System.setProperty("webdriver.gecko.drive", filePath);
		return new FirefoxDriver();
	};
	
	private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();
	
	static
	{
		MAP.put("chrome", chromeSupplier);
		MAP.put("ie", IESupplier);
		MAP.put("firefox", fireFoxSupplier);
		baseUrl = ExcelUtils.readProperty(2,1);
		 
	}
	
	public static WebDriver getDriver()
	{
		
		driver = MAP.get(ExcelUtils.readProperty(1,1).toLowerCase()).get();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);

		
		return  driver;
		
	}
	
	
	
	}
	

	

