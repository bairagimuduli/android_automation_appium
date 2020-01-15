package porter.contacts.dataProvider;

import commons.DataProviderGenerator;
import org.testng.annotations.DataProvider;
import porter.contacts.locators.Locators;
import java.util.ArrayList;

/**
 * this is a data provider class.
 * it helps running same test for different set of data
 */
public class ContactNames {

    @DataProvider(name = "contact-names")
    public Object[][] getNames() {

        ArrayList name = new ArrayList();
        name.add("");
        name.add("b");
        name.add("ba");
        name.add("ban");
        name.add("bant");
        name.add("bantu");

        ArrayList locator = new ArrayList();
        locator.add(Locators.searchContacts);
        locator.add(Locators.pleaseEnterAtLeast3Character);
        locator.add(Locators.pleaseEnterAtLeast3Character);
        locator.add(Locators.contactList);
        locator.add(Locators.contactList);
        locator.add(Locators.contactList);

        ArrayList errorMsg = new ArrayList();
        errorMsg.add("something wrong happened, page should not change");
        errorMsg.add("it should throw error as name should be more than 3 characters");
        errorMsg.add("it should throw error as name should be more than 3 characters");
        errorMsg.add("no contacts displayed");
        errorMsg.add("no contacts displayed");
        errorMsg.add("no contacts displayed");

        return DataProviderGenerator.generateVariants(name, locator, errorMsg);


    }

}
