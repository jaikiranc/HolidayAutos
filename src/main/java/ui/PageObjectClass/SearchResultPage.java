package ui.PageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {

    private WebDriver driver;


    By loc_availablity_list = By.xpath("//ct-availability-list-sorting//button//span[text()='price (low to high)']");

    By searchPageResult = By.xpath("//ul[contains(@class,'ct-navigation-arrows')]//li[text()=' Search Results ']");

    By loc_listOfCars = By.xpath("//div[@id='ct-availability-list']//div[@class='ct-car-list-item__wrap ct-relative']");

    By loc_numberOfCar = By.xpath("//strong[@class='availabilitySummaryTotal']");
    By loc_lowest_PriceCar = By.xpath("//ct-vehicle-block-price-total-amount//div");

    By loc_searchResult_Selectbtn = By.xpath("//span[text()='Select']");
    By loc_searchResult_pickUpLocation = By.xpath(" //strong[@ng-bind='::data.pickupLocation.name']");
    By loc_searchResult_pickupDate = By.xpath("//strong[@data-auto-id='searchFormPickupDateReadOnly']");
    By loc_searchResult_pickupTime = By.xpath("//strong[@data-auto-id='searchFormPickupTimeReadOnly']");
    By loc_searchResult_ReturnLocation = By.xpath("//strong[@ng-bind='::data.returnLocation.name']");
    By loc_searchResult_returnDate = By.xpath("//strong[@data-auto-id='searchFormReturnDateReadOnly']");
    By loc_searchResult_returnTime = By.xpath("//strong[@data-auto-id='searchFormReturnTimeReadOnly']");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    /* method to click on low to high button in sort step 2*/
    public void clickOnLowToHighBtn() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> btn = driver.findElements(loc_availablity_list);
        for (WebElement ele : btn) {
            if (ele.isDisplayed()) {
                ele.click();
            }
        }
    }

    /* method to verify the cheapest car in  step 2*/
    public String verifyCheapestOfCar() {
        org.openqa.selenium.JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        List<WebElement> listOfCars = driver.findElements(loc_lowest_PriceCar);
        if (listOfCars.get(0).isDisplayed()) {
            System.out.println("Cheapest car Price:" + listOfCars.get(0).getText());
        }
        return listOfCars.get(0).getText();
    }

    /* method to get the pickup location in step 2*/
    public String getPickupLocation() {
        String actualPickupLocation = driver.findElement(loc_searchResult_pickUpLocation).getText();
        return actualPickupLocation;
    }

    /* method to get the pickup date in step 2*/
    public String getPickupDate() {
        String actualPickupDate = driver.findElement(loc_searchResult_pickupDate).getText();
        return actualPickupDate;
    }

    /* method to get the pickup time in step 2*/
    public String getPickupTime() {
        String actualPickupTime = driver.findElement(loc_searchResult_pickupTime).getText();
        return actualPickupTime;
    }

    /* method to get the return date in step 2*/
    public String getReturnDate() {
        String actualReturnDate = driver.findElement(loc_searchResult_returnDate).getText();
        return actualReturnDate;
    }

    /* method to get the return time in step 2*/
    public String getReturnTime() {
        String actualReturnTime = driver.findElement(loc_searchResult_returnTime).getText();
        return actualReturnTime;
    }

    /* method to get the return location in step 2*/
    public String getReturnLocation() {
        String actualReturnLocation = driver.findElement(loc_searchResult_ReturnLocation).getText();
        return actualReturnLocation;
    }

    /* method to get the list of cars in step 2*/
    public void listOfCars() {
        List<WebElement> listOfCars = driver.findElements(loc_numberOfCar);
        for (WebElement ele : listOfCars) {
            if (ele.isDisplayed()) {
                System.out.println("Total number of cars listed:" + ele.getText());
            }
        }
    }

    /* verify the search result page*/
    public void verifySearchResultPage() {
        if (driver.findElement(searchPageResult).isDisplayed()) {
            System.out.println(" Search Result page is loaded");
        }

    }

    /* method to click on select button*/
    public void clickOnSelectBtn() {
        List<WebElement> selectBtn = driver.findElements(loc_searchResult_Selectbtn);
        if (selectBtn.get(0).isDisplayed()) {

            selectBtn.get(0).click();
        }
    }
}

