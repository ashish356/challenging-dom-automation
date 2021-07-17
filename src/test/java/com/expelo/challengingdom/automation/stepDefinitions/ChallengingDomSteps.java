package com.expelo.challengingdom.automation.stepDefinitions;

import com.expelo.challengingdom.automation.constants.Constants;
import com.expelo.challengingdom.automation.pages.ChallengingDomPage;
import com.expelo.challengingdom.automation.pages.GitHubPage;
import com.expelo.challengingdom.automation.pages.SeleniumPage;
import com.expelo.challengingdom.automation.utils.Generic;

import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class ChallengingDomSteps extends Generic
{

    String navyButtonTextBeforeClick;
    String redButtonTextBeforeClick;
    String greenButtonTextBeforeClick;



    @Given("application is launched")
    public void application_is_launched() {

        try {
            HashMap<String, Object> chromePreferences = new HashMap<>();
            chromePreferences.put("profile.default_content_settings.popups", 0);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            options.setExperimentalOption("prefs", chromePreferences);
            options.addArguments("start-maximized");
            options.addArguments("--enable-automation");
            options.addArguments("test-type=browser");
            options.addArguments("-disable-infobars");
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-Automation"));
            System.setProperty("webdriver.chrome.driver", findWebDriverLocation(System.getProperty("os.name").toLowerCase()));
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(Constants.CHALLENGING_DOM_URL);
        }
        catch(Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Then("user should be on the home page")
    public void user_should_be_on_the_home_page() {

        try {
            if (driver.findElement(ChallengingDomPage.challengingDomText).isDisplayed()) {
                highlightField(ChallengingDomPage.challengingDomText);
                writePassInReports("Application is launched successfully");
                takeScreenShot("Home_Page");
            } else {
                takeScreenShot("Home_Page");
                writeFailInReports("Application is not launched successfully");
            }
        }
        catch (Exception e)

        {
            writeFailInReports(String.format("Exception is : %s", e));
        }
    }



    @Then("user should see all the three buttons")
    public void user_should_see_all_the_three_buttons() {

        try {
            if(validateButton(ChallengingDomPage.navyButton)&& validateButton(ChallengingDomPage.redButton)&&validateButton(ChallengingDomPage.greenButton)) {
                writePassInReports("All the three buttons validated successfully");
            }
            else
            {
                writeFailInReports("All the three buttons not validated successfully");
            }
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }
    }



    @Then("user should click on the navy Button")
    public void user_should_click_on_the_navy_Button() throws InterruptedException {

        try {
            click(ChallengingDomPage.navyButton);
            Thread.sleep(2000);
            writeInfoInReports("Navy Button is clicked successfully");
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }



    @Then("user get all the text of the button")
    public void user_get_all_the_text_of_the_button() {

        try {
            navyButtonTextBeforeClick = getTextOfTheElement(ChallengingDomPage.navyButton);
            redButtonTextBeforeClick = getTextOfTheElement(ChallengingDomPage.redButton);
            greenButtonTextBeforeClick = getTextOfTheElement(ChallengingDomPage.greenButton);
            writeInfoInReports("Navy Button Text Before Click is :" +navyButtonTextBeforeClick + " Red Button Text Before Click is : " +redButtonTextBeforeClick+ " Green Button Text Before click is : "+greenButtonTextBeforeClick);
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }



    @Then("text should change for each button")
    public void text_should_change_for_each_button() {

        try {

            String navyButtonTextAfterClick = getTextOfTheElement(ChallengingDomPage.navyButton);
            String redButtonTextAfterClick = getTextOfTheElement(ChallengingDomPage.redButton);
            String greenButtonTextAfterClick = getTextOfTheElement(ChallengingDomPage.greenButton);

            writeInfoInReports("Text of the navy button before click is : " + navyButtonTextBeforeClick + " and Text of the navy button after click is : " + navyButtonTextAfterClick);
            writeInfoInReports("Text of the red button before click is : " + redButtonTextBeforeClick + " and Text of the red button after click is : " + redButtonTextAfterClick);
            writeInfoInReports("Text of the green button before click is : " + greenButtonTextBeforeClick + " and Text of the green button after click is : " + greenButtonTextAfterClick);
            if(validateTextNotMatching(navyButtonTextAfterClick, navyButtonTextBeforeClick)&&validateTextNotMatching(redButtonTextAfterClick, redButtonTextBeforeClick)&&validateTextNotMatching(greenButtonTextAfterClick, greenButtonTextBeforeClick))
            {
                writePassInReports("All three button text changed successfully on click of one of the button");
            }
          else {
                writeFailInReports("All three button text not changed successfully on click of one of the button");
            }
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }



    @Then("answer value should get changed")
    public void answer_value_should_get_changed() {
        try
        {
           writeFailInReports("Unable to read answer value from the canvas image");
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Then("user should see delete and edit link on the page")
    public void user_should_see_delete_and_edit_link_on_the_page()
    {
        try {
            for (int i = 1; i <= 10; i++) {

                if(validateElement(driver.findElement(By.xpath("(//a[text()='edit'])[" + i + "]"))) &&validateElement(driver.findElement(By.xpath("(//a[text()='delete'])[" + i + "]"))))
                {
                    writePassInReports("Delete and Edit Link is present for the row "+i+" in the table");
                }
                else {
                    writeFailInReports("Delete and Edit Link is not present for the row "+i+" in the table");
                }

            }
        }
        catch (Exception e)
            {
                writeFailInReports(String.format("Exception is : %s", e));
            }

    }

    @Then("user should see the correct header of the table on the page")
    public void user_should_see_the_correct_header_of_the_table_on_the_page() {

        try {

            if(validateHeaderText(ChallengingDomPage.loremText, Constants.LOREM)&&validateHeaderText(ChallengingDomPage.ipsumText, Constants.IPSUM)&&
                    validateHeaderText(ChallengingDomPage.dolarText, Constants.DOLOR)&&validateHeaderText(ChallengingDomPage.sitText, Constants.SIT)&&
            validateHeaderText(ChallengingDomPage.ametText, Constants.AMET)&&validateHeaderText(ChallengingDomPage.diceretText, Constants.DICERET)
             &&validateHeaderText(ChallengingDomPage.actionText, Constants.ACTION))
            {
                writePassInReports("Table header is validated successfully");
            }
            else {
                writeFailInReports("Table header is not validated successfully");
            }


        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }
    }




    @Then("user should see ten rows of data in the table")
    public void user_should_see_ten_rows_of_data_in_the_table() {

        try {
            for (int i = 0; i <= 9; i++) {
                int j=i+1;
                if(validateElement(driver.findElement(By.xpath("//td[text()='Iuvaret" + i + "'" + "]"))))
                {

                    writePassInReports("Data in row "+j+" is validated successfully");
                }
                else {
                    writeFailInReports("Data in row "+j+" is not validated successfully");
                }

            }
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Then("user click on the delete Button")
    public void user_click_on_the_delete_Button() {

        try {
            click(ChallengingDomPage.deleteLink);
            writeInfoInReports("User Clicked on Delete Link");
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Then("the row should get deleted")
    public void the_row_should_get_deleted() {

        try {

            if(!validateElement(driver.findElement(By.xpath("//td[text()='Iuvaret0']"))))
            {
                writePassInReports("Rows deleted successfully on click of delete link");
                takeScreenShot("Updated_Home_Page");
            }
            else {
                takeScreenShot("Updated_Home_Page");
                writeFailInReports("Row is not deleted on click of delete link");
            }
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Then("user click on the edit Button")
    public void user_click_on_the_edit_Button() {

        try {
            click(ChallengingDomPage.editLink);
            writeInfoInReports("User Clicked on Edit Link");
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }



    @Then("user should click on red Button")
    public void user_should_click_on_red_Button() {

        try {
            click(ChallengingDomPage.redButton);
            writeInfoInReports("User Clicked on Red Button");
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Then("user should click on green Button")
    public void user_should_click_on_green_Button() {

        try {
            click(ChallengingDomPage.greenButton);
            writeInfoInReports("User Clicked on Green Button");
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @After
    public void teardown()
    {
        if (driver != null) {
            driver.quit();
        }

        if (extentReports != null) {
            try {
                extentReports.endTest(extentTest);
                extentReports.flush();
            } catch (Exception e) {
                writeFailInReports(String.format("Exception is : %s", e));

            }
        }

    }

    @Then("user should see {string} text on the page")
    public void user_should_see_text_on_the_page(String textValue) {

        try {
            String githubLinkText = driver.findElement(ChallengingDomPage.forkMeOnGithubLink).getAttribute("alt");
            writeInfoInReports("Git Hub link Text is : " + githubLinkText);
            if(validateText(githubLinkText, textValue)){
                writePassInReports("Git Hub Link text is validated successfully");
            }
            else {
                writeFailInReports("Git Hub Link text is not validated successfully");
            }
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Then("user clicks on the github link")
    public void user_clicks_on_the_github_link() {

        try {
            click(ChallengingDomPage.forkMeOnGithubLink);
            writeInfoInReports("user clicked on Git Hub Link");
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Then("user should navigate to github page")
    public void user_should_navigate_to_github_page() {

        try {
            highlightField(GitHubPage.gitHubProjectText);
            if(validateElement(driver.findElement(GitHubPage.gitHubProjectText))){
                writePassInReports("User successfully navigated to Github Page");
                takeScreenShot("Git_Hub_Page");
            }
            else {
                takeScreenShot("Git_Hub_Page");
                writeFailInReports("User is not navigated to Github Page");
            }
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Then("user should see footer text as {string} on the page")
    public void user_should_see_footer_text_as_on_the_page(String footerText) {

        try {
            String footerTextFromPage = getTextOfTheElement(ChallengingDomPage.footerText);
            scrollPageTillEndOfThePage();
            highlightField(ChallengingDomPage.footerText);
            writeInfoInReports("Footer Text from page is : " + footerTextFromPage);
            if(validateText(footerTextFromPage, footerText))
            {
                writePassInReports("Footer Text is validated successfully");
                takeScreenShot("Footer");
            }
            else {
                takeScreenShot("Footer");
                writeFailInReports("Footer Text is not validated successfully");
            }
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Then("user clicks on the footer link")
    public void user_clicks_on_the_footer_link() {

        try {
            scrollPageTillEndOfThePage();
            click(ChallengingDomPage.footerSeleniumLink);
            writeInfoInReports("User clicks on Footer Link");
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Then("user should navigate to element selenium page")
    public void user_should_navigate_to_element_selenium_page() {

        try {

            String parentWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
            for (String window : windowHandles) {
                if (window != parentWindow)
                    driver.switchTo().window(window);
            }

            String text = getTextOfTheElement(SeleniumPage.seleniumText);
            highlightField(SeleniumPage.seleniumText);
            writeInfoInReports("Selenium page text is : " + text);
           if(validateText(text, Constants.ELEMENTAL_SELENIUM_TEXT))
           {
               writePassInReports("User is successfully navigated to Selenium page");
               takeScreenShot("Selenium Page");
           }
           else {
               takeScreenShot("Selenium Page");
               writeFailInReports("User is not navigated to Selenium page");
           }

        } catch (Exception e) {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Before
    public void setup(Scenario scenario) {

        Generic.scenario = scenario;
        extentTest = extentReports.startTest(scenario.getName());
        createDirectoryIfDoesNotExist("reports");
    }

    private void createDirectoryIfDoesNotExist(final String directoryName) {
        final File directory = new File(Constants.PROJECT_DIRECTORY + "/" + directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
    @Then("user get the answer value from the page")
    public void user_get_the_answer_value_from_the_page() {

        try {

            writeFailInReports("Unable to read answer value from the canvas image");
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }

    @Then("user should see canvas image on the page")
    public void user_should_see_canvas_image_on_the_page() {

        try {
            if(validateElement(driver.findElement(ChallengingDomPage.canvasImage)))
            {
                writePassInReports("Canvas Image is present on the Page");
            }
            else {
                writePassInReports("Canvas Image is not present on the Page");
            }

        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }
    }

    @Then("row should be editable")
    public void row_should_be_editable() {

        try {



            Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Iuvaret0']")).isEnabled());
            writeFailInReports("Unable to verify any field is editable on click of edit button");
        }
        catch (Exception e)
        {
            writeFailInReports(String.format("Exception is : %s", e));
        }

    }


}
