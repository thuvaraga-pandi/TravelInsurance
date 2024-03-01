Feature: TravelInsuranceForStudent

  Scenario: TravelInsurance
    Given Click the Travel Insurance
    When Fill the details
    Then Get Insurance Plan
    And Click PolicyBazaar Logo
    Given Click the Car Insurance
    When Fill the Car details
    Then Enter Valid Mail
    And Get Car Quote
    Given Click the Home and HealthInsurance
    When Fill the Health details
    Then Get Health Insurance Plan
