package com.expelo.challengingdom.automation.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import gherkin.ast.Scenario;
import javafx.scene.Scene;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Generic {

    public static WebDriver driver;

    public void click(By object)
    {
        highlightField(object);
        driver.findElement(object).click();
    }

    public boolean validateHeaderText(By object, String textValue)
    {
        highlightField(object);
        return driver.findElement(object).getText().equals(textValue);
    }

    public boolean validateText(String textValue1, String textValue2 )
    {
        return textValue1 != textValue2;
    }

    public String getTextOfTheElement(By object)
    {
        return driver.findElement(object).getText();
    }

    public boolean validateButton(By buttonLocator)
    {
        highlightField(buttonLocator);
        return driver.findElement(buttonLocator).isDisplayed();

    }

    public boolean validateElement(WebElement webElement)
    {
        highlightField(webElement);
        return webElement.isDisplayed();

    }

    protected  void highlightField(By object)
    {
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        WebElement element=driver.findElement(object);
        javascriptExecutor.executeScript("arguments[0].style.border='4px groove green'",element );
        try
        {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        javascriptExecutor.executeScript("arguments[0].style.border=''",element);
    }

    protected  void highlightField(WebElement webElement)
    {
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].style.border='4px groove green'",webElement );
        try
        {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        javascriptExecutor.executeScript("arguments[0].style.border=''",webElement);
    }


}
