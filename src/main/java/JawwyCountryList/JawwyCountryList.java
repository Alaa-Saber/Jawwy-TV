package JawwyCountryList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JawwyCountryList {

	static String CurrencyTitleEng = "USD";
	static String CurrencyTitleAR = "دولار أمريكي";
	static List<String> PackageTypesEN = new ArrayList<String>(Arrays.asList("LITE", "CLASSIC", "PREMIUM"));
	static List<String> PackageTypesAR = new ArrayList<String>(Arrays.asList("لايت", "الأساسية", "بريميوم"));
	static String CountryName;
	static List<String> PackagePrices = new ArrayList<String>();

	public JawwyCountryList(String countryName) {

		switch (countryName) {
			case "Egypt":
				CountryName = "Egypt";
				PackagePrices.add("0.25");
				PackagePrices.add("0.5");
				PackagePrices.add("1");
				break;
			case "مصر":
				CountryName = "مصر";
				PackagePrices.add("0.25");
				PackagePrices.add("0.5");
				PackagePrices.add("1");
				break;
			case "UAE":
				CountryName = "UAE";
				PackagePrices.add("5.4");
				PackagePrices.add("10.9");
				PackagePrices.add("16.3");
				break;
			case "الإمارات":
				CountryName = "الإمارات";
				PackagePrices.add("5.4");
				PackagePrices.add("10.9");
				PackagePrices.add("16.3");
				break;
			case "Algeria":
				CountryName = "Algeria";
				PackagePrices.add("2.7");
				PackagePrices.add("5.3");
				PackagePrices.add("8");
				break;
			case "الجزائر":
				CountryName = "الجزائر";
				PackagePrices.add("2.7");
				PackagePrices.add("5.3");
				PackagePrices.add("8");
				break;
			case "Djibouti":
				CountryName = "Djibouti";
				PackagePrices.add("2.4");
				PackagePrices.add("4.8");
				PackagePrices.add("7.2");
				break;
			case "جيبوتي":
				CountryName = "جيبوتي";
				PackagePrices.add("2.4");
				PackagePrices.add("4.8");
				PackagePrices.add("7.2");
				break;
			case "Jordan":
				CountryName = "Jordan";
				PackagePrices.add("2.7");
				PackagePrices.add("5.2");
				PackagePrices.add("8");
				break;
			case "الأردن":
				CountryName = "الأردن";
				PackagePrices.add("2.7");
				PackagePrices.add("5.2");
				PackagePrices.add("8");
				break;
			default:
				CountryName = "";
				break;
		}

	}

	public String getCurrencyTitleEng() {
		return CurrencyTitleEng;
	}

	public String getCurrencyTitleAR() {
		return CurrencyTitleAR;
	}

	public List<String> getPackageTitlesAR() {
		return PackageTypesAR;
	}

	public List<String> getPackageTitlesEN() {
		return PackageTypesEN;
	}

	public List<String> getPackagePrices() {
		return PackagePrices;
	}

}
