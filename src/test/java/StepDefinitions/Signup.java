package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.FileReaderManager;
import manager.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Signup {
    public static WebDriver driver;
    WebDriverManager webDriverManager;

    @Given("^User is on home page$")
    public void user_is_on_home_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //     throw new PendingException();
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();

        System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());

//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    @When("^User clicks signup$")
    public void user_clicks_signup() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //  throw new PendingException();
        driver.findElement(By.xpath("//a[@id='signin2']")).click();
    }

    @Then("^Sign pop should appear$")
    public void sign_pop_should_appear() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //  throw new PendingException();
        WebElement popupheading = driver.findElement(By.xpath("//h5[@id='signInModalLabel']"));
        String Signups = popupheading.getText();
    }

    @Then("^Enter Username \"([^\"]*)\"$")
    public void enter_Username(String un) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // throw new PendingException();
        driver.findElement(By.xpath("//input[@id='sign-username']")).click();
        driver.findElement(By.xpath("//input[@id='sign-username']")).sendKeys(un);
    }

    @Then("^Enter Password \"([^\"]*)\"$")
    public void enter_Password(String pw) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //  throw new PendingException();
        driver.findElement(By.xpath("//input[@id='sign-password']")).click();
        driver.findElement(By.xpath("//input[@id='sign-password']")).sendKeys(pw);
        driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
    }

    @Then("^User should be signed up$")
    public void user_should_be_signed_up() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //  throw new PendingException();
        String alertmsg = driver.switchTo().alert().getText();
        Assert.assertEquals("alertmsg", "Sign up successful.");
    }


}
