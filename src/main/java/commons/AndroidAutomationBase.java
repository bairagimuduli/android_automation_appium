package commons;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.io.File;

/**
 * Author- Bairagi Muduli
 * this class loads all the desire capabilities from the properties file
 */
public class AndroidAutomationBase extends BaseTest {
    private static AndroidDriver<MobileElement> driver;

    public static void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        String appName = AutomationUtil.getProperty("androidDetails.props", "appName");
        String deviceName = AutomationUtil.getProperty("androidDetails.props", "deviceName");
        String platform_name = AutomationUtil.getProperty("androidDetails.props", "platformName");
        String appium_version = AutomationUtil.getProperty("androidDetails.props", "appium_version");
        String AUTOMATION_NAME = AutomationUtil.getProperty("androidDetails.props", "AUTOMATION_NAME");
        String platFormVersion = AutomationUtil.getProperty("androidDetails.props", "platFormVersion");
        String uuid = AutomationUtil.getProperty("androidDetails.props", "UDID_Value");
        String currDir = System.getProperty("user.dir");

        File appDir2 = new File(System.getProperty("user.dir"), "src/main/resources/apks");
        File app = new File(appDir2, appName);

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, appium_version);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platFormVersion);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.UDID, uuid);
        driver = new AndroidDriver<MobileElement>(getServiceUrl(), capabilities);
    }

    @BeforeClass
    public static void init() throws Exception {
        setUp();
    }


}
