package com.expelo.challengingdom.automation.utils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            Date date=new Date();
            String fileName=date.toString().replace(":", "_").replace(" ", "_")+".html";
            extent = new ExtentReports(System.getProperty("user.dir") +"/reports/"+fileName, true, DisplayOrder.OLDEST_FIRST);
            extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
            // optional
            extent.addSystemInfo("Selenium Version", "3.12.0").addSystemInfo(
                    "Environment", "QA");
        }
        return extent;
    }
}
