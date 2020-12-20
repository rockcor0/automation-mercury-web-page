/**
 * 
 */
package com.rockcor.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author Rockcor
 *
 */
public class RegisterTest {
	
	public final static String URL = "http://demo.guru99.com/test/newtours/";
	private final static By REGISTER_LINK_LOC = By.linkText("REGISTER");
	private final static By REGISTER_XPATH_LOC = By.xpath("//a[@data-target='#modalUserLogin']");
	private final static By REGISTER_CLOSE_ADD = By.xpath("//div[@id='closeBtn']");
	private final static By REGISTER_PAGE_LOC = By.xpath("//img[@src='images/mast_register.gif']");
	private final static By REGISTER_EMAIL_LOC = By.id("email");
	private final static By REGISTER_PASSWORD_LOC = By.name("password");
	//private final static By REGISTER_CONF_PASSWORD_LOC = By.name("confirmPassword");
	private final static By REGISTER_CONF_PASSWORD_LOC = By.cssSelector("input[name='confirmPassword']");
	private final static By REGISTER_SUBMIT = By.name("submit");
	
	private final static By HOME_LOC = By.linkText("Home");
	private final static By LOGIN_USER_LOC = By.name("userName");
	private final static By LOGIN_PASS_LOC = By.name("password");
	private final static By LOGIN_BTN = By.name("submit");
	
	private final static String USERNAME = "qualityAdmin123!=";
	private final static String PASSWORD = "qualityAdmin123!=";
	
	
	private WebDriver driver;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void loginUser() throws InterruptedException {
		
		driver.findElement(HOME_LOC).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(LOGIN_USER_LOC).sendKeys(USERNAME);
		driver.findElement(LOGIN_PASS_LOC).sendKeys(PASSWORD);
		driver.findElement(LOGIN_BTN).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		String result = "Thank you for Loggin.";
		
		for(WebElement item : fonts) {
			System.out.println(fonts.indexOf(item) + " - " + item.getText());
		}
		
		System.out.println(fonts.get(3).getText());
		
		Thread.sleep(10000);
		
		assertEquals(result,fonts.get(3).getText());
	
	}
	
	@Test
	public void registerUser() throws InterruptedException {
		//Escenario 1: Registrar un usuario
		//Paso 1: Clic en Register
		driver.findElement(REGISTER_LINK_LOC).click();
		Thread.sleep(2000);
		
		if( driver.findElement(REGISTER_PAGE_LOC).isDisplayed() ) {
			
			driver.findElement(REGISTER_EMAIL_LOC).sendKeys(USERNAME);
			driver.findElement(REGISTER_PASSWORD_LOC).sendKeys(PASSWORD);
			driver.findElement(REGISTER_CONF_PASSWORD_LOC).sendKeys(PASSWORD);
			driver.findElement(REGISTER_SUBMIT).click();
			
			List<WebElement> fonts = driver.findElements(By.tagName("font"));
			
			String resultS = "Note: Your user name is " + USERNAME + ".";
			
			for (WebElement webElement : fonts) {
				System.out.println(fonts.indexOf(webElement) + " - " + webElement.getText());
			}
			
			System.out.println(fonts.get(5).getText());
			
			assertEquals(resultS, fonts.get(5).getText());
			
		} else {
			System.out.print("Register page was not found");
		}
		
		//Explicit wait
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		ewait.until(ExpectedConditions.titleContains("Register: Mercury Tours"));
		
	}

}
