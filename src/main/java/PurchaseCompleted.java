import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseCompleted {
    String buttonNextStep = "//button[@type=\"button\"][contains(text(),'Продолжить')]";

    public void purchaseComplete(WebDriver driver) {
        if (Helper.isHide(By.xpath("//svg[@class='circular']"), 10000,driver)) {
            driver.findElement(By.xpath(buttonNextStep)).click();
        }
    }
}

