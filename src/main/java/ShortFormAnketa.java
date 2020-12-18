import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShortFormAnketa {
    String gender = "//button[@type=\"button\"][contains(text(),'Мужской')]";
    String subdivisionCode = "//input[@fieldname='subdivisionCode']";
    String issuedBy = "//textarea[@fieldname='issuedBy']";
    String birthPlace = "//textarea[@fieldname='birthPlace']";
    String scanDownload = "//input[@type=\"file\"]";
    String monthlyIncome = "//cu-price-input[@fieldname='monthlyIncome']/input";
    String contactValue = "//input[1][@fieldname='contactValue']";
    String addressFull = "//input[@data-name=\"addressFull\"]";
    String adressFullInput = "//div[@class=\"ps-content\"]/a[1]";
    String house = " //input[@data-name=\"house\"]";
    String addressFlag = "//cu-radio-buttons[@fieldname=\"identicalAddresses\"]//button[@type=\"button\"][contains(text(),'Да')]";
    String tab = "//*[@role='tab']";
    String lastNameContactPerson1 = "//input[@fieldname=\"lastName\"]";
    String firstNameContactPerson1 = "//input[@fieldname=\"firstName\"]";
    String patronymicContactPerson1 = "//input[@fieldname=\"patronymic\"]";
    String contactTypeClick = "//cu-select[@fieldname=\"contactType\"]/input[@autocomplete=\"new-password\"]";
    String contactTypeParam = "//*[@class='ng-star-inserted']";
    String contactValueCl = "//input[@fieldname='contactValue']";

    public void enterIdentification(String subdivisionCodeValue, String issuedByValue, String birthPlaceValue, String photo,
                                    String monthlyIncomeValue, String contactValueValue,
                                    String addressFullValue, String houseValue, String lastNameContactPerson1Value,
                                    String firstNameContactPerson1Value,
                                    String patronymicContactPerson1Value, String contactValueClValue,
                                    WebDriver driver, WebDriverWait wait) {
        if (Helper.isHide(By.xpath("//svg[@class='circular']"), 35000,driver)) {
            driver.findElement(By.xpath(gender)).click();
            driver.findElement(By.xpath(subdivisionCode)).sendKeys(subdivisionCodeValue);
            driver.findElement(By.xpath(issuedBy)).sendKeys(issuedByValue);
            driver.findElement(By.xpath(birthPlace)).sendKeys(birthPlaceValue);
            driver.findElement(By.xpath(monthlyIncome)).sendKeys(monthlyIncomeValue);
            driver.findElement(By.xpath(contactValue)).sendKeys(contactValueValue);
            driver.findElements(By.xpath(tab)).get(4).click();
            driver.findElement(By.xpath(addressFull)).sendKeys(addressFullValue);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(adressFullInput))).click();
            driver.findElement(By.xpath(house)).sendKeys(houseValue);
            driver.findElement(By.xpath(addressFlag)).click();
            driver.findElements(By.xpath(tab)).get(5).click();
            driver.findElements(By.xpath(lastNameContactPerson1)).get(1).sendKeys(lastNameContactPerson1Value);
            driver.findElements(By.xpath(firstNameContactPerson1)).get(1).sendKeys(firstNameContactPerson1Value);
            driver.findElements(By.xpath(patronymicContactPerson1)).get(1).sendKeys(patronymicContactPerson1Value);
            driver.findElement(By.xpath(contactTypeClick)).click();
            driver.findElements(By.xpath(contactTypeParam)).get(28).click();
            driver.findElements(By.xpath(contactValueCl)).get(2).sendKeys(contactValueClValue);
        }
    }
}

