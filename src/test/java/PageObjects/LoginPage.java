package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class LoginPage{
    public WebDriver ldriver;

@FindBy (id="username")
private WebElement UserName;
@FindBy(name="pwd")
    private WebElement UserPwd;
@FindBy(id="loginButton")
    private WebElement loginButton;
    @FindBy(xpath = "//a[.='Logout']")
    private WebElement logout;


 public LoginPage(WebDriver driver){
     PageFactory.initElements(driver,this);
     this.ldriver=driver;
 }
 public void SetUserName(String uname){
     UserName.click();
     UserName.sendKeys(uname);
 }
 public void SetPwd(String upwd) {
     UserPwd.click();
     UserPwd.sendKeys(upwd);
 }
 public void ClikOnLogin(){
     loginButton.click();
 }
// public void GetTitle() throws InterruptedException {
//     String title=ldriver.getTitle();
//
////     try{
////         title.equals("actiTIME -  Enter Time-Track");
////         System.out.println("On the Home page");
////
////     }
////     catch (Exception E) {
////         System.out.println(title);
////         System.out.println("Not on the home page");
////         ldriver.close();
////      //   Assert.assertTrue(false);
////     }
// }
 public void ClickOnLogout(){

   logout.click();
 }

}