package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RoomListPage {
    WebDriver driver;

    public RoomListPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator book General Room
    By roomGener = By.xpath("//*[@id=\"category_data_cont\"]/div[1]/div/div[2]/a");
    public void roomGeneral() { driver.findElement(roomGener).click(); }

    //Locator book Delux room
    By roomDelu = By.xpath("//*[@id=\"category_data_cont\"]/div[2]/div/div[2]/a");
    public void roomDelux() { driver.findElement(roomDelu).click(); }

    //Locator book Executive room
    By roomExecut = By.xpath("//*[@id=\"category_data_cont\"]/div[3]/div/div[2]/a");
    public void RoomExecut() { driver.findElement(roomExecut).click(); }

    //Locator button Proceed to Checkout
    By procedCheckout = By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[5]/div[1]/div[2]/div[4]/a");
    public void ProceedCheckoutBtn() { driver.findElement(procedCheckout).click(); }

    //Locator Proceed button on order summary
    By procedSummaryOrder = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/section[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/a[1]");
    public void ProceedOrderSummary() { driver.findElement(procedSummaryOrder).click(); }

    //Locator first name field
    By firstNam = By.id("customer_firstname");
    public void inputFirstname(String first) { driver.findElement(firstNam).sendKeys(first); }

    //Locator last name field
    By lastNam = By.id("customer_lastname");
    public void inputLastName(String last) { driver.findElement(lastNam).sendKeys(last); }

    //Locator phone number
    By phoneNum = By.id("phone_mobile");
    public void inputPhone(String number) { driver.findElement(phoneNum).sendKeys(number); }

    //Locator Proceed button from guest information screen
    By procedGuest = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/section[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/a[1]");
    public void ProceedBtnGuest() { driver.findElement(procedGuest).click(); }

    //Locator Term of Service
    By termServis = By.id("cgv");
    public void radioTermServis() { driver.findElement(termServis).click();
    }

    //Locator select payment with bank wire
    By bankwir = By.partialLinkText("Pay by bank wi");
    public void selectBankWire() { driver.findElement(bankwir).click(); }

    //Locator select payment with check
    By bankcek = By.partialLinkText("Pay by check");
    public void selectBankcheck() { driver.findElement(bankcek).click(); }

    //Locator button I confirm my order
    By conMyOr = By.xpath("//p[@id='cart_navigation']//span");
    public void iConfirmOrder() { driver.findElement(conMyOr).click(); }

}
