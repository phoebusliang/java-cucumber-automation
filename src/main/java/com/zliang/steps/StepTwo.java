package com.zliang.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by twe on 9/27/16.
 */
public class StepTwo extends BasePage {

    @When("^Refresh")
    public void Refresh() {
        getBasicOperation().openUrl("http://www.google.com");
    }

}
