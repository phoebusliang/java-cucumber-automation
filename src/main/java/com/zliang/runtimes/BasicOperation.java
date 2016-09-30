package com.zliang.runtimes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasicOperation {

    WebDriver driver = null;

    public BasicOperation(DesiredCapabilities capability) {
        try {
//            driver = new RemoteWebDriver(new URL(TestProperty.getProperty("hub")), capability);
            driver = new ChromeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void clickElement(String cssSelector) {
//        WebElement ele = driver.findElement(By.cssSelector(cssSelector));
//        ele.click();
        WebElement ele = driver.findElement(By.cssSelector(TestProperty.getProperty("ele")));
    }

    public void closeWebDriverSession() {
        driver.quit();
    }


    public void waitForAjax(long timer) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long begin = System.currentTimeMillis();
        while (System.currentTimeMillis() - begin < timer) {
            boolean ajaxIsComplete = (boolean) js.executeScript("return jQuery.active==0");
            if (ajaxIsComplete)
                break;
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


//    public void closeAllWindows(String className, DesiredCapabilities capability) {
//        Set<String> set = driver.getWindowHandles();
//
//        int num = set.toArray().length;
//        for (int i = 0; i < num; i++) {
//            driver.switchTo().window((String) set.toArray()[i]);
//            this.captureScreenshot(className, capability);
//            driver.close();
//        }
////        sel.stop();
//        driver.quit();
//    }

}
