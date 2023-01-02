package StepDefination;

import PageObjects.AddCustomerpage;
import PageObjects.LoginPage;
import PageObjects.SearchCustmorByEmailID;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Steps extends BaseClass {
    @Before
    public void serup() throws IOException {
        //Setup the logs
        logger=Logger.getLogger("Mylan0.2");
        PropertyConfigurator.configure("log4j.properties");

        //Reading properties file
        configProp=new Properties();
        FileInputStream file= new FileInputStream("config.properties");
        configProp.load(file);
        String runningbrower=configProp.getProperty("browser");
        if(runningbrower.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
            //  System.setProperty("webdriver.chrome.silentOutput", "true");
            driver = new ChromeDriver();
        }
        else if (runningbrower.equals("firefox")){
            System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
            driver =new FirefoxDriver();
        }
        else {
            System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
            driver =new InternetExplorerDriver();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);





    }




    @Given("User Launch Chrome Browser")
    public void user_launch_chrome_browser() {


        logger.info("********* Lunching Browser *********");
        lp = new LoginPage(driver);

    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        logger.info("******* Launching URL *******");
        driver.get(url);

    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        logger.info("******* Providing the user email and password *******");
        lp.SetUserName(email);
        lp.SetPwd(password);
    }

    @When("Click on Login")
    public void click_on_login() throws InterruptedException {
        logger.info("******* started Login  ******");
        lp.ClikOnLogin();
        Thread.sleep(5000);


    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (driver.getPageSource().contains("Username or Password is invalid. Please try again")) {
            driver.close();
            logger.info("******* Login  fail******");
            Assert.assertTrue(false);
        } else {
           logger.info ("******* Login  passed******");
            Assert.assertEquals(title, driver.getTitle());
            Thread.sleep(3000);
        }
    }

    @When("click on log out Link")
    public void click_on_log_out_link() throws InterruptedException {
        logger.info("******** click On logoutButton ********");
        lp.ClickOnLogout();
        Thread.sleep(3000);

    }


    @Then("close browser")
    public void close_browser() {
        logger.info("******** closing the browser  ********");

        driver.close();
    }

    //stepDefination for nopcommerce WebBrowser

    @When("User Opens the URL {string}")
    public void user_opens_the_url(String url) {

        driver.get(url);
    }

    @When("Enter the Email as {string} and Password as {string}")
    public void enter_the_email_as_and_password_as(String useremail, String pwd) {
        ad = new AddCustomerpage(driver);
        ad.enteremail(useremail);
        ad.enterpwd(pwd);

    }

    @When("Click on Login button")
    public void click_on_login_button() {
        ad.clikonlogin();
    }

    @Then("User can view Dashboad")
    public void user_can_view_dashboad() {
        logger.info("******** verifying Dashboad *******");

        Assert.assertEquals("Dashboard / nopCommerce administration", ad.getTitleOfPage());

    }

    @When("User click on Customers menu")
    public void user_click_on_customers_menu() {
        ad.clickonCustomer();
        //ad.clickonCustomerDropdown();
    }

    @When("click on customer menu tab")
    public void click_on_customer_menu_tab() {
        ad.ClickCustomerTab();
    }

    @When("click on Add new button")
    public void click_on_add_new_button() {
        ad.ClickonAddButton();
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration", ad.getTitleOfPage());
    }

    @When("user give the customer info")
    public void user_give_the_customer_info() {
        logger.info("******** Adding customer details *********");

        String email = randomstring();
        ad.SetEmail(email + "@gmail.com");
        ad.Setpassword("test123");
        ad.clickOnCustomerRole();
        ad.SetCustmorselectRole("Forum Moderators");
        ad.SelectManager("Vendor 2");
        ad.SelectGender("Male");
        ad.FirstName("Sidharth");
        ad.LastName("pattanaik");
        ad.SetDateOfBirath("01/06/1996");
        ad.setCompanyName("QA_HUB");
        ad.CompanyTestField("World Testing Hub");


    }

    @When("click on Save button")
    public void click_on_save_button() throws InterruptedException {
        logger.info("********** Saving Customer Data ************");
        ad.clickOnSaveButton();
        Thread.sleep(5000);
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
        logger.info("********* Verifying Customer is Added ********");
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains(msg));


    }

    // Strps for Searching a customer by EmailID
    @When("Enter customer EmailID")
    public void enter_customer_email_id() {
        logger.info("******** SetEmailID  *******");
    search=new SearchCustmorByEmailID(driver);
    search.setEmailTextBox("victoria_victoria@nopCommerce.com");

    }

    @When("click on Search Button")
    public void click_on_search_button() throws InterruptedException {
        logger.info("******  ClickOnSearchButton   ******");
        search.searchButton();
        Thread.sleep(5000);

    }
    @Then("User should found Email in the search table")
    public void user_should_found_email_in_the_search_table() {
        logger.info("******* Verification of Customer *******");
     boolean status= search.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
     Assert.assertEquals(true,status);
    }
    @When("Enter Customer FirstName")
    public void enter_customer_first_name() {
        logger.info("******* EnterTheFirstName  ********");
        search=new SearchCustmorByEmailID(driver);
        search.setFirstName("Victoria");

    }

    @When("Enter Customer LastName")
    public void enter_customer_last_name() {
        logger.info("******* EnterTheLastName  ********");
        search=new SearchCustmorByEmailID(driver);
        search.setLastName("Terces");
    }
    @Then("User should found FirstName and LastName in the search table")
    public void user_should_found_first_name_and_last_name_in_the_search_table() {
        logger.info("******* Validate the Customer By Name  ********");
        boolean status=search.searchCustomerByName("Victoria Terces");
        Assert.assertEquals(true,status);

    }

}
