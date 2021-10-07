package Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class LearnServicenowDelete extends LearnBaseClassService {

	@Test(priority = 2)
	public String Servicedelete() throws InterruptedException, IOException, InvalidFormatException {
		// TODO Auto-generated method stub

		driver.findElement(By.linkText("Open")).click();
		WebElement frame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame);

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNum);

		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNum, Keys.ENTER);

		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();

		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Open")).click();

		WebElement frame4 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame4);

		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNum, Keys.ENTER);
		String deleteConfirm = driver.findElement(By.xpath("//tr[@class='list2_no_records']/td")).getText();
		if (deleteConfirm.equals("No records to display"))
			System.out.println("incident is Deleted successful");
		else
			System.out.println("incident is not deleted");
		return incidentNum;
	}

	@Test(priority = 1)
	public void Senddata() throws IOException, InvalidFormatException, InterruptedException {
		String servicedelete = Servicedelete();
		IncidentList.createexport(servicedelete, "Deletedincident");

	}
}
