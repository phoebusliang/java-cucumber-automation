package com.zliang.steps;

import cucumber.api.java.en.Given;

/**
 * Created by twe on 9/27/16.
 */
public class StepTwo extends BasePage {

    @Given("^Close driver$")
    public void I_have_the_this_useless_scenario() {
//        openUrl(arg1);
//        basicOperation.openUrl()
        getBasicOperation().closeWebDriverSession();
        // :D
//        driver.findElement()
//        driver.get();
//        driver.get("http://www.baidu.com");
    }
}
