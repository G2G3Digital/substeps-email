Feature: Email delivery testing
  As a developer
  I want to verify the delivery of an email
  So that I can be sure my software is working

  Scenario: Simple check
    When I've sent an email to "test@example.com" with the subject "test subject"
    Then "test@example.com" receives an email with the subject "test subject"


  Scenario: Complex find
    When I've sent an email to "test@example.com" with the subject "test subject"
    Then "test@example.com" receives an email with the subject "test subject" - complex find substep conditions