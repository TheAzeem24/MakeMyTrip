package com.makemytrip.flights;

import org.testng.annotations.Test;

import com.makemytrip.Utilities.ExcelUtility;
import com.makemytrip.Utilities.MMT_Methods;
import com.makemytrip.testbase.TestBase;

public class Flights extends TestBase{
	
	@Test
	public void filghtTest01() throws Exception
	{
		MMT_Methods.doClick(loginCloseBtn);
		MMT_Methods.expWait(flights, 10);
		MMT_Methods.doClick(fFromCity);
		String fromCity = ExcelUtility.getCellData(excelFilePath, sheetName, 2, 0);
		MMT_Methods.doTypeText(fFromCityInput, fromCity);
		String toCity = ExcelUtility.getCellData(excelFilePath, sheetName, 2, 1);
		MMT_Methods.doClick(fToCity);
		MMT_Methods.doTypeText(fToCityInput, toCity);
		MMT_Methods.doClick(fDeparture);
		MMT_Methods.doClick(fDepartureDate);
		MMT_Methods.doClick(fReturn);
		MMT_Methods.doClick(fReturnDate);
		MMT_Methods.doClick(fTraverClass);
		MMT_Methods.expWait(fAdults12plus, 5);
		MMT_Methods.doClick(fAdults12plus);
		MMT_Methods.doMoveTOElementClick(fApplyBtn);
		MMT_Methods.doMoveTOElementClick(fStudent);
		MMT_Methods.doMoveTOElementClick(fSearch);
		/*
		 * MMT_Methods.expWait(fOkGotItBtn, 5); MMT_Methods.doClick(fOkGotItBtn);
		 */
		
	}
}
