Feature: Film

  Scenario : Should be able to post film
    Given New Film
    When Post new film
    Then I should save film with actors

