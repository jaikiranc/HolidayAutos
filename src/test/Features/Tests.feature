@landingPage
Feature: Testcases related to  holiday autos

  Scenario Outline: Verify the search against a location and a date range to give a list of cars.
    Given navigate to the url
    Then Enter the pick up location as <city> and <country>
    Then enter the pick up <pickupMonth> and <pickupDate>
    Then enter the pick up time <pickupTime>
    Then enter the return <returnMonth> and <returnDate>
    Then enter the return time <returnTime>
    Then click on search button
    And verify search result page is loaded
    And total list of cars in the search result page
    Examples:
      | city      | country     | pickupMonth   | pickupDate | pickupTime | returnTime | returnMonth  | returnDate |
      | Dublin    | Ireland     | December 2023 | 12         | 10:30      | 11:00      | January 2024 | 21         |
      | Amsterdam | Netherlands | December 2023 | 10         | 12:00      | 14:30      | January 2024 | 10         |
      | Brussels  | Belgium     | December 2023 | 15         | 11:30      | 13:30      | January 2024 | 10         |


  Scenario: Verify the cheapest car price on search result page
    Given navigate to the url
    Then Enter the pick up location as Dublin and Ireland
    Then enter the pick up May 2023 and 12
    Then enter the pick up time 10:30
    Then enter the return May 2023 and 21
    Then enter the return time 11:00
    Then click on search button
    And verify search result page is loaded
    And click on low to high sortby button
    And verify the cheapest of cars in the search result page

  Scenario Outline: Verify the trip summary in step 3
    Given navigate to the url
    Then Enter the pick up location as <city> and <country>
    Then enter the pick up <month> and <date>
    Then enter the pick up time 10:30
    Then enter the return <month> and 21
    Then enter the return time 11:00
    Then click on search button
    And verify search result page is loaded
    And click on low to high sortby button
    And verify the cheapest of cars in the search result page
    Then verify the trip summary in step 3

    Examples:
      | city   | country | month    | date |
      | Dublin | Ireland | May 2023 | 12   |

