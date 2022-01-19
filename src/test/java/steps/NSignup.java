package steps;
import io.cucumber.java.en.*;
import manager.FileReaderManager;
import manager.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class NSignup {
    public static WebDriver driver;
    WebDriverManager webDriverManager;
    @Given("^User is on home page$")
    public void userIsOnHomePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        webDriverManager= new WebDriverManager();
        driver =webDriverManager.getDriver();

        System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());

//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //  throw new PendingException();
    }

    @When("^User clicks signup$")
    public void userClicksSignup() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        driver.findElement(By.xpath("//a[@id='signin2']")).click();
      // throw new PendingException();
    }

    @Then("^Sign pop should appear$")
    public void signPopShouldAppear() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement popupheading =driver.findElement(By.xpath("//h5[@id='signInModalLabel']"));
        String Signups =popupheading.getText();
       // throw new PendingException();
    }

    @Then("^Enter Username \"([^\"]*)\"$")
    public void enterUsername(String un) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@id='sign-username']")).click();
        driver.findElement(By.xpath("//input[@id='sign-username']")).sendKeys(un);
      //  throw new PendingException();
    }

    @Then("^Enter Password \"([^\"]*)\"$")
    public void enterPassword(String pw) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@id='sign-password']")).click();
        driver.findElement(By.xpath("//input[@id='sign-password']")).sendKeys(pw);
        driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
        //throw new PendingException();
    }

    @Then("^User should be signed up$")
    public void userShouldBeSignedUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String alertmsg = driver.switchTo().alert().getText();
        Assert.assertEquals("alertmsg","Sign up successful.");
       // throw new PendingException();
    }

}
