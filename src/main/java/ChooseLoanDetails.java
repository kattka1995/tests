import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseLoanDetails {
    String buttonChooseLoan = "//table[@class=\"products\"]//tr[3]/td[1]";
    String button = "//button[@type=\"button\"][contains(text(),'Выбрать продукт')]";

    public void chooseLoan(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        if (Helper.isHide(By.xpath("//svg[@class='circular']"), 20000,driver)) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonChooseLoan)));
            driver.findElement(By.xpath(buttonChooseLoan)).click();
            driver.findElement(By.xpath(button)).click();
        }
    }
}

