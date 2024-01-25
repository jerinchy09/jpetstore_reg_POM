package utilities;

import org.testng.annotations.DataProvider;

public class dataProvider {
	@DataProvider(name="accountInfo")
	public static Object[][] dataprov(){
		return new Object[][] {
			new Object[] {"jjon","tas","ji@gmail.com","123","NC,Usa","","CLT","NC","123","USA"}
		};
	}
	

}
