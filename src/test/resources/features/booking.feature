Feature: Booking functionality for circle

  As a patient wanting a knee replacement
  I need to know if I can get a replacement local to me
  So that plan my leave and get the treatment


  Background:
    Given I am on the booking appoinment page

  Scenario Outline: Find Consultant Availability
  Given I am a patient wanting a knee replacement
  When I put in my location and date of leave "<date>"
  Then I can get a "<consultants>" and "<time>" availability provided to make my decision
    Examples:
      | date                         | consultants        | time  |
      | Thursday 28th September 2023 | Mr Satyajit Naique | 12:10 |
