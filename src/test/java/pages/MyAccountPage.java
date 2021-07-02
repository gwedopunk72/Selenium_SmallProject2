package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPage {
    WebDriver driver;
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

//  Locator add my first address button
    By addAddre = By.className("icon-building");
    public void AddAddressBtn() { driver.findElement(addAddre).click(); }

// Locator Order History Button
    By histoBut = By.className("icon-list-ol");
    public void OrderHistoryBtn() { driver.findElement(histoBut).click(); }

// Locator My Credit Slip button
    By creSlip = By.className("icon-file-o");
    public void CreditSlipBtn() { driver.findElement(creSlip).click(); }

//  Locator My Addresses button
    By myAddre = By.className("icon-building");
    public void MyAddressesBtn() { driver.findElement(myAddre).click(); }

//  Locator My Personal Info button
    By myInf = By.className("icon-user");
    public void MyPersonalI() { driver.findElement(myInf).click(); }

//  Locator Back to your address button
    By backAdd = By.xpath("//div[@id='center_column']/ul//span");
    public void backToYourAddres() { driver.findElement(backAdd).click(); }

//  Locator field company
    By comName = By.id("company");
    public void fieldCompany(String name) { driver.findElement(comName).sendKeys(name); }

//  locator field address
    By addreName = By.id("address1");
    public void fieldAddress1(String alamat) { driver.findElement(addreName).sendKeys(alamat); }

//  Locator field Postal code
    By postalName = By.id("postcode");
    public void fieldPostcode(String number) { driver.findElement(postalName).sendKeys(number); }

//  Locator field City
    By citName = By.id("city");
    public void fieldCity(String kota) { driver.findElement(citName).sendKeys(kota); }

//  Locator field State
//    By stateNam = By.id("id_state");
//    public void fieldState() { driver.findElement(stateNam). }

//  Locator field Phone number
    By phoneNum = By.id("phone_mobile");
    public void fieldPhone(String number) { driver.findElement(phoneNum).sendKeys(number); }

//  Locator field address name
    By aliasNam = By.id("alias");
    public void fieldAddressName(String alias) { driver.findElement(aliasNam).sendKeys(alias); }

//  Locator button save address
    By saveAddressBut = By.id("submitAddress");
    public void saveAddressBtn() { driver.findElement(saveAddressBut).click(); }

//  Locator field enter old password
    By fielOldPas = By.id("old_passwd");
    public void fieldOldPass(String pass) { driver.findElement(fielOldPas).sendKeys(pass); }

//  Locator new password confirmation field
    By confNewPa = By.id("confirmation");
    public void fieldConfirNewPass (String pass) { driver.findElement(confNewPa).sendKeys(pass); }

//  Locator Save button to change password
    By savPass = By.cssSelector("button[name='submitIdentity']");
    public void saveNewPassBtn() { driver.findElement(savPass).click(); }
}
