import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletedDone {
    String finalText = "//div[@class=\"reason\"]";
    String finalTextFr = "Кредит выдан";

    public void purchaseComplete(WebDriver driver) {
        if (Helper.isHide(By.xpath("//svg[@class='circular']"),35000, driver)) {
            String finalTextEr = driver.findElement(By.xpath(finalText)).getText();
//            if (finalTextEr.equals(finalTextFr)) {
//                System.out.println("AT успешно завершен");
//            }
        }
    }
}

