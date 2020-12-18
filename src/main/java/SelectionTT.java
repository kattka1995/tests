import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectionTT {
    static String tradePointCode = "//ul[@id='tradePointDropdown']//span[contains(text(),'909205501')]";
    static String submitButton = "//div[@class='modal-footer control-field-after']/button[contains(text(),'Продолжить')][not (@disabled)]";

    public void selectTT(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tradePointCode))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(submitButton))).click();
    }
}

