package com.zliang.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Steps extends BasePage {

//    public Steps() {
//
//    }

    @Given("^I have the this useless scenario \"(.*?)\"$")
    public void I_have_the_this_useless_scenario(String arg1) {
//        openUrl(arg1);
        getBasicOperation().openUrl(arg1);
        // :D
//        driver.findElement()
//        driver.get();
//        driver.get("http://www.baidu.com");
//        setScenarioProperty("abc", 1323423);

    }

    @When("^I sleep for (\\d+) seconds$")
    public void I_sleep_for_seconds(int arg1) throws InterruptedException {
        Thread.sleep(arg1 * 1000);
//        driver.findElement().click();
    }

    @Then("^It should finnish$")
    public void It_should_finnish() {
//        driver.findElement('button').click();
//        abc = (String)getScenarioProperty("abc");
    }

}
