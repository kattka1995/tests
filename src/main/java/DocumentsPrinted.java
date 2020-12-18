import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class DocumentsPrinted {

    public static void changeTab(WebDriver driver) {

        if (Helper.isHide(By.xpath("//svg[@class='circular']"),1000, driver)) {
            ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window((String) tabs2.get(0));
        }
    }
}