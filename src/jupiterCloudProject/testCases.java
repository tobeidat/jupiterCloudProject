package jupiterCloudProject;

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
		addItemsFunction();

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
		addSeconedRowItems();

	}

	@Test(priority = 5)
	public void removeFirstAndThirdItem() throws InterruptedException {
		removefromTheCart();

	}

	@AfterTest
	public void postTest() {
	}

}
