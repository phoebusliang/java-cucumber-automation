package com.zliang;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import com.zliang.runtimes.*;

import java.util.HashMap;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"~@pending"})
public class RunCucumberTests {

    public static final ThreadLocal session = new ThreadLocal();

    public static BasicOperation getBasicOperation() {
        return (BasicOperation) ((HashMap<String, Object>) session.get()).get("BasicOperation");
    }

    public static Object getScenarioProperty(String key) {
        return ((HashMap<String, Object>) session.get()).get(key);
    }

    public static Object setScenarioProperty(String key, Object value) {
        return ((HashMap<String, Object>) session.get()).put(key, value);
    }

    @Before
    public void beforeScenario() {
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("BasicOperation", new BasicOperation(null));
        session.set(context);
    }

    @After
    public void afterScenario() {
        getBasicOperation().closeWebDriverSession();
        session.remove();
    }
}


