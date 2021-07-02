package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;

import javax.swing.plaf.TableHeaderUI;

public class TestLoginFeature {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.get("http://103.226.139.66:8080/en/");

//      Creating page object
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        CreateAccountPage create = new CreateAccountPage(driver);

        /**
         [TC01] Create Account With Empty Email
         */
        driver.manage().window().maximize();
        /* Hard Assert */
        String home_title = "Sekolah QA";
        String curr_window_title = driver.getTitle();
        Assert.assertEquals(curr_window_title, home_title);

        home.clickSignin();
        login.clickCreateAccount();
        Thread.sleep(2000);
        String err_empty_mail = driver.findElement(By.id("create_account_error")).getText();
        Assert.assertEquals("Invalid email address.", err_empty_mail);

        /**
         * [TC02] Create Account With Valid Email
         */
        login.mailCreate("tosan.aji22@yahoo.com");
        login.clickCreateAccount();
        Thread.sleep(2000);
        Assert.assertEquals("Login - Sekolah QA", driver.getTitle());

        /**
         * [TC03] Create Account With Valid Personal Information
         */
        create.clickRadio1();
        create.inputFirstName("Tosan");
        create.inputLastName("Aji");
        login.inputPassword("Cilsy2021");

        WebElement dateBirt = driver.findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(dateBirt);
        select.selectByValue("8");
        Thread.sleep(1000);

        WebElement mothBirt = driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMonth = new Select(mothBirt);
        selectMonth.selectByValue("12");
        Thread.sleep(1000);

        WebElement yearBirt = driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYear = new Select(yearBirt);
        selectYear.selectByValue("2000");
        Thread.sleep(1000);

        create.selectNewsLetter();
        create.selectOffer();
        create.clickRegister();
        Thread.sleep(2000);
        home.assSuccess();
        driver.close();

        /**
         * [TC04] Test Sign In Account With Empty Email
         */
        driver.get("http://103.226.139.66:8080/en/");
        driver.manage().window().maximize();
        home.clickSignin();
        login.inputPassword("Gameloft2020");
        login.clickLogin();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("An email address required."));

        /**
         * [TC05] Sign In Account With Empty Password
         */
        login.inputEmail("Tosan.aji@yahoo.com");
        login.inputPassword(" ");
        login.clickLogin();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("Password is required."));

        /**
         * [TC06] Sign In Account With Valid Data
         */
        login.inputPassword("Gameloft2020");
        login.clickLogin();
        Thread.sleep(2000);
        Assert.assertEquals("My account - Sekolah QA", driver.getTitle());
        driver.close();
    }

}
