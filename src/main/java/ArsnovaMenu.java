import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArsnovaMenu {
    static String menuIl = "//div[@class='menu']/ul/li[2]";

    public void chooseMenu(WebDriver driver, WebDriverWait wait) {
        if (Helper.isHide(By.xpath("//svg[@class='circular']"), 5, driver)) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(menuIl))).click();
        }
    }
}