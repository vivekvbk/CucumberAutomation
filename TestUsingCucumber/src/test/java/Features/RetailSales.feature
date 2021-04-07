Feature: Login in SmartBusiness
 Scenario Outline:: Login Using Valid Credentials  
    Given User is on login Page
    When Credential are correct
    Then Counter is selected
    Then Company Location is Selected
    Then Finanical year is selected
    Then Search for "<FormName>" Master form
    Then if Draft Entries are present then click on Ignore
    Then Enter "<SalesPerson>" name
    Then Enter "<SKU>" Code
    Then Enter QTY
    Then Enter Payment Amount 
    Then Click on Save Button
    Then Sales Saved Successfully message display
Examples:
    |FormName        |  SalesPerson  | SKU         |
    |Retail Sales    |  Ashwini      | 100010079305|
    |Retail Sales    |  vivek        | 100010079333|
    