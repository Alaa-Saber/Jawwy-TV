package JawwyHomePage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JawwyHomePage {

	WebDriver browser;
	String WebsiteURL = "https://subscribe.stctv.com/";

	// Elements
	By Language_Btn = By.id("translation-btn");
	By Country_Btn = By.id("country-btn");
	By CurrentCountry = By.id("country-name");
	By CountryList = By.xpath("//*[@class='country ']//span[2]");
	By Package_Titles = By.xpath("//*[@class='plan-title']"); // get 3 packages titles
	By Price_currency = By.xpath("//*[@class='price']/i"); // get 3 packages currencies
	By Price_values = By.xpath("//*[@class='price']/b"); // get 3 packages price values

	// constructor
	public JawwyHomePage() {
	}

	public JawwyHomePage(WebDriver browser) {
		this.browser = browser;
	}

	// actions
	public void navigate() {
		browser.manage().window().maximize();
		browser.navigate().to(WebsiteURL);
//		changeLang("English");
	}

	public String getCurrentLanguage() {
		return browser.findElement(Language_Btn).getText();
	}

	public void changeLang(String neededLang) {
		if (getCurrentLanguage() != neededLang) {
			browser.findElement(Language_Btn).click();
		}
	}

	public String getCurrentCountry() {
		return browser.findElement(CurrentCountry).getText();
	}

	public void changeCountry(String neededCountry) {
		if (getCurrentCountry() != neededCountry) {
			browser.findElement(Country_Btn).click();
			List<WebElement> CountriesList = browser.findElements(CountryList);
			for (WebElement country : CountriesList) {
				if (country.getText().equalsIgnoreCase(neededCountry)) {
					country.click();
				} else {
					continue;
				}
			}
		}
	}

	public List<String> getPackageTitles() {
		List<String> titles = new ArrayList<String>();
		List<WebElement> packagesTitles = browser.findElements(Package_Titles);
		for (WebElement title : packagesTitles) {
			titles.add(title.getText());
		}
		return titles;
	}

	public List<String> getPackagePriceCurr() {
		List<String> Currency = new ArrayList<String>();
		List<WebElement> packagesPriceCur = browser.findElements(Price_currency);
		for (WebElement curr : packagesPriceCur) {
			String str = curr.getText();
			int sepPos = str.indexOf("/");
			if (sepPos == -1) {
				Currency.add("");
			}
			Currency.add(str.substring(0, sepPos));
		}
		return Currency;
	}

	public List<String> getPackagePriceVal() {
		List<String> PriceVal = new ArrayList<String>();
		List<WebElement> packagesPriceVal = browser.findElements(Price_values);
		for (WebElement val : packagesPriceVal) {
			PriceVal.add(val.getText());
		}
		return PriceVal;
	}

}
