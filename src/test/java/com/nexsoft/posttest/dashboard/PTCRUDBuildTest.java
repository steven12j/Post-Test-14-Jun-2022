package com.nexsoft.posttest.dashboard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PTCRUDBuildTest {

	WebDriver driver;
	
	public int nomorFoto() {
		
		int angka = (int) (Math.random() * 10) - 5;
		angka = Math.abs(angka);
		
		return angka;
	}
	
	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	@Test (priority = 0)
	public void login() {
		driver.findElement(By.cssSelector(".fa.fa-sign-in")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector("Input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("Input[placeholder='Email']")).sendKeys("steven12jaya@gmail.com");
		
		driver.findElement(By.cssSelector("Input[placeholder='Password']")).clear();
		driver.findElement(By.cssSelector("Input[placeholder='Password']")).sendKeys("testcicool");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/aside[1]/div[1]/section[1]/ul[1]/li[3]/a[1]/i[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[3]/td[5]/a[1]/i[1]")).click();
	}
	
	@Test (priority = 1, dataProvider = "getPostTestData", dataProviderClass = com.nexsoft.posttest.dataprovider.DataProvider14JunPostTest.class)
	public void crudBuild1(String param1, String param2, String param3, String param4) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector("Input[placeholder='First Name']")).clear();
		driver.findElement(By.cssSelector("Input[placeholder='First Name']")).sendKeys(param1);
		
		driver.findElement(By.cssSelector("Input[placeholder='Last Name']")).clear();
		driver.findElement(By.cssSelector("Input[placeholder='Last Name']")).sendKeys(param2);
		
		driver.findElement(By.cssSelector("Input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("Input[placeholder='Email']")).sendKeys(param3);
		
		driver.findElement(By.cssSelector("Input[placeholder='Gender']")).clear();
		driver.findElement(By.cssSelector("Input[placeholder='Gender']")).sendKeys(param4);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String fotoPostTest = "D:\\Foto14JunPostTest\\Foto_" + nomorFoto() + ".jpg";
		
		driver.findElement(By.cssSelector("input[title='file input']")).sendKeys(fotoPostTest);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector(".ion.ion-ios-list-outline")).click();
		
	}
}
