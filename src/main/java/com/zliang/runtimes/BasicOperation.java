package com.zliang.runtimes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class BasicOperation {

    WebDriver driver = null;

    public BasicOperation() {
        try {
            switch (BrowserProperty.getProperty("browser")) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void clickElement(String cssSelector) {
        WebElement element = waitElementDisplay(cssSelector);
        element.click();
    }

    public void typeText(String locator, String txt) {
        WebElement element = waitElementDisplay(locator);
        element.sendKeys(txt);
    }

    public void closeWebDriverSession() {
        driver.quit();
    }


    public WebElement waitElementDisplay(String loc) {
        long begin = System.currentTimeMillis();
        do {
            WebElement element = driver.findElement(By.cssSelector(loc));
            if (element.isDisplayed())
                return element;
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while ((System.currentTimeMillis() - begin) < Long.parseLong(TestProperty.getProperty("test", "sleep")));
        return null;
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
