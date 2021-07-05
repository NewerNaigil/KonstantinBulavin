Feature: Different Element Page Tests

  Scenario: Checkbox, radio and dropdown tests
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    And I click on 'Service' button in Header
    And I click on 'Different Element' button in 'Service' dropdown
    When I select 'Water' checkbox on main content area
    And I select 'Wind' checkbox on main content area
    And I select 'Selen' radio button on main content area
    And I select 'Yellow' in dropdown menu on main content area
    Then 1 log row has 'Water: condition changed to true' text in log section
    And 1 log row has 'Wind: condition changed to true' text in log section
    And 1 log row has 'metal: value changed to Selen' text in log section
    And 1 log row has 'Colors: value changed to Yellow' text in log section