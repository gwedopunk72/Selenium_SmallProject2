package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RoomListPage;

public class TestBookingHotel {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://103.226.139.66:8080/en/");
        driver.manage().window().maximize();

        HomePage home = new HomePage(driver);
        RoomListPage room = new RoomListPage(driver);
        LoginPage login = new LoginPage(driver);
        CreateAccountPage create = new CreateAccountPage(driver);

        /**
         * [TC12] Adding Room and Pick Date
         */
        home.selectHotel();
        Thread.sleep(1000);
        home.hotelPrime();
        home.cekInDate();
        home.date29();
        home.cekOutDate();
        Thread.sleep(1500);
        home.SearchBtn();
        Thread.sleep(2000);
        room.roomGeneral();
        Thread.sleep(2000);
        room.ProceedCheckoutBtn();
        Thread.sleep(2000);
        Assert.assertEquals("Order - Sekolah QA", driver.getTitle());

        /**
         * [TC13] Add Guest Information
         */
        room.ProceedOrderSummary();
        room.inputFirstname("Bakul");
        room.inputLastName("Areng");
        login.inputEmail("Bakul.Areng36@yahoo.com");
        login.inputPassword("Cilsy2021");
        room.inputPhone("08999665071");
        create.clickRegister();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().contains("Guest Information"));

        /**
         * [TC14] Pay Hotel Room With Bank Transfer
         */
        room.ProceedBtnGuest();
        Thread.sleep(3000);
        room.radioTermServis();
        Thread.sleep(15000);
        room.selectBankWire();
        Thread.sleep(3000);
        room.iConfirmOrder();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Your order on Sekolah QA is complete."));

        /**
         * [TC15] Pay Hotel Room With Check
         */
        home.selHomePage();
        home.selectHotel();
        Thread.sleep(1000);
        home.hotelPrime();
        home.cekInDate();
        home.date30();
        home.cekOutDate();
        Thread.sleep(1500);
        home.SearchBtn();
        Thread.sleep(2000);
        room.roomDelux();
        Thread.sleep(2000);
        room.ProceedCheckoutBtn();
        Thread.sleep(2000);
        room.ProceedOrderSummary();
        Thread.sleep(3000);
        room.ProceedBtnGuest();
        Thread.sleep(3000);
        room.radioTermServis();
        Thread.sleep(15000);
        room.selectBankcheck();
        Thread.sleep(3000);
        room.iConfirmOrder();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Your order on Sekolah QA is complete."));

        /**
         * [TC16] Pay Hotel Room With PayPal
         */
        home.selHomePage();
        home.selectHotel();
        Thread.sleep(1000);
        home.hotelPrime();
        home.cekInDate();
        home.date30();
        home.cekOutDate();
        Thread.sleep(1500);
        home.SearchBtn();
        Thread.sleep(2000);
        room.RoomExecut();
        Thread.sleep(2000);
        room.ProceedCheckoutBtn();
        Thread.sleep(2000);
        room.ProceedOrderSummary();
        Thread.sleep(3000);
        room.ProceedBtnGuest();
        Thread.sleep(3000);
        room.radioTermServis();
        Thread.sleep(15000);
        room.selectBankcheck();
        Thread.sleep(3000);
        room.iConfirmOrder();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Your order on Sekolah QA is complete."));
        driver.close();

    }
}
