package refreshTestNew;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SwagLapTest extends Information {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void MyBeforeTest() {

		driver.get(myUrl);
		WebElement UserNameElemnt = driver.findElement(By.id("user-name"));
		WebElement PasswordElemnt = driver.findElement(By.id("password"));
		UserNameElemnt.sendKeys(UserNamesauce);
		PasswordElemnt.sendKeys(PassWord);
		driver.findElement(By.id("login-button")).click();
		driver.manage().window().maximize();
	}

	@Test
	public void FirstTest() {
		List<WebElement> AddedItems = driver.findElements(By.className("btn"));
		List<WebElement> itemName = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> ItemsPrice = driver.findElements(By.className("inventory_item_price"));

		for (int i = 0; i < AddedItems.size(); i++) {
			if (itemName.get(i).getText().contains("Test.allTheThings") || itemName.get(i).getText().contains("Onesie")
					|| itemName.get(i).getText().contains("Labs Bike Light")) {
				continue;
			} else {
				AddedItems.get(i).click();
				ItemsPrice.get(i).getText();
				System.out.println(ItemsPrice.get(i).getText());
				String PriceEND = ItemsPrice.get(i).getText().replace("$", " ");
				double PriceAsDouble = Double.parseDouble(PriceEND);
	double TaxValue = 0.10;
	double finelPrice = PriceAsDouble * TaxValue + PriceAsDouble;
	if ((int)finelPrice % 2 == 0) {
	System.out.println("the final price is even number and the value of this number " + finelPrice);
	} else {
	System.out.println("the final price is an odd number and the value of this price " + finelPrice);
}
}

}
}

	@AfterTest
	public void MyAfterTest() {

	}

}