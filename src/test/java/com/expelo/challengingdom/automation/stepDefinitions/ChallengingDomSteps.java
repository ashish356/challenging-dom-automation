package com.expelo.challengingdom.automation.stepDefinitions;

import com.expelo.challengingdom.automation.constants.Constants;
import com.expelo.challengingdom.automation.pages.ChallengingDomPage;
import com.expelo.challengingdom.automation.pages.GitHubPage;
import com.expelo.challengingdom.automation.pages.SeleniumPage;
import com.expelo.challengingdom.automation.utils.Generic;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(Constants.CHALLENGING_DOM_URL);
        }
        catch(Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("user should be on the home page")
    public void user_should_be_on_the_home_page() {

        try {
            if (driver.findElement(ChallengingDomPage.challengingDomText).isDisplayed()) {
                highlightField(ChallengingDomPage.challengingDomText);
            } else {
                Assert.fail();
            }
        }
        catch (Exception e)

        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }
    }



    @Then("user should see all the three buttons")
    public void user_should_see_all_the_three_buttons() {

        try {
            Assert.assertTrue(validateButton(ChallengingDomPage.navyButton));
            Assert.assertTrue(validateButton(ChallengingDomPage.redButton));
            Assert.assertTrue(validateButton(ChallengingDomPage.greenButton));
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }
    }



    @Then("user should click on the navy Button")
    public void user_should_click_on_the_navy_Button() throws InterruptedException {

        try {
            click(ChallengingDomPage.navyButton);
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("user get the answer value from the page")
    public void user_get_the_answer_value_from_the_page() {

        try {
            System.out.println("Answer Value is :" + driver.findElement(ChallengingDomPage.canvasImage).getAttribute("alt"));
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("user get all the text of the button")
    public void user_get_all_the_text_of_the_button() {

        try {
            navyButtonTextBeforeClick = getTextOfTheElement(ChallengingDomPage.navyButton);
            redButtonTextBeforeClick = getTextOfTheElement(ChallengingDomPage.redButton);
            greenButtonTextBeforeClick = getTextOfTheElement(ChallengingDomPage.greenButton);
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }



    @Then("text should change for each button")
    public void text_should_change_for_each_button() {

        try {

            String navyButtonTextAfterClick = getTextOfTheElement(ChallengingDomPage.navyButton);
            String redButtonTextAfterClick = getTextOfTheElement(ChallengingDomPage.redButton);
            String greenButtonTextAfterClick = getTextOfTheElement(ChallengingDomPage.greenButton);

            System.out.println("Text of the navy button before click is : " + navyButtonTextBeforeClick + " and Text of the navy button after click is : " + navyButtonTextAfterClick);
            System.out.println("Text of the red button before click is : " + redButtonTextBeforeClick + " and Text of the red button after click is : " + redButtonTextAfterClick);
            System.out.println("Text of the green button before click is : " + greenButtonTextBeforeClick + " and Text of the green button after click is : " + greenButtonTextAfterClick);
            Assert.assertTrue(validateTextNotMatching(navyButtonTextAfterClick, navyButtonTextBeforeClick));
            Assert.assertTrue(validateTextNotMatching(redButtonTextAfterClick, redButtonTextBeforeClick));
            Assert.assertTrue(validateTextNotMatching(greenButtonTextAfterClick, greenButtonTextBeforeClick));
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }



    @Then("answer value should get changed")
    public void answer_value_should_get_changed() {
        try
        {

        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("user should see delete and edit link on the page")
    public void user_should_see_delete_and_edit_link_on_the_page()
    {
        try {
            for (int i = 1; i <= 10; i++) {
                Assert.assertTrue(validateElement(driver.findElement(By.xpath("(//a[text()='edit'])[" + i + "]"))));
                Assert.assertTrue(validateElement(driver.findElement(By.xpath("(//a[text()='delete'])[" + i + "]"))));
            }
        }
        catch (Exception e)
            {
                System.out.println("Exception is : " +e.getMessage());
                Assert.fail("Scripts failed.Exception is : " +e.getMessage());
            }

    }

    @Then("user should see the correct header of the table on the page")
    public void user_should_see_the_correct_header_of_the_table_on_the_page() {

        try {

            Assert.assertTrue(validateHeaderText(ChallengingDomPage.loremText, Constants.LOREM));
            Assert.assertTrue(validateHeaderText(ChallengingDomPage.ipsumText, Constants.IPSUM));
            Assert.assertTrue(validateHeaderText(ChallengingDomPage.dolarText, Constants.DOLOR));
            Assert.assertTrue(validateHeaderText(ChallengingDomPage.sitText, Constants.SIT));
            Assert.assertTrue(validateHeaderText(ChallengingDomPage.ametText, Constants.AMET));
            Assert.assertTrue(validateHeaderText(ChallengingDomPage.diceretText, Constants.DICERET));
            Assert.assertTrue(validateHeaderText(ChallengingDomPage.actionText, Constants.ACTION));
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }
    }




    @Then("user should see ten rows of data in the table")
    public void user_should_see_ten_rows_of_data_in_the_table() {

        try {
            for (int i = 0; i <= 9; i++) {
                Assert.assertTrue(validateElement(driver.findElement(By.xpath("//td[text()='Iuvaret" + i + "'" + "]"))));

            }
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("user click on the delete Button")
    public void user_click_on_the_delete_Button() {

        try {
            click(ChallengingDomPage.deleteLink);
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("the row should get deleted")
    public void the_row_should_get_deleted() {

        try {

            Assert.assertFalse(validateElement(driver.findElement(By.xpath("//td[text()='Iuvaret0']"))));
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("user click on the edit Button")
    public void user_click_on_the_edit_Button() {

        try {
            click(ChallengingDomPage.editLink);
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("row should be editable")
    public void row_should_be_editable() {

        try {
            Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Iuvaret0']")).isEnabled());
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("user should click on red Button")
    public void user_should_click_on_red_Button() {

        try {
            click(ChallengingDomPage.redButton);
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("user should click on green Button")
    public void user_should_click_on_green_Button() {

        try {
            click(ChallengingDomPage.greenButton);
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @After
    public void teardown()
    {
        driver.quit();

    }

    @Then("user should see {string} text on the page")
    public void user_should_see_text_on_the_page(String textValue) {

        try {
            String githubLinkText = driver.findElement(ChallengingDomPage.forkMeOnGithubLink).getAttribute("alt");
            System.out.println("Git Hub link Text is : " + githubLinkText);
            Assert.assertTrue(validateText(githubLinkText, textValue));
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("user clicks on the github link")
    public void user_clicks_on_the_github_link() {

        try {
            click(ChallengingDomPage.forkMeOnGithubLink);
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("user should navigate to github page")
    public void user_should_navigate_to_github_page() {

        try {
            highlightField(GitHubPage.gitHubProjectText);
            Assert.assertTrue(validateElement(driver.findElement(GitHubPage.gitHubProjectText)));
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("user should see footer text as {string} on the page")
    public void user_should_see_footer_text_as_on_the_page(String footerText) {

        try {
            String footerTextFromPage = getTextOfTheElement(ChallengingDomPage.footerText);
            scrollPageTillEndOfThePage();
            highlightField(ChallengingDomPage.footerText);
            System.out.println("Footer Text from page is : " + footerTextFromPage);
            Assert.assertTrue(validateText(footerTextFromPage, footerText));
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
        }

    }

    @Then("user clicks on the footer link")
    public void user_clicks_on_the_footer_link() {

        try {
            scrollPageTillEndOfThePage();
            click(ChallengingDomPage.footerSeleniumLink);
        }
        catch (Exception e)
        {
            System.out.println("Exception is : " +e.getMessage());
            Assert.fail("Scripts failed.Exception is : " +e.getMessage());
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
            System.out.println("Selenium page text is : " + text);
            Assert.assertTrue(validateText(text, Constants.ELEMENTAL_SELENIUM_TEXT));

        } catch (Exception e) {
            System.out.println("Exception is : " + e.getMessage());
            Assert.fail("Scripts failed.Exception is : " + e.getMessage());
        }

    }
}
