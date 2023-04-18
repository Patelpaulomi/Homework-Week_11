package testsuite;
/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * <p>
 * 1. LoginTest
 * <p>
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * <p>
 * Enter “tomsmith” username
 * Enter “SuperSecretPassword!” password
 * <p>
 * Click on ‘LOGIN’ button
 * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * Enter “tomsmith1” username
 * Enter “SuperSecretPassword!” password
 * Click on ‘LOGIN’ button
 * Verify the error message “Your username
 * is invalid!”
 * <p>
 * 3. verifyThePasswordErrorMessage
 * Enter “tomsmith” username
 * Enter “SuperSecretPassword” password
 * Click on ‘LOGIN’ button
 * Verify the error message “Your password
 * is invalid!”
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        // find username field
        WebElement emailField = driver.findElement(By.id("username"));
        // Type the Email address to email field element
        emailField.sendKeys("tomsmith");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Find the Login btn Element and click
        WebElement loginbutton = driver.findElement(By.xpath("//i[text()=' Login']"));
        loginbutton.click();
        String expectedMessage = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        // find username field
        WebElement emailField = driver.findElement(By.id("username"));
        // Type the Username inthe Username filed
        emailField.sendKeys("tomsmith1");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Find the Login btn Element and click
        WebElement loginbutton = driver.findElement(By.xpath("//i[text()=' Login']"));
        loginbutton.click();
        //Verify the error massage "Your username is invaild"
        String expectedMessage = "Your username is invalid!\n" +
                "×";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // find username field
        WebElement usernameField = driver.findElement(By.id("username"));
        // Type the Username to Username field element
        usernameField.sendKeys("tomsmith");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        //Find the Login btn Element and click
        WebElement loginbutton = driver.findElement(By.xpath("//i[text()=' Login']"));
        loginbutton.click();
        //Verify the error massage "Your username is invaild"
        String expectedMessage = "Your password is invalid!\n" +
                "×";
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage);


    }

    @After
    public void tearDwon() {
        closeBrowser();
    }


}
