package ui.stepDefination;

import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import ui.PageObjectClass.SearchResultPage;
import ui.PageObjectClass.SummaryPage;
import ui.PageObjectClass.landingPage;

public class holidayAutosStepDefination {

    WebDriver driver = new DriverFactory().getDriver();

    landingPage landingPage = new landingPage(driver);
    SearchResultPage searchResultPage = new SearchResultPage(driver);

    SummaryPage summaryPage = new SummaryPage(driver);

    @Given("navigate to the url")
    public void openUrl() {

        landingPage.openHolidayAutosUrl();

    }

    @Then("Enter the pick up location as (.+) and (.+)$")
    public void selectPickUpLocation(String city, String country) {
        landingPage.selectPickUpLocation(city, country);
    }

    @Then("enter the pick up (.+) and (.+)$")
    public void selectPickUpDate(String month_year, String date) throws InterruptedException {
        landingPage.selectPickUpDate(month_year, date);
    }

    @Then("enter the pick up time (.+)$")
    public void selectPickUpTime(String time) throws InterruptedException {
        landingPage.selectPickupTime(time);
    }

    @Then("enter the return (.+) and (.+)$")
    public void selectReturnDate(String month_year, String date) throws InterruptedException {
        landingPage.selectReturnDate(month_year, date);
    }

    @Then("enter the return time (.+)$")
    public void selectReturnTime(String time) throws InterruptedException {
        landingPage.selectReturnTime(time);
    }

    @Then("click on search button$")
    public void clickOnSearchBtn() {
        landingPage.clickOnSearchBtn();
    }

    @And("click on low to high sortby button$")
    public void clickOnLowToHighBtn() throws InterruptedException {
        searchResultPage.clickOnLowToHighBtn();
    }

    @And("verify search result page is loaded$")
    public void verifySearchResultPage() {
        searchResultPage.verifySearchResultPage();
    }

    @And("verify the cheapest of cars in the search result page$")
    public void verifyCarList() {
        searchResultPage.verifyCheapestOfCar();
    }

    @And("click on select button$")
    public void clickOnSelectBtn() {
        searchResultPage.clickOnSelectBtn();
    }

    @And("total list of cars in the search result page$")
    public void totalNumberOfCars() {
        searchResultPage.listOfCars();
    }

    @Then("verify the trip summary in step 3$")
    public void verifyTripSummaryStep3() {
        String actualPickUpLocation = searchResultPage.getPickupLocation();
        String actualPickUpDate = searchResultPage.getPickupDate();
        String actualPickUpTime = searchResultPage.getPickupTime();
        String actualReturnLocation = searchResultPage.getReturnLocation();
        String actualReturnDate = searchResultPage.getReturnDate();
        String actualReturnTime = searchResultPage.getReturnTime();
        String actualCost = searchResultPage.verifyCheapestOfCar().substring(2);

        searchResultPage.clickOnSelectBtn();

        summaryPage.validateTripSummary(actualPickUpLocation, actualReturnLocation, actualPickUpDate, actualPickUpTime, actualReturnDate, actualReturnTime, actualCost);
    }

    @After
    public void tearDown() {

        driver.quit();

    }

}
