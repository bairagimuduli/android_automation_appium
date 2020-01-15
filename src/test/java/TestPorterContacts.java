import commons.AndroidAutomationBase;
import commons.AutomationUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import porter.contacts.dataProvider.ContactNames;
import porter.contacts.locators.Locators;

@Slf4j
public class TestPorterContacts extends AndroidAutomationBase {
    private AndroidDriver<MobileElement> driver;
    AutomationUtil automationUtil=new AutomationUtil();
    CharSequence name="bantu";
    long timeOut=2000;


    @Test(dataProvider = "contact-names", dataProviderClass = ContactNames.class,description = "testing the contact search feature of porter")
    public void testSearchContacts(String name, Locators locators, String errorMsg) {
        automationUtil.waitForElementVisibleAndClick(driver, Locators.contactEditText,timeOut);
        log.info("entering the name");
        automationUtil.sendKeys(driver, Locators.contactEditText,name);
        String permissionToContactText = automationUtil.getText(driver, Locators.permissionToContactText);
        Assert.assertEquals(permissionToContactText,"Please provide permission to read contacts from your phone", "permission To Contact Text has changed" );
        automationUtil.waitForElementVisibleAndClick(driver,Locators.proceedButton,timeOut);
        automationUtil.waitForElementVisibleAndClick(driver,Locators.permissionOkButton,timeOut);
        log.info("allowing permission");
        automationUtil.waitForElementVisibleAndClick(driver,Locators.contactPermissionAllowButton,timeOut);
        log.info("going to search the name");
        automationUtil.waitForElementVisibleAndClick(driver,Locators.proceedButton,timeOut);
        boolean isContactListDisplayed = automationUtil.isDisplayed(driver, locators.toString());
        Assert.assertTrue(isContactListDisplayed,errorMsg);
        log.info("job done");
    }

    @AfterClass
    public void teardown(){
        //close the app
        driver.quit();
    }
}
