package com.makemytrip.buses;

import org.testng.annotations.Test;
import com.makemytrip.Utilities.ExcelUtility;
import com.makemytrip.Utilities.MMT_Methods;
import com.makemytrip.testbase.TestBase;

public class Buses extends TestBase {
	
	@Test
	public void busTc_01() throws Exception
	{
		MMT_Methods.doClick(loginCloseBtn);
		MMT_Methods.expWait(buses, 5);
		MMT_Methods.doClick(buses);
		MMT_Methods.expWait(bFrom, 5);
		MMT_Methods.doClick(bFrom);
		String fromCity = ExcelUtility.getCellData(excelFilePath, sheetName, 2, 0);
		MMT_Methods.doTypeText(bFromInput, fromCity);
		String toCity = ExcelUtility.getCellData(excelFilePath, sheetName, 2, 1);
		MMT_Methods.doClick(bTo);
		MMT_Methods.doTypeText(bToInput, toCity);
		MMT_Methods.doClick(bTravelDate);
		MMT_Methods.doClick(bDate);
		//MMT_Methods.doMoveTOElementClick(bDate);
		MMT_Methods.doClick(bSearch);
	}

}
