package Test;

import POM.LogInPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInPageTest extends BaseDriver {
  LogInPageElements logInPageElements;
  MyAccountPageElements myAccountPageElements;

  @Test(priority = 1,dataProvider = "LogInData")
  public void loginPositiveTest(String userName, String password){
    logInPageElements= new LogInPageElements(driver);
    myAccountPageElements= new MyAccountPageElements(driver);

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    logInPageElements.logIn.click();
    logInPageElements.inputEmail.sendKeys(userName);
    logInPageElements.inputPassword.sendKeys(password);
    logInPageElements.logInButton.click();

    String actualMessage= myAccountPageElements.welcomeMessage.getText();
    String expectedMessage="Welcome to our store";
    Assert.assertEquals(actualMessage,expectedMessage);
  }

  @Test(priority = 2,dataProvider = "LogInData2")
  public void loginNegativeTest2(String userName, String password) {
    logInPageElements= new LogInPageElements(driver);
    myAccountPageElements= new MyAccountPageElements(driver);

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    logInPageElements.logIn.click();
    logInPageElements.inputEmail.sendKeys(userName);
    logInPageElements.inputPassword.sendKeys(password);
    logInPageElements.logInButton.click();

    String actualError= logInPageElements.errorMessage.getText();
    String expectedError="Login was unsuccessful. Please correct the errors and try again.";
    Assert.assertEquals(actualError,expectedError);

  }
  @Test(priority = 3,dataProvider = "LogInData3")
  public void loginNegativeTest3(String userName, String password) {
    logInPageElements= new LogInPageElements(driver);
    myAccountPageElements= new MyAccountPageElements(driver);

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    logInPageElements.logIn.click();
    logInPageElements.inputEmail.sendKeys(userName);
    logInPageElements.inputPassword.sendKeys(password);
    logInPageElements.logInButton.click();

    String actualError= logInPageElements.errorMessage.getText();
    String expectedError="Login was unsuccessful. Please correct the errors and try again.";
    Assert.assertEquals(actualError,expectedError);

  }
  @Test(priority = 4,dataProvider = "LogInData4")
  public void loginNegativeTest4(String userName, String password) {
    logInPageElements= new LogInPageElements(driver);
    myAccountPageElements= new MyAccountPageElements(driver);

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    logInPageElements.logIn.click();
    logInPageElements.inputEmail.sendKeys(userName);
    logInPageElements.inputPassword.sendKeys(password);
    logInPageElements.logInButton.click();

    String actualError= logInPageElements.errorMessage.getText();
    String expectedError="Login was unsuccessful. Please correct the errors and try again.";
    Assert.assertEquals(actualError,expectedError);

  }
  @DataProvider(name = "LogInData") // Enter your correct email and correct password
  public Object [][] testDataProvider() {
    return new Object[][] { {"jacobyoldas@gmail.com","Yozgat-66"}};
  }
  @DataProvider(name = "LogInData2") // Enter your incorrect email and correct password
  public Object [][] testDataProvider2() {
    return new Object[][] { {"yasinyoldas66@gmail.com","Yozga-66"} };
  }
  @DataProvider(name = "LogInData3") // Enter your correct email and incorrect password
  public Object [][] testDataProvider3() {
    return new Object[][] { {"jacobyoldas@gmail.com","asdahiu2"} };
  }
  @DataProvider(name = "LogInData4") // Enter your incorrect email and incorrect password
  public Object [][] testDataProvider4() {
    return new Object[][]{{"yasinyoldas6@gmail.com", "asdsad"}};
  }
}
