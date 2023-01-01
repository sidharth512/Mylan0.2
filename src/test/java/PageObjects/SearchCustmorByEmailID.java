package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.WaitHelper;

import java.util.List;

public class SearchCustmorByEmailID {

    public WebDriver ldriver;
    WaitHelper waithelper;
    public SearchCustmorByEmailID(WebDriver driver){
        ldriver=driver;
        PageFactory.initElements(driver,this);
        waithelper=new WaitHelper(ldriver);
    }


    @FindBy(id ="SearchEmail")
    private WebElement  EmailTextBox;
    @FindBy(id="search-customers")
    private WebElement SearchButton;
    @FindBy(id="SearchFirstName")
    private WebElement SearchFirstName;
    @FindBy(id = "SearchLastName")
    private WebElement SearchLastName;
    @FindBy (id="SearchCompany")
    private WebElement CompanyTextBox;
    @FindBy (id="SearchIpAddress")
    private WebElement IpAddressfield;
    @FindBy (xpath = "//div[@role=\"listbox\"]")
    private WebElement CustomerRole;
    @FindBy (id="SelectedCustomerRoleIds_listbox")
    private WebElement SelectRole;
    @FindBy (id = "SearchMonthOfBirth")
    private WebElement SearchMonthOfBirth;
    @FindBy (id="SearchDayOfBirth")
    private WebElement SearchDayOfBirth;
    @FindBy(xpath="class=\"dataTables_scroll\"")
    private WebElement CustmoersTable;
    @FindBy (xpath = "//table[@role=\"grid\"]")
    private WebElement tblSearchResults;
    @FindBy (id = "customers-grid")
    private WebElement table;
    @FindBy (xpath = "//table[@id=\"customers-grid\"]//tbody/tr")
    private List<WebElement> tableRows;
    @FindBy(xpath = "//table[@id=\"customers-grid\"]//tbody/tr/td")
    private List <WebElement> tableColumns;

    public void setEmailTextBox(String email){
        waithelper.WaitForElement(EmailTextBox,30);
        EmailTextBox.clear();
        EmailTextBox.sendKeys(email);
    }

    public void setFirstName(String FirstName){
        waithelper.WaitForElement(SearchFirstName,30);
        SearchFirstName.clear();
        SearchFirstName.sendKeys(FirstName);
    }
    public void setLastName(String LastName){
        waithelper.WaitForElement(SearchLastName,30);
        SearchLastName.clear();
        SearchLastName.sendKeys(LastName);
    }
    public void searchButton(){
        SearchButton.click();

    }
    public int getNumberOfRows(){
        int Rows =tableRows.size() ;
        return Rows;
    }
    public int getNumberOfColumns(){
        int columns =tableColumns.size();
        return columns;
    }
    public boolean searchCustomerByEmail(String email){
        boolean flag=false;
        for(int i =1;i<=getNumberOfRows();i++){
            String emailid=table.findElement(By.xpath("//table[@id=\"customers-grid\"]/tbody/tr["+i+"]//td[2]")).getText();
            System.out.println(emailid);
            if(emailid.equals(email)){
                flag=true;
            }

        }
        return  flag;

    }
    public boolean searchCustomerByName(String Name){
        boolean flag=false;
        for(int i=1;i<=getNumberOfRows();i++){
            String name=table.findElement(By.xpath("//table[@id=\"customers-grid\"]/tbody/tr["+i+"]//td[3]")).getText();
           String [] names= name.split(" ");
           if(names[0].equals("Victoria") && names[1].equals("Terces")){
               flag=true;
           }
        }
        return flag;
    }


}


