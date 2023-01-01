package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.stream.events.Comment;

public class AddCustomerpage {
    public WebDriver ldriver;
    public AddCustomerpage(WebDriver driver){
        PageFactory.initElements(driver,this);
        ldriver=driver;

    }
    By LoginButton= By.xpath("//button[contains(text(),'Log in')]");
    By CustomerDropdown= By.xpath("//li[@class=\"nav-item has-treeview menu-open\"]//a[@href='#']/p");
    By CustomersTab=By.xpath("//p[.=' Customers']");
    By AddButton=By.xpath("//a[@class=\"btn btn-primary\" and @href=\"/Admin/Customer/Create\"]");
    By EmailTextField=By.id("Email");
    By PasswordTextField=By.id("Password");
    By FirstTextField=By.id("FirstName");
    By LastNameTextField=By.id("LastName");
    By Gender_MaleRedioButton=By.id("Gender_Male");
    By Gender_FemaleRedioButton= By.id("Gender_Female");
    By DateOfBirthTextField=By.id("DateOfBirth");
    By CompanyTextField=By.id("Company");
    By IsTaxExemptChechBox=By.id("IsTaxExempt");
   By NewsletterTextField= By.xpath("//label[contains(text(),\"Newsletter\")]/../../..//div[contains(@class,\"k-widget k-multiselect\")]/div[contains(@class,\"k-floatwrap\") and @role=\"listbox\"]");
   By YourStoreNameoption=By.xpath("//li[contains(text(),'Your store name')]");
   By Teststore2Option=By.xpath("//li[contains(text(),'Test store 2')]");
   By CustmoerRole = By.xpath("//label[contains(text(),'Customer roles')]/../../..//div[contains(@class,\"input-group-append \")]");
   By AdministratorRole = By.xpath("//li[contains(text(),'Administrators')]");
   By ForumModeratorsRole = By.xpath("//li[contains(text(),'Forum Moderators')]");
   By GuestsRole= By.xpath("//li[contains(text(),'Guests')]");
   By RegisteredRole = By.xpath("//li[contains(text(),'Registered')]");
   By VenderRole= By.xpath("//li[contains(text(),'Vendors')]");
   By ManagerOfVender=By.xpath("//select[@id=\"VendorId\"]");
   By AdminCommentText = By.id("AdminComment");
   By SaveButton = By.name("save");
   By Customer= By.xpath("//a[@href=\"#\"]//p[contains(text(),'Customers')]");
   By Verify=By.xpath("//div[@class=\"input-group\"]//span[contains(text(),'Registered')]");

public void enteremail(String useremail){
    ldriver.findElement(EmailTextField).clear();
    ldriver.findElement(EmailTextField).sendKeys(useremail);
}
public void enterpwd(String pwd){
    ldriver.findElement(PasswordTextField).clear();
    ldriver.findElement(PasswordTextField).sendKeys(pwd);
}

public void clikonlogin(){
    ldriver.findElement(LoginButton).click();
}
public void clickonCustomer(){ldriver.findElement(Customer).click();}
    public void clickonCustomerDropdown(){
        ldriver.findElement(CustomerDropdown).click();
    }
    public void ClickCustomerTab(){
        ldriver.findElement(CustomersTab).click();
    }
    public void ClickonAddButton(){
        ldriver.findElement(AddButton).click();
    }
    public void SetEmail(String email){
        ldriver.findElement(EmailTextField).clear();
        ldriver.findElement(EmailTextField).sendKeys(email);
    }
    public void Setpassword(String pwd){
        ldriver.findElement(PasswordTextField).clear();
        ldriver.findElement(PasswordTextField).sendKeys(pwd);
    }
    public void FirstName(String firstName){
        ldriver.findElement(FirstTextField).sendKeys(firstName);
    }
    public void LastName(String lastName){
        ldriver.findElement(LastNameTextField).sendKeys(lastName);
    }
    public void ClickOnMaleRedioButton(){
        ldriver.findElement(Gender_MaleRedioButton);
    }
    public void ClickOnFemaleRedioButton(){
        ldriver.findElement(Gender_FemaleRedioButton).click();
    }
    public void SetDateOfBirath(String DOB){
        ldriver.findElement(DateOfBirthTextField).sendKeys(DOB);
    }
    public void CompanyTestField(String Company){
        ldriver.findElement(CompanyTextField).sendKeys(Company);
    }
    public void ClickOnIsTaxBox(){
        ldriver.findElement(IsTaxExemptChechBox).click();
    }
    public void ClickOnNewLetterField(){
        ldriver.findElement(NewsletterTextField).click();
    }
    public void ClickOnYourStoreOption(){
        ldriver.findElement(YourStoreNameoption).click();
    }
    public void ClickOnTestStoreOption(){ldriver.findElement(Teststore2Option).click();}
    public void setCompanyName(String CName){
        ldriver.findElement(CompanyTextField).sendKeys(CName);
    }

    public String getTitleOfPage(){
        String title=ldriver.getTitle();
        return title;
    }
    public void SetAdminCommentText(String comment){
        ldriver.findElement(AdminCommentText).sendKeys(comment);
    }
    public void clickOnSaveButton(){
        ldriver.findElement(SaveButton).click();
    }
    public void clickOnCustomerRole(){
        ldriver.findElement(CustmoerRole).click();
    }
    public void SetCustmorselectRole(String role){

        WebElement Listitem;

        if(role.equals("Administrators")){
            Listitem=ldriver.findElement(AdministratorRole);

        }
        else if (role.equals("Guest")){
            Listitem=ldriver.findElement(GuestsRole);
        }
        else if (role.equals("Registered")){
            Listitem=ldriver.findElement(RegisteredRole);

        }
        else if (role.equals("Forum Moderators")){
            Listitem=ldriver.findElement(ForumModeratorsRole);

        }
        else {
            Listitem=ldriver.findElement(VenderRole);
        }
             Listitem.click();
//        JavascriptExecutor js= (JavascriptExecutor)ldriver;
//        js.executeScript("argumentgs[0].click();",Listitem);
    }
    public void SelectManager(String value){
    ldriver.findElement(ManagerOfVender).click();
        Select scr =new Select(ldriver.findElement(ManagerOfVender));
        scr.selectByVisibleText(value);
    }
    public void SelectGender(String gender){
        if(gender.equals(ldriver.findElement(Gender_MaleRedioButton).getText())){
            ldriver.findElement(Gender_MaleRedioButton).click();

        }
        else if(gender.equals(ldriver.findElement(Gender_FemaleRedioButton).getText())) {
            ldriver.findElement(Gender_FemaleRedioButton).click();
        }
        else {
            ldriver.findElement(Gender_MaleRedioButton).click();
        }
    }




}
