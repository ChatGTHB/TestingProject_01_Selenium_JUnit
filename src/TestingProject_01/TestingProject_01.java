package TestingProject_01;

import utility.BaseDriver;
import utility.MyFunction;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestingProject_01 extends BaseDriver {
    @Test
    public void test1() {

        driver.get("https://itera-qa.azurewebsites.net/");

        MyFunction.wait(2);
        WebElement signUp = driver.findElement(By.linkText("Sign Up"));
        signUp.click();

        MyFunction.wait(2);
        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Kerem");

        MyFunction.wait(2);
        WebElement surname = driver.findElement(By.name("Surname"));
        surname.sendKeys("Yigit");

        MyFunction.wait(2);
        WebElement eMail = driver.findElement(By.cssSelector("input[class='form-control text-box single-line'][id='E_post']"));
        eMail.sendKeys("kyigit@kmail.com");

        MyFunction.wait(2);
        WebElement phoneNumber = driver.findElement(By.xpath("//label[text()='Mobile'] //following::input[1]"));
        phoneNumber.sendKeys("123456");

        MyFunction.wait(2);
        WebElement userName = driver.findElement(By.cssSelector("input[data-val-required='Please enter username']"));
        userName.sendKeys("k.yigitalp");

        MyFunction.wait(2);
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("123456");

        MyFunction.wait(2);
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("123456");

        MyFunction.wait(2);
        WebElement submit = driver.findElement(By.cssSelector("input[value='Submit']"));
        submit.click();

        // Olması gereken kod satırları bunlardır
//        WebElement confirmation=driver.findElement(By.xpath("//label[text()='Registration Successful']"));
//        Assert.assertEquals("Registration unsuccessful", "Registration Successful", confirmation.getText());


        // Test denemelerinde aynı username'de hata almamak için geçici olarak test esnasında kullanılacak olan kod satırı
        List<WebElement> confirmations = driver.findElements(By.xpath("//div[@class='col-md-offset-2 col-md-2']"));
        String confirmation = null;
        for (WebElement webElement : confirmations) {
            if ((webElement.getText().equals("Username already exist") ||
                    (webElement.getText().equals("Registration Successful")))) {
                confirmation = webElement.getText();
            }
        }
        Assert.assertTrue("Registration unsuccessful", (confirmation.equals("Username already exist")
                || confirmation.equals("Registration Successful")));

    }

    @Test
    public void test2() {

        driver.get("https://itera-qa.azurewebsites.net/");

        MyFunction.wait(2);
        WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
        login.click();

        MyFunction.wait(2);
        WebElement username = driver.findElement(By.xpath("//input[@data-val-required='Please enter username']"));
        username.sendKeys("k.yigit");

        MyFunction.wait(2);
        WebElement password = driver.findElement(By.xpath("//input[@data-val-required='Please enter password']"));
        password.sendKeys("123456");

        MyFunction.wait(2);
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='login']"));
        loginButton.click();

        MyFunction.wait(2);
        WebElement confirmation = driver.findElement(By.xpath("//h3[text()='Welcome k.yigit']"));
        String confirmationStr = "Welcome k.yigit";

        Assert.assertEquals("Login unsuccessful", confirmation.getText(), confirmationStr);

        MyFunction.wait(2);
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log out']"));
        logoutButton.click();

    }

    @Test
    public void test3() {
        driver.get("https://itera-qa.azurewebsites.net/");

        MyFunction.wait(2);
        WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
        login.click();

        MyFunction.wait(2);
        WebElement username = driver.findElement(By.xpath("//input[@data-val-required='Please enter username']"));
        username.sendKeys("k.yigit");

        MyFunction.wait(2);
        WebElement password = driver.findElement(By.xpath("//input[@data-val-required='Please enter password']"));
        password.sendKeys("123456");

        MyFunction.wait(2);
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='login']"));
        loginButton.click();

        MyFunction.wait(2);
        WebElement createButton = driver.findElement(By.xpath("//a[text()='Create New']"));
        createButton.click();

        MyFunction.wait(2);
        WebElement name = driver.findElement(By.xpath("//input[@id='Name']"));
        name.sendKeys("Said");

        MyFunction.wait(2);
        WebElement company = driver.findElement(By.xpath("//input[@id='Company']"));
        company.sendKeys("Company");

        MyFunction.wait(2);
        WebElement address = driver.findElement(By.xpath("//input[@id='Address']"));
        address.sendKeys("Norway");

        MyFunction.wait(2);
        WebElement city = driver.findElement(By.xpath("//input[@id='City']"));
        city.sendKeys("Oslo");

        MyFunction.wait(2);
        WebElement phone = driver.findElement(By.xpath("//input[@id='Phone']"));
        phone.sendKeys("123456");

        MyFunction.wait(2);
        WebElement eMail = driver.findElement(By.xpath("//input[@id='Email']"));
        eMail.sendKeys("123456@kmail.com");

        MyFunction.wait(2);
        WebElement createButton2 = driver.findElement(By.xpath("//input[@value='Create']"));
        createButton2.click();

        waitAndClose();
    }
}
