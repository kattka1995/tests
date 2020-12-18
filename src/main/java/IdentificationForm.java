import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IdentificationForm {
    static String lastName = "//input[@fieldname='lastName']";
    static String firstName = "//input[@fieldname='firstName']";
    static String patronymic = "//input[@fieldname='patronymic']";
    static String birthDate = "//cu-date-input[@fieldname='birthDate']/input";
    static String documentSerialNumber = "//input[@fieldname='documentSerialNumber']";
    static String documentNumber = "//input[@fieldname='documentNumber']";
    static String issueDate = "//cu-date-input[@fieldname='issueDate']/input";
    static String submitButton = "//div[@class='clearfix']/button";

    public void enterIdentification(String lastNameValue, String firstNameValue, String patronymicValue, String birthDateValue,
                                    String documentSerialNumberValue,String documentNumberValue, String issueDateValue, WebDriver driver) {
        if (Helper.isHide(By.xpath("//svg[@class='circular']"), 35000, driver)) {
            driver.findElement(By.xpath(lastName)).sendKeys(lastNameValue);
            driver.findElement(By.xpath(firstName)).sendKeys(firstNameValue);
            driver.findElement(By.xpath(patronymic)).sendKeys(patronymicValue);
            driver.findElement(By.xpath(birthDate)).sendKeys(birthDateValue);
            driver.findElement(By.xpath(documentSerialNumber)).sendKeys(documentSerialNumberValue);
            driver.findElement(By.xpath(documentNumber)).sendKeys(documentNumberValue);
            driver.findElement(By.xpath(issueDate)).sendKeys(issueDateValue);
            driver.findElement(By.xpath(submitButton)).click();
        }
    }
    public void enterIdentificationValidation(String lastNameValue, String firstNameValue, String patronymicValue, String birthDateValue,
                                    String documentSerialNumberValue,String documentNumberValue, String issueDateValue, WebDriver driver) {
        if (Helper.isHide(By.xpath("//svg[@class='circular']"), 35000, driver)) {
            driver.findElement(By.xpath(lastName)).sendKeys(lastNameValue);
            driver.findElement(By.xpath(firstName)).sendKeys(firstNameValue);
            driver.findElement(By.xpath(patronymic)).sendKeys(patronymicValue);
            driver.findElement(By.xpath(birthDate)).sendKeys(birthDateValue);
            driver.findElement(By.xpath(documentSerialNumber)).sendKeys(documentSerialNumberValue);
            driver.findElement(By.xpath(documentNumber)).sendKeys(documentNumberValue);
            driver.findElement(By.xpath(issueDate)).sendKeys(issueDateValue);
        }
    }
}