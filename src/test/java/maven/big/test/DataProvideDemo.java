package maven.big.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideDemo {

	
	@Test(dataProvider="datas2")
	public void login(String data1, String data2, int data3, int data4) {

		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data4);
	}
	
	@DataProvider(name="datas")
	public Object[][] setDataforLogin() {
		
		Object data[][]=new Object[1][4];
		
		data[0][0]="Laxman";
		data[0][1]="More";
		data[0][2]=20;
		data[0][3]=30;
		return data;
	}
	
	@DataProvider(name="datas2")
	public Object[][] setDataforLogin2() {
		
		Object [][] data={{"India","Japan",90,85}};
		
		return data;
		
}
}