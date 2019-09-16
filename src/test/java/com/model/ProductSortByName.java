package com.model;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductSortByName
{
	
	public WebDriver driver;
	
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\2019 Soft\\\\Automation_Testing\\\\Browsers_Driver\\\\chromedriver_win32\\\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@BeforeTest
	public void openApplicationURL()
	{
		driver.get("http://live.guru99.com/");
		System.out.println("url entered succesfuly");
	}
	@BeforeClass
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getAllCookies()
	{
		Set<Cookie> cookies=driver.manage().getCookies();
		for(Cookie Ck:cookies)
		{
			System.out.println("Cookie name is: "+Ck.getName());
		}
	}
	@Test(priority=1)
	public void getTitleOfGuru99()
	{
		String title=driver.getTitle();
		System.out.println("Title of guru99 is: "+title);
		
	}
	@Test(priority=2)
	public void clickOnMobile()
	{
		driver.findElement(By.xpath("//a[@href='http://live.guru99.com/index.php/mobile.html']")).click();
	}
	@Test(priority=3)
	public void getTitleOf2Page()
	{
		String title2=driver.getTitle();
		System.out.println("Tile of page is: "+title2);
	}
	@Test(priority=4)
	public void sortByName()
	{
		WebElement key=driver.findElement(By.xpath("//div[@class='wrapper']/descendant::select[1]"));
				key.click();
		key.sendKeys(Keys.DOWN);
		key.sendKeys(Keys.ENTER);
//		List<WebElement> ls=driver.findElements(By.xpath("//div[@class='wrapper']/descendant::select[1]"));
		List<WebElement> ls=driver.findElements(By.xpath("//ul[@class='products-grid products-grid--max-4-col first last odd']"));
		int count=ls.size();
		for(int i=0;i<count;i++)
		{
			WebElement list=ls.get(i);
			String str=list.getText();
			System.out.println("list of product is: "+str);
		}
	}
	
	
}