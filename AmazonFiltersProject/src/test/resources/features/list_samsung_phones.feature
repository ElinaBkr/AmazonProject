Feature: Phones Search

  Scenario: List all Samsung phones with given criteria
    Given I am on the Amazon home page and accept the T&C
    When I navigate to "Electronics & Computers" > "Phones & Accessories" > "Mobile Phones"
    And I filter by Camera Resolution "20 MP and above", Model Year "2023", Price Range "£50 - £100"
    Then I should see a list of Samsung phones that match the criteria