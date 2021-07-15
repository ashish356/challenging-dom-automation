package com.expelo.challengingdom.automation.stepDefinitions;

import com.expelo.challengingdom.automation.utils.Generic;
import cucumber.api.java.After;

public class Hooks extends Generic {


    @After
    public void teardown()
    {
        driver.quit();

    }



}
