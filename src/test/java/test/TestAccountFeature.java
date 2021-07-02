package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class TestAccountFeature {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://103.226.139.66:8080/en/");
        driver.manage().window().maximize();

        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        MyAccountPage account = new MyAccountPage(driver);

        /**
         * [TC07] Add First Address
         */
        home.clickSignin();
        Thread.sleep(1500);
        login.inputEmail("bakul.areng04@yahoo.com");
        login.inputPassword("Cilsy2020");
        login.clickLogin();
        Thread.sleep(2000);

        account.AddAddressBtn();
        Thread.sleep(2000);
        account.fieldCompany("Cilsy");
        account.fieldAddress1("Ngestiharjo, Kasihan");
        account.fieldPostcode("57182");
        account.fieldCity("Bantul");

        Select drpstate = new Select(driver.findElement(By.name("id_state")));
        drpstate.selectByValue("265");

        account.fieldPhone("08564775621");
        account.fieldAddressName("Kontrakan");
        account.saveAddressBtn();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Your addresses are listed below."));




        /**
         * [TC08] Order History
         */
        account.backToYourAddres();
        Thread.sleep(2000);
        account.OrderHistoryBtn();
        Thread.sleep(2000);
        account.backToYourAddres();
        Thread.sleep(2000);
        Assert.assertEquals("My account - Sekolah QA", driver.getTitle());

        /**
         * [TC09] Credit Slips Menu
         */
        account.CreditSlipBtn();
        Thread.sleep(2000);
        account.backToYourAddres();
        Thread.sleep(2000);
        Assert.assertEquals("My account - Sekolah QA", driver.getTitle());

        /**
         * [TC10] My Address Menu
         */
        account.MyAddressesBtn();
        Thread.sleep(2000);
        account.backToYourAddres();
        Thread.sleep(2000);
        Assert.assertEquals("My account - Sekolah QA", driver.getTitle());

        /**
         * [TC11] Change Password From Personal Information Menu
         */
        account.MyPersonalI();
        Thread.sleep(2000);
        account.fieldOldPass("Cilsy2020");
        login.inputPassword("Cilsy2021");
        account.fieldConfirNewPass("Cilsy2021");
        account.saveNewPassBtn();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Your personal information has been successfully updated."));
        driver.close();


    }
}
