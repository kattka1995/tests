import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoanDetailsReceivingPopUp {
    String buttonPopup = "//div[@class=\"modal-dialog\"]//button[@type=\"button\"][contains(text(),'Продолжить')]";

    public void submitLoanDetailsReceivingPopUp(WebDriver driver)  {
        if (Helper.isHide(By.xpath("//svg[@class='circular']"),1000, driver)) {
            driver.findElement(By.xpath(buttonPopup)).click();
        }
    }
}