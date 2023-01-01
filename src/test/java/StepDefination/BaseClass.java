package StepDefination;

import PageObjects.AddCustomerpage;
import PageObjects.LoginPage;
import PageObjects.SearchCustmorByEmailID;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

import java.util.Properties;

//import java.util.logging.Logger;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerpage ad;
    public SearchCustmorByEmailID search;
    public static Logger logger;
    public Properties configProp;
    //Created Random String EmailId for unique email
    public static String randomstring(){
        String generatedstring=RandomStringUtils.randomAlphabetic(5);
        return generatedstring;
    }
}
