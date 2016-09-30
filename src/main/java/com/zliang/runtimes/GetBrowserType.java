package com.zliang.runtimes;

public class GetBrowserType {
    public static String browser = "";


    public static String getBrowser() {
        return browser;
    }


    public static void setBrowser(String browser) {
        GetBrowserType.browser = browser;
    }


    public static void main(String[] args) {
        BrowserProperty.setProperty(args[0]);
    }
}
