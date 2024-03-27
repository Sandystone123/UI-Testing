package uiTesting;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class EdgeUiTesting {
	public static WebDriver driver;
	@Test
	public void edge() throws IOException {
		System.out.println("Enter the URL ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		  String link=sc.next();
		  System.out.println("Enter the width for dimension");
	  	int w=sc.nextInt();
	  	System.out.println("Enter the height for dimension");
	  	int h=sc.nextInt(); 
	  	driver =new EdgeDriver();
	  	Dimension dimension = new Dimension(w, h);
	      driver.manage().window().setSize(dimension);
	      Reporter.log("User entered dimension is - "+w+"*"+h,true);
		  driver.get(link);
			/*
			 * Reporter.log("User choosen Chrome browser ",true);
			 * Reporter.log("User provided link is opened in Chrome browser ",true);
			 */
		 String Title = driver.getTitle();
		 Reporter.log("Title of the link" +" "+Title,true);
		 TakesScreenshot t= (TakesScreenshot)driver;
		 File src = t.getScreenshotAs(OutputType.FILE);
		 File des = new File("./Screenshot/Edge/urlgiven.png");
		 FileUtils.copyFile(src, des);
		 driver.close(); 
		
	}
	}

