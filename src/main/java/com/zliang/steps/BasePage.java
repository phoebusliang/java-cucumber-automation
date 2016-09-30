package com.zliang.steps;

import com.zliang.RunCucumberTests;
import com.zliang.runtimes.*;


public class BasePage {
//    public BasicOperation basicOperation = null;


//    public BasePage() {
////        basicOperation = new BasicOperation(null);
//    }

    public BasicOperation getBasicOperation() {
        return RunCucumberTests.getBasicOperation();
    }

    public static Object getScenarioProperty(String key) {
        return RunCucumberTests.getScenarioProperty(key);
    }

    public static Object setScenarioProperty(String key, Object value) {
        return RunCucumberTests.setScenarioProperty(key, value);
    }

}
