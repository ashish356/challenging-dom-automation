package com.expelo.challengingdom.automation.pages;

import org.openqa.selenium.By;

public class ChallengingDomPage
{
    public static final By challengingDomText= By.xpath("//h3[text()='Challenging DOM']");
    public static final By navyButton=By.className("button");
    public static final By redButton=By.xpath("//a[@class='button alert']");
    public static final By greenButton=By.xpath("//a[@class='button success']");

    public static final By loremText=By.xpath("//th[text()='Lorem']");
    public static final By ipsumText=By.xpath("//th[text()='Ipsum']");
    public static final By dolarText=By.xpath("//th[text()='Dolor']");
    public static final By sitText=By.xpath("//th[text()='Sit']");
    public static final By ametText=By.xpath("//th[text()='Amet']");
    public static final By diceretText=By.xpath("//th[text()='Diceret']");
    public static final By actionText=By.xpath("//th[text()='Action']");

    public static final By canvasImage=By.id("canvas");

    public static final By editLink=By.xpath("//a[text()='edit']");
    public static final By deleteLink=By.xpath("//a[text()='delete']");


}
