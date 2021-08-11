package com.pages;

import org.base.LibGlobal;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends LibGlobal {

	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement sltLocation;

	@FindBy(id = "hotels")
	private WebElement sltHotels;

	@FindBy(id = "room_type")
	private WebElement sltRoomType;

	@FindBy(id = "room_nos")
	private WebElement sltRoomNo;

	@FindBy(id = "adult_room")
	private WebElement sltAdults;

	@FindBy(id = "child_room")
	private WebElement sltChild;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement btnSearch;

	@FindBy(id = "datepick_in")
	private WebElement txtCheckIn;
	@FindBy(id = "datepick_out")
	private WebElement txtCheckOut;

	@FindBy(id = "location_span")
	private WebElement txtErrorLocation;

	@FindBy(id = "checkin_span")
	private WebElement txtErrorCheckIn;

	@FindBy(id = "checkout_span")
	private WebElement txtErrorCheckOut;

	public WebElement getTxtErrorCheckIn() {
		return txtErrorCheckIn;
	}

	public WebElement getTxtErrorCheckOut() {
		return txtErrorCheckOut;
	}

	public WebElement getTxtErrorLocation() {
		return txtErrorLocation;
	}

	public WebElement getTxtCheckIn() {
		return txtCheckIn;
	}

	public WebElement getTxtCheckOut() {
		return txtCheckOut;
	}

	public WebElement getSltLocation() {
		return sltLocation;
	}

	public WebElement getSltHotels() {
		return sltHotels;
	}

	public WebElement getSltRoomType() {
		return sltRoomType;
	}

	public WebElement getSltRoomNo() {
		return sltRoomNo;
	}

	public WebElement getSltAdults() {
		return sltAdults;
	}

	public WebElement getSltChild() {
		return sltChild;
	}

	public WebElement getBtnClick() {
		return btnSearch;
	}

	public void search(String location, String hotels, String roomtype, String roomNo, String adult, String child) {

		selectByVisibleText(sltHotels, hotels);
		selectByVisibleText(sltRoomType, roomtype);
		selectByVisibleText(sltChild, child);
		searchwithMandatory(location, roomNo, adult);
	}

	public void searchwithMandatory(String location, String roomNo, String adult) {
		selectByVisibleText(sltLocation, location);
		selectByVisibleText(sltRoomNo, roomNo);
		selectByVisibleText(sltAdults, adult);
		clickSearch();

	}

	public void clickSearch() {
		click(btnSearch);

	}

	public void searchHotelWithDate(String location, String hotels, String roomtype, String roomNo, String checkin,
			String checkOut, String adult, String child) {
		clearTextBox(txtCheckIn);
		clearTextBox(txtCheckOut);
		type(txtCheckIn, checkin);
		type(txtCheckOut, checkOut);
		search(location, hotels, roomtype, roomNo, adult, child);

	}

	public void verifyErrorCheckIn(String expectedResult) {
		String actualResult = getText(getTxtErrorCheckIn());
		Assert.assertEquals("Verify checkin error", expectedResult, actualResult);
	}

	public void verifyErrorCheckOut(String expectedResult) {
		String actualResult = getText(getTxtErrorCheckOut());
		Assert.assertEquals("Verify checkout error", expectedResult, actualResult);
	}

	public void verifyLocationError(String expectedResult) {
		String actualResult = getText(getTxtErrorLocation());
		Assert.assertEquals("Verify location error", expectedResult, actualResult);
	}

}
