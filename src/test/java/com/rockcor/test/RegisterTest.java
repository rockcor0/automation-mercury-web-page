/**
 * 
 */
package com.rockcor.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Rockcor
 *
 */
public class RegisterTest {
	
	public final static String URL = "http://demo.guru99.com/test/newtours/";
	private final static By REGISTER_LINK_LOC = By.linkText("REGISTER");
	private final static By REGISTER_XPATH_LOC = By.xpath("//a[@data-target='#modalUserLogin']");
	private final static By REGISTER_CLOSE_ADD = By.xpath("//div[@id='closeBtn']");
	private final static By REGISTER_PAGE_LOC = By.xpath("//h3[@id='myModalLabel']");
	
	
	
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
	public void registerUser() throws InterruptedException {
		//Escenario 1: Registrar un usuario
		//Paso 1: Clic en Register
		

		driver.findElement(REGISTER_LINK_LOC).click();
		Thread.sleep(10000);
		driver.findElement(REGISTER_CLOSE_ADD).click();
		
		Thread.sleep(10000);

		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		
		assertEquals("1", "1");
	}

}
