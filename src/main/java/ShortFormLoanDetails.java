import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShortFormLoanDetails {
    String tab = "//*[@role='tab']";
    String name = "//*[@fieldname=\"name\"]";
    String goodName = "//*[@typeaheadoptionfield=\"searchField\"]";
    String goodNameChoose = "//*[@class=\"ps-content\"]//div[1]";
    String resultCost = "//*[@fieldname=\"resultCost\"]/input";
    String button = "//*[@type=\"button\"][contains(text(),' Выбрать кредитный продукт')]";
    String buttonNextStep = "//button[@type=\"button\"][contains(text(),'Отправить на рассмотрение')]";

    public void enterGoodsInfo(String nameValue, String goodNameValue, String resultCostValue, WebDriver driver, WebDriverWait wait) {
        if (Helper.isHide(By.xpath("//svg[@class='circular']"),1000, driver)) {
            driver.findElements(By.xpath(tab)).get(1).click();
            driver.findElement(By.xpath(name)).sendKeys(nameValue);
            driver.findElement(By.xpath(goodName)).sendKeys(goodNameValue);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(goodNameChoose))).click();
            driver.findElement(By.xpath(resultCost)).sendKeys(resultCostValue);
            driver.findElement(By.xpath(button)).click();
        }
    }

    public void chooseFinalStep(WebDriver driver) {
        if (Helper.isHide(By.xpath("//svg[@class='circular']"),1000, driver)) {
            driver.findElement(By.xpath(buttonNextStep)).click();
        }
    }
}



