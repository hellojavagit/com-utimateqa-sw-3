package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //clicking the sign in link
        clickOnElement(By.linkText("Sign In"));
        //sending email fields
        sendTextToElement(By.id("user[email]"), "prime@gmail.com");
        //sending password field
        sendTextToElement(By.name("user[password]"), "abcd123");
        //comparing the expected and actual results
        verifyTextMessages("Messages does not match", "Welcome Back!", By.xpath("//h1[contains(text(),'Welcome Back!')]"));
    }

    //verifying the error message by sending wrong email id
    @Test
    public void verifyTheErrorMessage() {

        clickOnElement(By.linkText("Sign In"));
        //sending the wrong email id and checking
        sendTextToElement(By.id("user[email]"), "Prime@gmail.com");

        //sending password fields
        sendTextToElement(By.name("user[password]"), "abcd");

        //clicking on submit button
        clickOnElement(By.cssSelector("input[value='Sign in']"));
        verifyTextMessages("ErrorMessage","Invalid email or password.",By.xpath("//li[contains(text(),'Invalid email or password.')]"));

    }

    // closing the browser
    @After
    public void tearDown() {
        closeBrowser();
    }

}
