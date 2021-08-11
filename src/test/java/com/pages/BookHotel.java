package com.pages;

import org.base.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotel extends LibGlobal {
	
	public BookHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement txtFirstname;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCCno;

	@FindBy(id = "cc_type")
	private WebElement sltCardType;

	@FindBy(id = "cc_exp_month")
	private WebElement sltMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement sltYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCvv;

	@FindBy(id = "book_now")
	private WebElement btnBook;

	public WebElement getTxtFirstname() {
		return txtFirstname;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCCno() {
		return txtCCno;
	}

	public WebElement getSltCardType() {
		return sltCardType;
	}

	public WebElement getSltMonth() {
		return sltMonth;
	}

	public WebElement getSltYear() {
		return sltYear;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	public WebElement getBtnBook() {
		return btnBook;
	}

	public void book(String first, String last, String add, String cc, String name, String month, String year,
			String cvv) {
		type(txtFirstname, first);
		type(txtLastName, last);
		type(txtAddress, add);
		type(txtCCno, cc);
		selectByVisibleText(sltCardType, name);
		selectByVisibleText(sltMonth, month);
		selectByVisibleText(sltYear, year);
		type(txtCvv, cvv);
		click(btnBook);

	}


}
