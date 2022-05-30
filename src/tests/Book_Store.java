package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Book_Store {
	WebDriver drive;
	@BeforeTest
	  public void setup() {
		  
		  System.setProperty("webdriver.chrome.driver","C:\\SeleniumJars\\chromedriver.exe");
			
	      drive=new ChromeDriver();
	      drive.get("file:///C:/Users/DeepCharmi/Downloads/TechnicalAssignment%20(3)%20(2)/TechnicalAssignment/XPath_Nodes_v1.0.html");
	      drive.manage().window().maximize();
	  }
	  @Test(priority=0)
	  public void display_title() {
		 System.out.println("the page is displayed with 3 book titles:");
		 List<WebElement> title=drive.findElements(By.xpath("//book/booktitle"));
		 int title_size=title.size();
		 System.out.println("There are three title :"+title_size);
		 
		 for(WebElement a:title)
		 {
			 System.out.println(a.getText());
		 }
		 Assert.assertEquals(title_size,3,"There are three title");
		 
		 System.out.println("*******************************");
	  }
	  @Test(priority=1)
	  public void display_title3()
	  {
		
		  System.out.println("The book title is “Harry Potter is sawing all record");
		  List<WebElement> title=drive.findElements(By.xpath("//book/booktitle"));
		  for(int i=0;i<title.size();i++)
		  {
			  String bookt=title.get(i).getText();
			  
			 if(bookt.equals("Title: Harry Potter"))
			  {
				 
				 boolean flag=drive.findElement(By.xpath("//bookstore/book[@category='children']")).isDisplayed();
				 Assert.assertTrue(flag);
				 String author=drive.findElement(By.xpath("//bookstore/book[@category='children']/author")).getText();
				 System.out.println("Author Name:"+author);
				 Assert.assertEquals(author,"- author: J K. Rowling");
				 String year=drive.findElement(By.xpath("//bookstore/book[@category='children']/year")).getText();
				 System.out.println("Year :"+year);
				 Assert.assertEquals(year, "- year: 2005");
				 String price=drive.findElement(By.xpath("//bookstore/book[@category='children']/price")).getText();
				System.out.println("price :"+price);
				Assert.assertEquals(price,"- price: 29.99");
				System.out.println("********************************");
				
			  }
			 
		  }
	  }
	  @AfterTest
	  public void close() 
	  {
		  drive.quit();
	  }



}
