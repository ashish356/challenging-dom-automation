package com.expelo.challengingdom.automation.stepDefinitions;

import com.expelo.challengingdom.automation.constants.Constants;
import com.expelo.challengingdom.automation.pages.ChallengingDomPage;
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
import java.util.concurrent.TimeUnit;

public class ChallengingDomSteps extends Generic
{

    String navyButtonTextBeforeClick;
    String redButtonTextBeforeClick;
    String greenButtonTextBeforeClick;

    @Given("application is launched")
    public void application_is_launched() {

        HashMap<String , Object> chromePreferences=new HashMap<>();
        chromePreferences.put("profile.default_content_settings.popups",0);
        ChromeOptions options=new ChromeOptions();
        options.addArguments("test-type");
        options.setExperimentalOption("prefs",chromePreferences);
        options.addArguments("start-maximized");
        options.addArguments("--enable-automation");
        options.addArguments("test-type=browser");
        options.addArguments("-disable-infobars");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-Automation"));
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get(Constants.CHALLENGING_DOM_URL);

    }

    @Then("user should be on the home page")
    public void user_should_be_on_the_home_page() {

        if(driver.findElement(ChallengingDomPage.challengingDomText).isDisplayed())
        {
            highlightField(ChallengingDomPage.challengingDomText);
        }
        else
        {
            Assert.fail();
        }
    }



    @Then("user should see all the three buttons")
    public void user_should_see_all_the_three_buttons() {

        Assert.assertTrue(validateButton(ChallengingDomPage.navyButton));
        Assert.assertTrue(validateButton(ChallengingDomPage.redButton));
        Assert.assertTrue(validateButton(ChallengingDomPage.greenButton));

    }



    @Then("user should click on the navy Button")
    public void user_should_click_on_the_navy_Button() throws InterruptedException {

        click(ChallengingDomPage.navyButton);
        Thread.sleep(2000);

    }

    @Then("user get the answer value from the page")
    public void user_get_the_answer_value_from_the_page() {

        System.out.println("Answer Value is :" + driver.findElement(ChallengingDomPage.canvasImage).getAttribute("alt"));

    }

    @Then("user get all the text of the button")
    public void user_get_all_the_text_of_the_button() {

        navyButtonTextBeforeClick=getTextOfTheElement(ChallengingDomPage.navyButton);
        redButtonTextBeforeClick=getTextOfTheElement(ChallengingDomPage.redButton);
        greenButtonTextBeforeClick=getTextOfTheElement(ChallengingDomPage.greenButton);

    }



    @Then("text should change for each button")
    public void text_should_change_for_each_button() {

        Assert.assertTrue(validateText(getTextOfTheElement(ChallengingDomPage.navyButton),navyButtonTextBeforeClick));
        Assert.assertTrue(validateText(getTextOfTheElement(ChallengingDomPage.redButton),redButtonTextBeforeClick));
        Assert.assertTrue(validateText(getTextOfTheElement(ChallengingDomPage.greenButton),greenButtonTextBeforeClick));

    }



    @Then("answer value should get changed")
    public void answer_value_should_get_changed() {

    }

    @Then("user should see delete and edit link on the page")
    public void user_should_see_delete_and_edit_link_on_the_page()
    {
        for(int i=1;i<=10;i++)
        {
            Assert.assertTrue(validateElement(driver.findElement(By.xpath("(//a[text()='edit'])[" +i +"]"))));
            Assert.assertTrue(validateElement(driver.findElement(By.xpath("(//a[text()='delete'])[" +i +"]"))));
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

        }
    }




    @Then("user should see ten rows of data in the table")
    public void user_should_see_ten_rows_of_data_in_the_table() {

        for(int i=0;i<=9;i++)
        {
            Assert.assertTrue(validateElement(driver.findElement(By.xpath("//td[text()='Iuvaret" +i+"'"+"]"))));

        }

    }

    @Then("user click on the delete Button")
    public void user_click_on_the_delete_Button() {

       click(ChallengingDomPage.deleteLink);

    }

    @Then("the row should get deleted")
    public void the_row_should_get_deleted() {

        Assert.assertFalse(validateElement(driver.findElement(By.xpath("//td[text()='Iuvaret0']"))));

    }

    @Then("user click on the edit Button")
    public void user_click_on_the_edit_Button() {

        click(ChallengingDomPage.editLink);

    }

    @Then("row should be editable")
    public void row_should_be_editable() {

        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Iuvaret0']")).isEnabled());

    }

    @Then("user should click on red Button")
    public void user_should_click_on_red_Button() {

        click(ChallengingDomPage.redButton);

    }

    @Then("user should click on green Button")
    public void user_should_click_on_green_Button() {

        click(ChallengingDomPage.greenButton);

    }

    @After
    public void teardown()
    {
        driver.quit();

    }

}
