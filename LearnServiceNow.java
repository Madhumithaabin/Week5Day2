package Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LearnServiceNow extends LearnBaseClassService {

	@Test(dataProvider = "fetchdata")
	public void Servicecreate(String description) throws InterruptedException, IOException, InvalidFormatException {
		// TODO Auto-generated method stub
		String[][] value = null;

		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		WebElement frame2 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		driver.switchTo().defaultContent();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> searc = new ArrayList<String>(windowHandles);
		driver.switchTo().window(searc.get(1));
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		driver.switchTo().window(searc.get(0));
		WebElement frame3 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys(description);
		String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNum);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();
		WebElement frame4 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame4);

		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNum, Keys.ENTER);
		String incNum = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();

		int i = 1;
		if (incidentNum.equals(incNum)) {
			System.out.println("incident is created successful " + i);
			i++;
		} else
			System.out.println("incident is not created");
		driver.switchTo().defaultContent();
//return incidentNum;
	}

	@DataProvider(name = "fetchdata")
	public String[][] Senddata() throws IOException {
		return ReadExcel.readData("createincident");
	}

}
