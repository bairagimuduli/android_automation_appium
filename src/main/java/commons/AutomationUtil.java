package commons;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class AutomationUtil {
    /**
     * getProperty
     *
     * @param sFileName
     * @param propertyName
     * @return
     * @throws IOException
     */
    public static String getProperty(String sFileName, String propertyName) throws IOException {

        String sVal = "";
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/props/" + sFileName));
        sVal = props.getProperty(propertyName);

        return sVal;
    }

    /**
     * getMobileElement
     *
     * @param driver
     * @param sXpath
     * @return
     */
    public MobileElement getMobileElement(AndroidDriver<MobileElement> driver, String sXpath) {

        MobileElement element = driver.findElement(By.xpath(sXpath));
        return element;

    }

    /**
     * getText
     *
     * @param driver
     * @param sXpath
     * @return
     */
    public String getText(AndroidDriver<MobileElement> driver, String sXpath) {
        MobileElement element = getMobileElement(driver, sXpath);
        String sText = element.getText();
        return sText;
    }

    /**
     * click
     *
     * @param driver
     * @param sXpath
     */
    public void click(AndroidDriver<MobileElement> driver, String sXpath) {
        MobileElement element = getMobileElement(driver, sXpath);
        element.click();
    }

    /**
     * sendText
     *
     * @param driver
     * @param sXpath
     * @param sText
     */
    public void sendText(AndroidDriver<MobileElement> driver, String sXpath, String sText) {
        MobileElement element = getMobileElement(driver, sXpath);

        element.clear();
        element.sendKeys(sText);

    }

    /**
     * sendKeys
     *
     * @param driver
     * @param sXpath
     * @param key
     */
    public void sendKeys(AndroidDriver<MobileElement> driver, String sXpath, CharSequence key) {

        MobileElement element = getMobileElement(driver, sXpath);
        element.sendKeys(key);

    }

    /**
     * waitForElementVisible
     *
     * @param driver
     * @param sXpath
     * @param timeOutInSeconds
     * @return
     */
    public boolean waitForElementVisible(AndroidDriver<MobileElement> driver, String sXpath, long timeOutInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

        MobileElement element;
        try {
            element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sXpath)));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

        return element.isDisplayed();

    }

    /**
     * waitForElementVisibleAndClick
     *
     * @param driver
     * @param sXpath
     * @param timeOutInSeconds
     */
    public void waitForElementVisibleAndClick(AndroidDriver<MobileElement> driver, String sXpath, long timeOutInSeconds) {
        if (waitForElementVisible(driver, sXpath, timeOutInSeconds)) {
            click(driver, sXpath);
        }
    }

    /**
     * isDisplayed
     *
     * @param driver
     * @param xPath
     * @return
     */
    public boolean isDisplayed(AndroidDriver<MobileElement> driver, String xPath) {

        try {
            getMobileElement(driver, xPath).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }


}
