package com.expelo.challengingdom.automation.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Generic {

    protected final ExtentReports extentReports = ExtentManager.getInstance();
    protected static ExtentTest extentTest;
    public static Scenario scenario;
    public static WebDriver driver;

    public void click(By object) {
        highlightField(object);
        driver.findElement(object).click();
    }

    public boolean validateHeaderText(By object, String textValue) {
        highlightField(object);
        return driver.findElement(object).getText().equals(textValue);
    }

    public boolean validateTextNotMatching(String textValue1, String textValue2) {
        return !textValue1.equals(textValue2);
    }

    public boolean validateText(String textValue1, String textValue2) {
        return textValue1.equals(textValue2);
    }


    public String getTextOfTheElement(By object) {
        return driver.findElement(object).getText();
    }

    public boolean validateButton(By buttonLocator) {
        highlightField(buttonLocator);
        return driver.findElement(buttonLocator).isDisplayed();

    }

    public boolean validateElement(WebElement webElement) {
        highlightField(webElement);
        return webElement.isDisplayed();

    }

    protected void highlightField(By object) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(object);
        javascriptExecutor.executeScript("arguments[0].style.border='4px groove green'", element);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        javascriptExecutor.executeScript("arguments[0].style.border=''", element);
    }

    protected void highlightField(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].style.border='4px groove green'", webElement);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        javascriptExecutor.executeScript("arguments[0].style.border=''", webElement);
    }

    public void scrollPageTillEndOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeInfoInReports(String message) {
        extentTest.log(LogStatus.INFO, message);
        scenario.write(message);

    }

    public void writePassInReports(String message) {
        extentTest.log(LogStatus.PASS, message);
        scenario.write(message);

    }

    public void writeFailInReports(String message) {
        extentTest.log(LogStatus.FAIL, message);
        scenario.write(message);
        Assert.fail(message);

    }

    private static String createTimeStampForFileName(Date date)
    {
        return date.toString().replace(":","_").replace(" ","_");
    }

    private static String file=createTimeStampForFileName(new Date());

public void takeScreenShot(String stepName)
{
    // fileName of the screenshot
    final String screenshotFileName = createTimeStampForFileName(new Date());
    // store screenshot in that file
    final File screenShotImage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

 try

    {
        FileUtils.copyFile(
                screenShotImage,
                new File(
                        System.getProperty("user.dir")
                                + "/reports/"
                                + file
                                + "/screenshot/"
                                + screenshotFileName
                                + "_"
                                + stepName
                                + ".jpg"));
    } catch(IOException e)
    {

      writeFailInReports(String.format("Exception is : %s" ,e));
    }
    // put screenshot file in reports
 extentTest.log(
    LogStatus.INFO,
            "Screenshot-> "
            +stepName
         +extentTest.addScreenCapture(
                 System.getProperty("user.dir")
                 +"/reports/"
                 +file
                 +"/screenshot/"
                         +screenshotFileName
                 +"_"
                         +stepName
                 +".jpg"));
}


    protected static String findWebDriverLocation(String os) {
        String baseDir=System.getProperty("user.dir");
        if(os.contains("mac"))
        {
            return baseDir+"/drivers/chromedriver";
        }else
        {
            return baseDir+"/drivers/chromedriver.exe";
        }


    }
}
