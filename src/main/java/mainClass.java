import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mainClass {
    public static WebDriverWait wait;
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() {};
        wait = new WebDriverWait(driver, 15);
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
    }}


