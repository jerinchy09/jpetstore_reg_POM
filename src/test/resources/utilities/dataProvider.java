package utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class dataProvider {
	@DataProvider(name="accountInfo")
	public static Object[][] dataprov(){
		return new Object[][] {
			new Object[] {"jkjff","tas","kkj@gmail.com","123","NC,Usa","","CLT","NC","123","USA"}
		};
	}
	@DataProvider(name="Invalid_accountInfo")
	public static Object[][] invalid_dataprov(){
		return new Object[][] {
			new Object[] {"gff","tas","","123","NC,Usa","","CLT","NC","123","USA"}
		};
	}
	

}
