package ui.PageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class landingPage {
    WebDriver driver;
    By pickUpLocation = By.xpath("//input[@id ='pickupLocation']");

    String selectPickUpLocation = "//span[contains(text(),';;') and //b[contains(text(),'%%')]]";
    By loc_pickup_date = By.xpath("//div[@id ='ct-pickup-calendar']");

    By loc_return_date = By.xpath("//div[@id ='ct-return-calendar']");
    By loc_pickup_timer = By.xpath("//div[@id ='ct-pickup-timers']");

    String selectPickupTime = "//ct-time-picker-custom[@name='pickupTime']/div/ul/li/a[text()=';;']";

    String selectReturnTime = "//ct-time-picker-custom[@name='returnTime']/div/ul/li/a[text()=';;']";
    By loc_return_timer = By.xpath("//div[@id ='ct-return-timers']");

    By btn_search = By.xpath("//button[@name ='searchCarsFormBtn']");

    By searchPageResult = By.xpath("//ul[contains(@class,'ct-navigation-arrows')]//li[text()=' Search Results ']");


    public landingPage(WebDriver driver) {
        this.driver = driver;
    }

    /* method to open the URL */
    public void openHolidayAutosUrl() {
        driver.get("https://www.holidayautos.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    /* method to select Pickup location */
    public void selectPickUpLocation(String city, String country) {
        WebElement element = driver.findElement(pickUpLocation);
        Actions action = new Actions(driver);

        //String selector = String.format("//span[contains(text(),'{}') and //b[contains(text(),'{}')]] ",country,city);
        if (element.isDisplayed()) {
            element.sendKeys(city);
            WebElement e1 = driver.findElement(By.xpath(selectPickUpLocation.replace(";;", country).replace("%%", city)));
            action.moveToElement(e1).click().build().perform();
        }
    }

    /* method to select the pick up date */
    public void selectPickUpDate(String month_date, String date) throws InterruptedException {
        driver.findElement(loc_pickup_date).click();
        Thread.sleep(2000);
        selectDate(month_date, date);
    }

    /* method to select Return date */
    public void selectReturnDate(String month_date, String date) throws InterruptedException {
        Thread.sleep(2000);
        selectDate(month_date, date);
    }

    /* method to select the date from the calendar*/
    public void selectDate(String month_year, String select_day) throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'ct-datepicker-header')]/p[1]"));

        for (int i = 0; i < elements.size(); i++) {

//Selecting the month
            if (elements.get(i).getText().equals(month_year)) {

//Selecting the date
                List<WebElement> days = driver.findElements(By.xpath("//div[contains(@class,'ct-datepicker ct-calendar__dynamic-datepicker')]/div[" + (i + 1) + "]/table/tbody/tr/td/span"));

                for (WebElement d : days) {
                    if (d.getText().equals(select_day)) {
                        d.click();
                        Thread.sleep(2000);
                        return;
                    }
                }

            }

        }
        driver.findElement(By.xpath("//div[contains(@class,'ct-datepicker ct-calendar__dynamic-datepicker')]/div[2]/div/button")).click();
        selectDate(month_year, select_day);
    }

    /* method to select pick up time */
    public void selectPickupTime(String time) throws InterruptedException {
        WebElement timePicker = driver.findElement(loc_pickup_timer);
        timePicker.click();
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,250)", "");
        driver.switchTo().activeElement();
        WebElement e1 = driver.findElement(By.xpath(selectPickupTime.replace(";;", time)));
        js.executeScript("arguments[0].scrollIntoView(true);", e1);
        action.moveToElement(e1).click().build().perform();


    }

    /* method to select return time */
    public void selectReturnTime(String time) throws InterruptedException {
        // driver.findElement(loc_pickup_timer).click();
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        WebElement e1 = driver.findElement(By.xpath(selectReturnTime.replace(";;", time)));
        action.moveToElement(e1).click().build().perform();


    }

    /* method to click on search button*/
    public void clickOnSearchBtn() {
        driver.findElement(btn_search).click();
    }


}
