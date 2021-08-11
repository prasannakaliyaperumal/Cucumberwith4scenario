package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {

	public static WebDriver driver;
	Actions actions;
	Robot robot;
	Alert alert;
	JavascriptExecutor js;

	public WebDriver getdriver(String browserName) {
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public void loadUrl(String url) {
		driver.get(url);

	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	public String getTitle() {

		return driver.getTitle();

	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void type(WebElement element, String data) {

		if (display(element) && enable(element)) {
			highlightWebElement(element, "green");
			element.sendKeys(data);
		}

	}

	public void clearTextBox(WebElement e) {
		e.clear();
	}

	public void click(WebElement element) {
		highlightWebElement(element, "blue");
		element.click();
	}

	public void closeAllWindlows() {
		driver.quit();
	}

	public void closeWindow() {
		driver.close();
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		new Actions(driver).dragAndDrop(source, target).perform();
	}

	public String getText(WebElement element) {
		return element.getText();

	}

	public String getAttributeByValue(WebElement element) {
		return element.getAttribute("value");

	}

	public String getAttributeByName(WebElement element, String name) {
		return element.getAttribute(name);
	}

	public Navigation navigation() {
		return driver.navigate();
	}

	public void navigateTo(String url) {

		navigation().to(url);

	}

	public void navigateRefresh() {
		navigation().refresh();

	}

	public void navigateBack() {
		navigation().back();
	}

	public void navigateForward() {
		navigation().forward();

	}

	public void mouseOver(WebElement target) {
		actions.moveToElement(target).perform();
	}

	public void rightClick(WebElement e) {
		actions.contextClick(e);
	}

	public void doubleClick(WebElement e) {
		actions.doubleClick(e);

	}

	public void pressEnter() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void pressUp() {
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);

	}

	public void pressDown() {
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	public void selectCopy() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);

	}

	public void selectPaste() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_P);

	}

	public void selectCut() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_X);

	}

	public void jsType(String data, WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + data + "')", element);

	}

	public void jsClick(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click(, element)");

	}

	public void scrollDown(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void scrollUp(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public void jsGetAttribute(String attName, WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('" + attName + " ', arg1)", element);
	}

	public static boolean display(WebElement element) {
		return element.isDisplayed();
	}

	public static boolean select(WebElement element) {
		return element.isSelected();

	}

	public static boolean enable(WebElement element) {
		return element.isEnabled();
	}

	public Alert switchToAlert() {
		alert = switchToElement().alert();
		return alert;

	}

	public void alertAccept() {
		switchToAlert().accept();
	}

	public void alertDismiss() {
		switchToAlert().dismiss();
	}

	public void alertConfirmAlert(String text) {
		switchToAlert().sendKeys(text);
		switchToAlert().accept();

	}

	public void selectByValue(WebElement e, String value) {
		highlightWebElement(e, "yellow");
		new Select(e).selectByValue(value);
	}

	public TargetLocator switchToElement() {

		return driver.switchTo();
	}

	public void frameS(String name) {
		switchToElement().frame(name);
	}

	public void frameWE(WebElement element) {
		switchToElement().frame(element);

	}

	public String getParentWindowId() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public void switchtoParticularWindow(int index) {

		Set<String> allWindowsId = getAllWindowsId();
		List<String> li = new LinkedList<String>();
		li.addAll(allWindowsId);
		switchToElement().window(li.get(index));
	}

	public Set<String> getAllWindowsId() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public void frame(int index) {

		switchToElement().frame(index);
	}

	public void selectByVisibleText(WebElement element, String value) {
		highlightWebElement(element, "yellow");
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void selectByIndex(WebElement e, int index) {
		highlightWebElement(e, "yellow");
		Select select = new Select(e);
		select.selectByIndex(index);
	}

	public List<WebElement> getOptions(WebElement e) {
		Select select = new Select(e);
		List<WebElement> options = select.getOptions();
		return options;
	}

	public List<WebElement> getAllSelectedOptions(WebElement e) {
		Select select = new Select(e);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public WebElement getFirstSelectedOptions(WebElement e) {
		Select select = new Select(e);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}

	public boolean isMultiple(WebElement e) {
		Select select = new Select(e);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	public void takesScreenshot(String fileName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		File des = new File(fileName);
		FileUtils.copyFile(file, des);
	}

	public String excelRead(int rowNo, int cellNo) throws IOException {
		String name = null;
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\new\\BrowserLaunch\\Input\\Excel.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(inputStream);
		Sheet sh = w.getSheet("Reuse");

		// for (int i = 0; i < list.size(); i++) {
		// WebElement element2 = list.get(i);
		// name = element2.getText();
		Row row = sh.getRow(rowNo);
		Cell c = row.getCell(cellNo);
		int type = c.getCellType();

		if (type == 1) {
			name = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
			name = dateFormat.format(date);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			name = String.valueOf(l);
		}
		return name;

	}

	public static void excelWrite(String name) throws IOException {

		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\new\\BrowserLaunch\\Input\\Excel.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(inputStream);
		Sheet sh = w.getSheet("Reuse");
		Row row = sh.getRow(5);
		Cell c = row.createCell(12);
		String cellValue = c.getStringCellValue();
		if (cellValue.equals("")) {
			c.setCellValue(name);
		}
		FileOutputStream out = new FileOutputStream(file);
		w.write(out);

	}

	public void highlightWebElement(WebElement e, String colour) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:" + colour + "')", e);

	}

}
