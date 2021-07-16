Feature: Validate Challenging dom application

  Background:
    Given application is launched

  @DomApplicationValidation @ApplicationLaunchValidation
  Scenario: To validate challenging dom application is launched successfully
    Then user should be on the home page

  @DomApplicationValidation @ButtonValidation
  Scenario: To validate all the three buttons on the application
    Then user should be on the home page
    And user should see all the three buttons

  @DomApplicationValidation @TableHeaderTextValidation
  Scenario: To validate header of the table on the application
    Then user should be on the home page
    Then user should see the correct header of the table on the page

  @DomApplicationValidation @TableRowsValidation
  Scenario: To validate table should have ten rows
    Then user should be on the home page
    Then user should see ten rows of data in the table

  @DomApplicationValidation @DeleteButtonValidation
  Scenario: To validate on click of delete button row should get deleted
    Then user should be on the home page
    And user click on the delete Button
    Then the row should get deleted

  @DomApplicationValidation @EditAndDeleteLinkValidation
  Scenario: To validate edit and delete link is present for each rows in the table
    Then user should be on the home page
    Then user should see delete and edit link on the page

    # TODO - Work on this Script
  @DomApplicationValidation @EditButtonValidation
  Scenario: To validate on click of edit button row should be editable
    Then user should be on the home page
    And user click on the edit Button
    Then row should be editable

    # TODO - Work on this Script
  @DomApplicationValidation @CanvasImageValidation
  Scenario: To validate answer value should get changed after clicking button
    Then user should be on the home page
    And user should see canvas image on the page
    # And user get the answer value from the page
    # And user should click on the navy Button
    # Then answer value should get changed

 #Assumotion - Text Should Change for each Button After Click
  @DomApplicationValidation @NavyButtonValidation
  Scenario: To validate button text should change on click of navy button
    Then user should be on the home page
    And user get all the text of the button
    And user should click on the navy Button
    Then text should change for each button

    #Assumotion - Text Should Change for each Button After Click
  @DomApplicationValidation @RedButtonValidation
  Scenario: To validate button text should change on click of red button
    Then user should be on the home page
    And user get all the text of the button
    And user should click on red Button
    Then text should change for each button

     #Assumotion - Text Should Change for each Button After Click
  @DomApplicationValidation @GreenButtonValidation
  Scenario: To validate button text should change on click of green button
    Then user should be on the home page
    And user get all the text of the button
    And user should click on green Button
    Then text should change for each button


  @DomApplicationValidation @ForkMeOnGithubTextValidation
  Scenario: To validate text of fork me on Github on challenging dom application
    Then user should be on the home page
    And user should see "Fork me on GitHub" text on the page

  @DomApplicationValidation @ForkMeOnGithubLinkValidation
  Scenario: To validate user should navigate to github page on clicking github link text
    Then user should be on the home page
    And user clicks on the github link
    Then user should navigate to github page

  @DomApplicationValidation @FooterTextValidation
  Scenario: To validate footer text on challenging dom application
    Then user should be on the home page
     And user should see footer text as "Powered by Elemental Selenium" on the page

  @DomApplicationValidation @FooterLinkValidation
  Scenario: To validate user should navigate to element Selenium page on clicking footer link
    Then user should be on the home page
    And user clicks on the footer link
    Then user should navigate to element selenium page





