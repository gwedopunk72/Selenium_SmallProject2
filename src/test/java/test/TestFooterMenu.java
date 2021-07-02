package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RoomListPage;

public class TestFooterMenu {
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
         * [TC17] Check Menu Policies and Legal Notice
         */
        home.clickSignin();
        Thread.sleep(1500);
        login.inputEmail("Bakul.Areng36@yahoo.com");
        login.inputPassword("Cilsy2021");
        login.clickLogin();
        Thread.sleep(2000);

        home.policiesBtn();
        Thread.sleep(2000);
        Assert.assertEquals("http://103.226.139.66:8080/en/content/1-policies", driver.getCurrentUrl());
        home.selHomePage();

        home.legalNoticeBtn();
        Thread.sleep(2000);
        Assert.assertEquals("http://103.226.139.66:8080/en/content/2-legal-notice", driver.getCurrentUrl());
        home.selHomePage();


        /**
         * [TC18] Check Menu Terms And Conditions and About Us
         */
        home.termAndCond();
        Thread.sleep(2000);
        Assert.assertEquals("http://103.226.139.66:8080/en/content/3-terms-and-conditions-of-use", driver.getCurrentUrl());
        home.selHomePage();

        home.aboutUsBtn();
        Thread.sleep(2000);
        Assert.assertEquals("http://103.226.139.66:8080/en/content/4-about-us", driver.getCurrentUrl());
        home.selHomePage();

        home.securePaymentBtn();
        Thread.sleep(2000);
        Assert.assertEquals("http://103.226.139.66:8080/en/content/5-secure-payment", driver.getCurrentUrl());
        home.selHomePage();

        /**
         * [TC19] Check Feature to Change Language
         */
        home.languageSelec();
        Thread.sleep(2000);
        home.languageIndoSelect();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Pembayaran"));

        /**
         * [TC20] Test Logout Feature
         */
        home.accountBtn();
        Thread.sleep(3000);
        home.logoutBtn();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).isEnabled());
        driver.close();
    }
}
