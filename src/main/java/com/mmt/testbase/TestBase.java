package com.mmt.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {
	
	public static WebDriver driver;
	public static Actions act;
	public static JavascriptExecutor js;
	public static FileInputStream fin;
	public static Properties prop;
	
	//Excel
	public static String excelFilePath;
	public static String sheetName;
	
	//Flights
	public static String flights;
	public static String fOneWay;
	public static String fRoundTrip;
	public static String fMultiCity;
	public static String fFromCity;
	public static String fFromCityInput;
	public static String fToCity;
	public static String fToCityInput;
	public static String fDeparture;
	public static String fDepartureDate;
	public static String fReturn;
	public static String fReturnDate;
	public static String fTraverClass;
	public static String fAdults12plus;
	public static String fApplyBtn;
	public static String fRegular;
	public static String fStudent;
	public static String fSearch;
	public static String fOkGotItBtn;
	
	//Buses
	public static String buses;
	public static String bFrom;
	public static String bFromInput;
	public static String bTo;
	public static String bToInput;
	public static String bTravelDate;
	public static String bDate;
	public static String bSearch;
	
	
    @Parameters({"browser","url"})
    @BeforeClass
    public void setUp(String browser, String url) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "D:\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver",
                    "D:\\Drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        act = new Actions(driver);
        try {
			fin = new FileInputStream("D:\\Automation_Projects\\mmt\\Config\\Locators.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        prop = new Properties();
        try {
			prop.load(fin);
		} catch (IOException e) {
			e.printStackTrace();
		} 
        //Excel sheet
        excelFilePath = prop.getProperty("ExcelPath");
        sheetName = prop.getProperty("SheetName");
        
        
        //Flights
       flights = prop.getProperty("Flights");
       fOneWay = prop.getProperty("OneWay");
       fRoundTrip = prop.getProperty("RoundTrip");
       fMultiCity = prop.getProperty("MultiCity");
       fFromCity = prop.getProperty("FromCity");
       fFromCityInput = prop.getProperty("FromCityInput");
       fToCity = prop.getProperty("ToCity");
       fToCityInput = prop.getProperty("ToCityInput");
       fDeparture = prop.getProperty("Departure");
       fDepartureDate = prop.getProperty("DepartureDate");
       fReturn = prop.getProperty("Return");
       fReturnDate = prop.getProperty("ReturnDate");
       fTraverClass = prop.getProperty("TravelClass");
       fAdults12plus = prop.getProperty("Adults12plus");
       fApplyBtn = prop.getProperty("ApplyBtn");
       fRegular = prop.getProperty("Regular");
       fStudent = prop.getProperty("Student");
       fSearch = prop.getProperty("Search");
       fOkGotItBtn = prop.getProperty("OkGotIt");
       
       //buses
       buses = prop.getProperty("Buses");
       bFrom = prop.getProperty("BFrom");
       bFromInput = prop.getProperty("BFromInput");
       bTo = prop.getProperty("BTo");
       bToInput = prop.getProperty("BToInput");
       bTravelDate = prop.getProperty("BTravelDate");
       bDate = prop.getProperty("BDate");
       bSearch = prop.getProperty("BSearch");
       
       
       
       driver.get(url);
    }

    
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
