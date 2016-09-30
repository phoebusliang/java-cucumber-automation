package com.zliang.runtimes;

import java.io.*;
import java.util.Properties;

public class BrowserProperty {

    private static final String propPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "zliang" + File.separator + "properties" + File.separator + "browser.properties";


    public static String getProperty(String key) {
        Properties prop = new Properties();
        InputStream is = null;
        try {

            is = new FileInputStream(propPath);
            prop.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop.getProperty(key);
    }

    public static void setProperty(String browser) {
        InputStream fis = null;
        OutputStream fos = null;
        try {
            Properties prop = new Properties();
            fis = new FileInputStream(propPath);

            prop.load(fis);

            fos = new FileOutputStream(propPath);
            prop.setProperty("browser", browser);

            prop.store(fos, "Update '" + "browser" + "' value");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void setUrl(String url) {
        InputStream fis = null;
        OutputStream fos = null;
        try {
            Properties prop = new Properties();
            fis = new FileInputStream(propPath);

            prop.load(fis);

            fos = new FileOutputStream(propPath);
            prop.setProperty("url", url);

            prop.store(fos, "Update '" + "url" + "' value");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String args[]) {
        System.out.println("TestProperty set start");
        setProperty(args[0]);

        System.out.println("TestProperty set end");
    }
}
