package utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    public WebDriver driver;
    public WaitHelper(WebDriver driver){
        PageFactory.initElements(driver,this);
       this. driver= driver ;
    }
    public void WaitForElement(WebElement element,long timeOutInSeconds){
        WebDriverWait wait =new WebDriverWait(driver,timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
