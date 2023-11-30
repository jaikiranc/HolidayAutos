package ui.PageObjectClass;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

public class SummaryPage {

    private WebDriver driver;

    By loc_tripSummary_pickUpLocation = By.xpath("//div[@data-auto-id='pickUpLocationReadOnly']//div[@class='ct-panel-trip-summary--location-name']");
    By loc_tripSummary_pickupDate = By.xpath("//span[@data-auto-id='searchFormPickupDateReadOnly']");
    By loc_tripSummary_pickupTime = By.xpath("//span[@data-auto-id='searchFormPickupTimeReadOnly']");
    By loc_tripSummary_ReturnLocation = By.xpath("//div[@data-auto-id='dropOffUpLocationReadOnly']//div[@class='ct-panel-trip-summary--location-name']");
    By loc_tripSummary_returnDate = By.xpath("//span[@data-auto-id='searchFormReturnDateReadOnly']");
    By loc_tripSummary_returnTime = By.xpath("//span[@data-auto-id='searchFormReturnTimeReadOnly']");
    By loc_tripSummary_totalAmount = By.xpath("//div[contains(@class,'ct-total-price')]");


    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    /* method to validate trip summary in step 3*/
    public void validateTripSummary(String pickupLocation, String returnLocation, String pickupDate, String pickupTime, String returnDate, String returnTime, String totalPrice) {
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {

                driver.switchTo().window(actual);

            }
        }

        String expectedPickUpLocation = driver.findElement(loc_tripSummary_pickUpLocation).getText();
        String expectedReturnLocation = driver.findElement(loc_tripSummary_ReturnLocation).getText();
        String expectedReturnDate = driver.findElement(loc_tripSummary_returnDate).getText().substring(5);
        String expectedPickupDate = driver.findElement(loc_tripSummary_pickupDate).getText().substring(5);
        String expectedPickupTime = driver.findElement(loc_tripSummary_pickupTime).getText();
        String expectedReturnTime = driver.findElement(loc_tripSummary_returnTime).getText();

        double d = Double.parseDouble(driver.findElement(loc_tripSummary_totalAmount).getText().substring(2));
        String expectedTotalCost = String.valueOf((int) Math.ceil(d));
        System.out.println(expectedTotalCost);

        Assert.assertTrue(pickupDate.contains(expectedPickupDate));
        Assert.assertTrue(pickupTime.equals(expectedPickupTime));
        Assert.assertTrue(returnDate.contains(expectedReturnDate));
        Assert.assertTrue(returnTime.contains(expectedReturnTime));
        Assert.assertTrue(totalPrice.contains(expectedTotalCost));

    }


}


