package com.hrmproject.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.hrmproject.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
    public static WebDriver driver;
    public static Logger logger;
    
    public String baseURL = readConfig.getApplicationURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    
    @Parameters("browser")
    @BeforeClass
    public void setUp(String br) {
    	logger = LogManager.getLogger(TC_LoginTest_001.class);
    	logger = LogManager.getLogger(TC_LoginTest_002.class);
    	logger = LogManager.getLogger(TC_SidebarTest_001.class);
    	logger = LogManager.getLogger(TC_AddEmpTest_001.class);
    	
    	if(br.equals("chrome")) {
    		
    		//ChromeOptions options = new ChromeOptions();
            //options.addArguments("--incognito");

    		driver = new ChromeDriver();
    	}
    	else if(br.equals("firefox")) {
    		driver = new FirefoxDriver();
    	}

    	driver.get(baseURL);
    	
    	driver.manage().window().maximize();
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    
    @AfterClass
    public void tearDown() {
    	driver.quit();
    }
    
    public void captureScreen(WebDriver driver, String tname) throws IOException{
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	File target = new File(System.getProperty("user.dir")+ "\\Screenshots\\" + tname + ".png");
    	FileUtils.copyFile(source, target);
    	System.out.println("Screenshot Taken");
    }
    
    public String randomString() {
		String generatedString = RandomStringUtils.randomAlphanumeric(6, 8);
		return generatedString;
	}
    
    public String randomNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return generatedString2;
	}
}