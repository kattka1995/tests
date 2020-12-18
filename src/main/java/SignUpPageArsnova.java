import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPageArsnova {
    static String login = "//input[@id='username']";
    static String password = "//input[@id='password']";
    static String submitButton = "//input[@id='kc-login']";

    public void signUp(String textLogin, String testPassword, WebDriver driver) {
        driver.findElement(By.xpath(login)).sendKeys(textLogin);
        driver.findElement(By.xpath(password)).sendKeys(testPassword);
        driver.findElement(By.xpath(submitButton)).click();
    }
}
