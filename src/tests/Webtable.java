package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Webtable {
	WebDriver drive;
	@BeforeTest
	 public void setup() {
		  System.setProperty("webdriver.chrome.driver","C:\\SeleniumJars\\chromedriver.exe");
			
	      drive=new ChromeDriver();
	      drive.get("file:///C:/Users/DeepCharmi/Downloads/TechnicalAssignment%20(3)%20(2)/TechnicalAssignment/WebTable_v1.0.html");
	      drive.manage().window().maximize();
	  }
	  @Test
	  public void validate_Country() {
		  
		  int rowc=drive.findElements(By.xpath("//table//tr")).size();
		  for(int i=2;i<=rowc;i++)
		  {
			  
				 String company=drive.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				  if(company.equals("Magazzini Alimentari Riuniti"))
				  {
					  
					 System.out.println(company);
					  boolean flag=false;
					  String  country= drive.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
					  if(country.equals("Italy"))
					  {
						  flag=true;
					  System.out.println("the Country of Company Magazzini Alimentari Riunit is Italy");
					  break;
					  }
					  else
					  {
						  flag=false;
						 System.out.println("the Country of Company Magazzini Alimentari Riunit is not Italy");
						 
					  }
					  Assert.assertTrue(flag);
			  }
		  }
		  
	  }
	  @AfterTest
	  public void close() {
		  drive.quit();
	  }

}
