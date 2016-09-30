package com.zliang.steps;

import com.zliang.runtimes.TestProperty;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.Objects;

import static junit.framework.TestCase.assertTrue;


public class Steps extends BasePage {

    @Given("^I have the this useless scenario \"(.*?)\"$")
    public void I_have_the_this_useless_scenario(String arg1) {
        getBasicOperation().openUrl(arg1);
    }

    @When("I want to type message \"(.*?)\"")
    public void I_want_to_type_message(String arg1) {
        getBasicOperation().typeText(TestProperty.getProperty("homepage", "search"), arg1);
        setScenarioProperty("title", "百度一下，你就知道");
    }
}
