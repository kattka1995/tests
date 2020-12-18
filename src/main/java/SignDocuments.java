import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignDocuments {
    String signTypeSobst = "//button[contains(text(),'Собственноручная подпись')]";
    String scanDownload = "//input[@type=\"file\"]";
    String buttonPrint = "//button[@placement=\"top\"]";
    String buttonNext = "//button[contains(text(),'Продолжить')]";

    public void submitLoanDetailsReceiving(String photo, WebDriver driver) {
        if (Helper.isHide(By.xpath("//svg[@class='circular']"), 70000, driver)) {
            driver.findElements(By.xpath(scanDownload)).get(0).sendKeys(photo);
            driver.findElements(By.xpath(scanDownload)).get(1).sendKeys(photo);
            driver.findElements(By.xpath(scanDownload)).get(2).sendKeys(photo);
            driver.findElement(By.xpath(buttonPrint)).click();
            DocumentsPrinted.changeTab(driver);
            driver.findElement((By.xpath(buttonNext))).click();
        }
    }
}