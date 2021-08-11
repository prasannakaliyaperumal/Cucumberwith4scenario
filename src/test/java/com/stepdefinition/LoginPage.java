package com.stepdefinition;

import org.base.LibGlobal;
import org.openqa.selenium.WebDriver;

import com.pages.Login;
import com.pages.SearchHotel;
import com.pages.SelectHotel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage extends LibGlobal {

	public static WebDriver driver;
	public static LibGlobal global;

	@Given("User is on the adactin page")
	public void user_is_on_the_adactin_page() {

	}

	@When("User should enter the {string} and {string}")
	public void user_should_enter_the_and(String userName, String password) {

		Login login = new Login();
		login.login(userName, password);

	}

	@When("User should search hotel by {string}, {string},{string},{string},{string},{string}")
	public void user_should_search_hotel_by(String location, String hotels, String room, String roomNo, String adult,
			String child) {

		SearchHotel searchHotel = new SearchHotel();
		searchHotel.search(location, hotels, room, roomNo, adult, child);

	}

	@When("User should click search")
	public void userShouldClickSearch() {

		 SearchHotel searchHotel = new SearchHotel();
		 searchHotel.clickSearch();
	}

	@Then("User should verify {string}")
	public void userShouldVerify(String expectedResult) {
		SelectHotel selectHotel = new SelectHotel();
		selectHotel.verifySelectHotel(expectedResult);

	}

	@Then("User should verify loaction error {string}")
	public void userShouldVerifyLoactionError(String expectedResult) {
		SearchHotel searchHotel = new SearchHotel();
		searchHotel.verifyLocationError(expectedResult);
	}

	@When("User should search hotel by with mandatory field{string}, {string},{string}")
	public void userShouldSearchHotelByWithMandatoryField(String location, String roomNo, String adult) {
		SearchHotel searchHotel = new SearchHotel();
		searchHotel.searchwithMandatory(location, roomNo, adult);
	}

	@When("User should search hotel by with date {string}, {string},{string},{string}, {string}, {string}, {string},{string}")
	public void userShouldSearchHotelByWithDate(String location, String hotels, String roomtype, String roomNo,
			String checkin, String checkOut, String adult, String child) {
		SearchHotel searchHotel = new SearchHotel();
		searchHotel.searchHotelWithDate(location, hotels, roomtype, roomNo, checkin, checkOut, adult, child);
	}

	@Then("User should verify checkin error {string}")
	public void userShouldVerifyCheckinError(String expectedResult) {
		SearchHotel searchHotel = new SearchHotel();
		searchHotel.verifyErrorCheckIn(expectedResult);

	}

	@Then("User should verify checkout error {string}")
	public void userShouldVerifyCheckoutError(String expectedResult) {
		SearchHotel searchHotel = new SearchHotel();
		searchHotel.verifyErrorCheckOut(expectedResult);

	}

	@Then("User should close the browser")
	public void userShouldCloseTheBrowser() {
	

	}

}
