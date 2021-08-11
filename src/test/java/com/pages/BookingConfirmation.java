package com.pages;

import org.base.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmation extends LibGlobal {
	
	public BookingConfirmation() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "my_itinerary")
	private WebElement btnClick;

	@FindBy(id = "order_no")
	private WebElement orderId;

	public WebElement getOrderId() {
		return orderId;
	}

	public WebElement getBtnClick() {
		return btnClick;
	}

	public void itinerary() {
		click(btnClick);

	}

	public String getOrderNo() {
		String name = getAttributeByName(getOrderId(), "value");
		return name;
	}

}
