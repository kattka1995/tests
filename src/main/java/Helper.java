import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class Helper {
    public static Boolean isHide(By element, WebDriver driver) {
        return isHide(element, 15000, driver);
    }

    public static Boolean isHide(By element, long loadTime, WebDriver driver) {
        Long time = System.currentTimeMillis() + loadTime;
        while (System.currentTimeMillis() < time && !isElementPresent(element, driver)) {
//            System.out.println(time);
        }
        return !isElementPresent(element, driver);
    }

    public static boolean isElementPresent(By by, WebDriver driver) {
        try {
            driver.findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static String findErrorText(String element, WebDriver driver) {
        String field = String.format("//cu-control-field[@label='%s']//div[@class=\"error ng-star-inserted\"]", element);
        String errorMessage = driver.findElement(By.xpath(field)).getText();
        return errorMessage;
    }

    public static int findErrorCount(WebDriver driver) {//Метод для поиска количества сообщений валидации
        return driver.findElements(By.xpath("//div[@class=\"error ng-star-inserted\"]")).size();
    }

    public static void clearField(String fieldName, String nextValue, WebDriver driver) {//Метод для очистки предыдущего значения и ввода нового
        String field = String.format("//cu-control-field[@label='%s']//input", fieldName);
        driver.findElement(By.xpath(field)).clear();
        driver.findElement(By.xpath(field)).sendKeys(nextValue);
    }

    public static void checkValidation(String fieldName, String Value, String nextValue, String errorText, WebDriver driver) {//Метод очищает предыдущее значение,
        // вводит некорректное значение, меняет фокус, ищет ошибки валидации и их количество, заполняет поле корректным значением
        Helper.clearField(fieldName, Value, driver);
        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();
        Assert.assertEquals(Helper.findErrorText(fieldName, driver), errorText);
        Assert.assertEquals(Helper.findErrorCount(driver), 1);
        Helper.clearField(fieldName, nextValue, driver);
    }

}
