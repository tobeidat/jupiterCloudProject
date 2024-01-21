package jupiterCloudProject;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCases extends parameters {

	@BeforeTest
	public void setup() {
		theBeginning();

	}

	@Test(priority = 1)
	public void addAllItems() throws InterruptedException {
		addItemsFunction(driver.findElements(By.className("btn-success")));

	}

	@Test(priority = 2)
	public void checkoutProcess() throws InterruptedException {
		theCheckout();
	}

	@Test(priority = 3)
	public void addTheHighestPriceProduct() throws InterruptedException {

		addItemWithHighestPrice();
	}

	@Test(priority = 4)
	public void addItemsInTheSecondRow() {
		addRowItems(driver.findElements(By.className("btn-success")));

	}

	@Test(priority = 5)
	public void removeFirstAndThirdItem() throws InterruptedException {
		removefromTheCart();

	}

	@AfterTest
	public void postTest() {
	}

}
