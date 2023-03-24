package ValidateScenario;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import JawwyCountryList.JawwyCountryList;
import io.github.bonigarcia.wdm.WebDriverManager;
import JawwyHomePage.JawwyHomePage;

public class ValidationScenarios {

	WebDriver browser;
	ChromeOptions chromeOptions;
	JawwyHomePage homepage;	
	JawwyCountryList country;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		browser = new ChromeDriver(chromeOptions);
		homepage = new JawwyHomePage(browser);
		homepage.navigate();
		country = new JawwyCountryList(homepage.getCurrentCountry());
	}
	

	@Test
	public void validate_Package_Types() {
		List<String> readTitles = homepage.getPackageTitles();
		if (homepage.getCurrentLanguage().equalsIgnoreCase("English")) {
			for (int i = 0; i < readTitles.size(); i++) {
				assertEquals(readTitles.get(i), country.getPackageTitlesAR().get(i));
			}
		} else {
			for (int i = 0; i < readTitles.size(); i++) {
				assertEquals(readTitles.get(i), country.getPackageTitlesEN().get(i));
			}
		}
	}

	@Test
	public void validate_Number_Of_Packages() {
		List<String> readTitles = homepage.getPackageTitles();
		assertEquals(readTitles.size(), 3);
	}

	@Test
	public void validate_Currency() {
		List<String> readCurrency = homepage.getPackagePriceCurr();
		if (homepage.getCurrentLanguage().equalsIgnoreCase("English")) {
			for (int i = 0; i < readCurrency.size(); i++) {
				assertEquals(readCurrency.get(i), country.getCurrencyTitleAR());
			}
		} else {
			for (int i = 0; i < readCurrency.size(); i++) {
				assertEquals(readCurrency.get(i), country.getCurrencyTitleEng());
			}
		}
	}

	@Test
	public void validate_Package_Prices() {
		List<String> readPrices = homepage.getPackagePriceVal();
		for (int i = 0; i < readPrices.size(); i++) {
			assertEquals(readPrices.get(i), country.getPackagePrices().get(i));
		}
	}

	@AfterClass
	public void afterClass() {
		browser.quit();
	}

}
