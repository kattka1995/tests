import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoanDetailsReceiving {
    String buttonNext = "//button[@type=\"button\"][contains(text(),'Продолжить')]";

    public void submitLoanDetailsReceiving(WebDriver driver, WebDriverWait wait) {
        if (Helper.isHide(By.xpath("//svg[@class='circular']"), 70000, driver)) {
            driver.findElement(By.xpath(buttonNext)).click();
        }
    }
}