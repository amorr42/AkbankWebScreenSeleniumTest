Feature: Loans Calculation

  @regression
  Scenario: Succesfull Loans Calculation
    Given Open Akbank Home Page 
    And Click Loans Calculation
    And Enter Amount "50000" in price field
    And Choose Uninsured
    And Set Maturity as twenty months
    And Click Calculation Details
    And Check Masraf ve Maliyet Oranlar screen
    And Click Payment Scheme
    And Check Payment Scheme screen
    And Scroll down Payment Scheme page 
    

