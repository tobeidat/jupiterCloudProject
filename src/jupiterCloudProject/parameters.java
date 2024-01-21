package jupiterCloudProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class parameters {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();

	public void theBeginning() {
		driver.get("https://jupiter.cloud.planittesting.com/#/shop");
		driver.manage().window().maximize();
	}

	public void addItemsFunction(List<WebElement> allItemsList) throws InterruptedException {
		List<WebElement> allItems = allItemsList;
		for (int i = 0; i < allItems.size(); i++) {
			allItems.get(i).click();

		}
		Thread.sleep(2000);
	}

	public void theCheckout() throws InterruptedException {
		WebElement cartElement = driver.findElement(By.id("nav-cart"));
		cartElement.click();
		Thread.sleep(2000);
		WebElement checkoutButton = driver.findElement(By.className("btn-checkout"));
		checkoutButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		WebElement forenameElement = driver.findElement(By.id("forename"));
		forenameElement.sendKeys("ahamad");
		WebElement surnameElement = driver.findElement(By.id("surname"));
		surnameElement.sendKeys("jaradat");
		WebElement userEmail = driver.findElement(By.id("email"));
		userEmail.sendKeys("ahmadjarada888@gmail.com");
		WebElement userTelephone = driver.findElement(By.id("telephone"));
		userTelephone.sendKeys("0799996543");
		WebElement userAddress = driver.findElement(By.id("address"));
		userAddress.sendKeys("irbid");
		WebElement userCardType = driver.findElement(By.id("cardType"));
		Select select = new Select(userCardType);
		select.selectByValue("Visa");
		WebElement userCardNumber = driver.findElement(By.id("card"));
		userCardNumber.sendKeys("1234567843218765");
		WebElement submitButton = driver.findElement(By.id("checkout-submit-btn"));
		submitButton.click();
		Thread.sleep(10000);
		WebElement actualMsg = driver.findElement(By.className("alert-success"));
		softassert.assertEquals(actualMsg.getText().contains("your order has been accepted"), true);

	}

	public void addItemWithHighestPrice() throws InterruptedException {
		WebElement shoppingPageButton = driver.findElement(By.className("btn-success"));
		shoppingPageButton.click();
		Thread.sleep(2000);
		List<WebElement> allItemPrices = driver.findElements(By.className("product-price"));

		String ItemPrices = allItemPrices.get(0).getText().replace("$", "");
		Double theItemWithHigestPrice = Double.parseDouble(ItemPrices);
		int index = 0;
		for (int i = 1; i < allItemPrices.size(); i++) {
			String ItemPriceElement = allItemPrices.get(i).getText().replace("$", "");
			Double price = Double.parseDouble(ItemPriceElement);

			if (price > theItemWithHigestPrice) {

				theItemWithHigestPrice = price;
				index = i;

			}

		}
		List<WebElement> allItems = driver.findElements(By.className("btn-success"));
		allItems.get(index).click();

	}

	public void addRowItems(List<WebElement> allProductPrices) {
		List<WebElement> products = allProductPrices;
		for (int i = 5; i < products.size(); i++) {
			products.get(i).click();
		}

	}

	public void removefromTheCart() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		WebElement theCart = driver.findElement(By.id("nav-cart"));
		theCart.click();
		Thread.sleep(2000);
		List<WebElement> removeFromCartButtElements = driver.findElements(By.className("remove-item"));
		for (int i = 0; i < removeFromCartButtElements.size() - 1; i += 2) {
			removeFromCartButtElements.get(i).click();
			WebElement modalfooterElement = driver.findElement(By.className("modal-footer"));
			WebElement ConfirmDeletion = modalfooterElement.findElement(By.className("btn-success"));
			ConfirmDeletion.click();
		}

	}

}
