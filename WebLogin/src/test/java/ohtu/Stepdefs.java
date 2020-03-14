package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @When("username {string} with password {string} does not exist")
    public void userDoesNotExist(String username, String password) {
        logInWith(username, password);
    }  
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
  
    
//    @Then("user is not logged in and error message is given")
//    public void userIsNotFound() {
//        pageHasContent("invalid username or password");
//        pageHasContent("Give your credentials to login");
//    }   
    
    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @Given("command new user is selected")
    public void newIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    } 
       
    @When("a valid username {string} and password {string} and matching password confirmation {string} are entered")
    public void creationSuccessful(String username, String password, String passwordConfirmation) throws Throwable {
        createAccountWith(username, password, passwordConfirmation);
    } 
    
    @Then("a new user is created")
    public void creationSuccessfulLogin() {
        pageHasContent("Welcome to Ohtu Application!");
//        String pageContent = "Ohtu Application main page";
//        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @When("too short username {string} and valid password {string} with matching password confirmation {string} are entered")
    public void tooShortUsername(String username, String password, String passwordConfirmation) throws Throwable {
        createAccountWith(username, password, passwordConfirmation);
    } 
    
//    @Then("user is not created and error {string} is reported")
//    public void tooShortUserError() {
//        pageHasContent("username should have at least 3 characters");
//    }  
    
    @When("valid username {string} and too short password {string} with matching password confirmation {string} are entered")
    public void tooShortPassword(String username, String password, String passwordConfirmation) throws Throwable {
        createAccountWith(username, password, passwordConfirmation);
    } 
    
    @When("valid username {string} and valid password {string} are entered but password and password confirmation {string} do not match")
    public void pwdConfirmationNoMatch(String username, String password, String passwordConfirmation) throws Throwable {
        createAccountWith(username, password, passwordConfirmation);
    } 
    
    @Then("user is not created and error {string} is reported")
    public void invalidCredentialsError(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @Given("user with username {string} with password {string} is successfully created")
    public void userCreatedSuccessfully(String username, String password) throws Throwable {
        username = "lea";
        password = "salainen1";
        String passwordConfirmation = password;
        
        newIsSelected();
        createAccountWith(username, password, passwordConfirmation);
    } 
       
    @When("new user logs out and selects login")
    public void goToLogin() {
                
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
        loginIsSelected();
    }
    
    @When("user with username {string} and password {string} logs in")
    public void newUserLogsIn(String username, String password) throws Throwable {
        logInWith(username, password);
    }   
    
    @Then("the new user is logged in successfully")
    public void newUserIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void userCreationUnsuccessful(String username, String password) throws Throwable {
        username = "aa";
        password = "bad";
        String passwordConfirmation = password;
        
        newIsSelected();
        createAccountWith(username, password, passwordConfirmation);
    } 
       
    @When("user goes to login")
    public void goToLogin2() {
                
        WebElement element = driver.findElement(By.linkText("back to home"));
        element.click();
        loginIsSelected();
    }
    
    @When("user with username {string} and password {string} tries to log in")
    public void newUserTriesToLogIn(String username, String password) throws Throwable {
        logInWith(username, password);
    }   
    
    @Then("user cannot log in with inexisting account and error message is given")
    public void newUserNotLoggedIn() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
    
    private void createAccountWith(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    }
}
