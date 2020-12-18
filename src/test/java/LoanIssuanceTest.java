import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class LoanIssuanceTest {
    public static WebDriverWait wait;
    static WebDriver driver;
    private Logger logger;

    @BeforeMethod
    public void createWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() {
        };
        wait = new WebDriverWait(driver, 15);
    }

    @BeforeTest
    public void createLog() {
        logger = Logger.getLogger("new logger");
    }

//    @AfterMethod
//    public void closeWindow() {
//        driver.quit();
//    }

    @Test
    public void testIssueLoan() throws InterruptedException {
        driver.get("https://arsnova2-preprod.rencredit.ru/");
        new SignUpPageArsnova().signUp("tst_bell7517", "O4sGwur", driver);
        new ArsnovaMenu().chooseMenu(driver, wait);
        new SelectionTT().selectTT(driver, wait);
        new IdentificationForm().enterIdentification("новеньппкишзe", "мммм", "иванович",
                "11111991", "1111", "445549", "11112019", driver);
        new ShortFormAnketa().enterIdentification("111222", "орг", "москва",
                "C:/Users/Kitti/Desktop/CRB2016917622876956711000-YFGAs.jpg", "45555",
                "9203434334", "Ленина ш6", "23", "Ивановин",
                "Никита", "петрович", "1202233223", driver, wait);
        new ShortFormLoanDetails().enterGoodsInfo("комп", "компью", "45555", driver, wait);
        new ChooseLoanDetails().chooseLoan(driver, wait);
        new ShortFormLoanDetails().chooseFinalStep(driver);
        new LoanDetailsReceiving().submitLoanDetailsReceiving(driver, wait);
        new LoanDetailsReceivingPopUp().submitLoanDetailsReceivingPopUp(driver);
        new SignDocuments().submitLoanDetailsReceiving("C:/Users/Kitti/Desktop/CRB2016917622876956711000-YFGAs.jpg", driver);
        new DocumentsPrinted().changeTab(driver);
        new PurchaseCompleted().purchaseComplete(driver);
        new CompletedDone().purchaseComplete(driver);
        Helper.isHide(By.xpath("//svg[@class='circular']"), 35000, driver);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"reason\"]")).getText(), "Кредит выдан");
        logger.info("Выполнена проверка сценария выдачи кредита");
    }

    @Test
    public void testIndentificationForm() throws InterruptedException {
        driver.get("https://arsnova2-preprod.rencredit.ru/");
        new SignUpPageArsnova().signUp("tst_bell7517", "O4sGwur", driver);
        new ArsnovaMenu().chooseMenu(driver, wait);
        new SelectionTT().selectTT(driver, wait);
        IdentificationForm id = new IdentificationForm();
        id.enterIdentificationValidation("е е", "мммм", "иванович",
                "11111991", "1111", "445549", "11112019", driver);
        Assert.assertEquals(Helper.findErrorCount(driver), 0);
        Helper.checkValidation("Фамилия", "Иван  нов", "Иванов", "Некорректное значение", driver);
        Helper.checkValidation("Имя", "Ол  ег", "Олег", "Некорректное значение", driver);
        Helper.checkValidation("Отчество", "Петр --ович", "Петрович", "Некорректное значение", driver);
        Helper.checkValidation("Дата рождения", "1", "11111995", "Неполное значение", driver);
        Helper.checkValidation("Серия паспорта", "111", "1111", "Неполное значение", driver);
        Helper.checkValidation("Номер паспорта", "1", "444445", "Неполное значение", driver);
        Helper.checkValidation("Дата выдачи паспорта", "1", "11112020", "Неполное значение", driver);
        logger.info("Выполнена проверка валидации для формы идентификации клиента");
    }

    @Test
    public void testAuthorizationForm() {
        driver.get("https://arsnova2-preprod.rencredit.ru/");
        new SignUpPageArsnova().signUp("tst_bell7517", "O4sGwur", driver);
        if (Helper.isHide(By.xpath("//svg[@class='circular']"), 1000, driver)) {
            Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Новая заявка на потребительский кредит')]")).isDisplayed(), true);
            logger.info("Выполнена проверка сценария авторизации");
        }
    }
}


