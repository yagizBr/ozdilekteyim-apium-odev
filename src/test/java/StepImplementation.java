import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StepImplementation extends BaseMethods {

    @Step("<second> saniye bekle")
    public void waitStatic(int second) throws InterruptedException {
        Thread.sleep(second*1000);
    }

    @Step("<element> elementi görünür olana kadar bekle")
    public void waitUntilLoad(String element) {
        By locator = By.id(element);
        WebDriverWait wait = new WebDriverWait(appiumDriver,10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    @Step("<elementId> id'li element sayfada mı kontrol edilir")
    public void isOnThePageWithId(String elementId){
        By mobileElement = By.id(elementId);
        Assertions.assertTrue(isDisplayed(mobileElement), elementId+" Elementi sayfada görüntülendi.");

    }

    @Step("<elementXpath> xpath'li element sayfada mi kontrol edilir")
    public void isOnThePageWithXpath(String elementPath){
        By mobileElement = By.xpath(elementPath);
        Assertions.assertTrue(isDisplayed(mobileElement), elementPath+" Elementi sayfada görüntülendi.");
    }

    @Step("<button> id'li elemente tıkla")
    public void clickElementId(String elementId){
        By locator = By.id(elementId);
        clickToElement(locator);
        Logger.info(elementId + " elementi tıklandı");
    }

    @Step("<button> xpath'li elemente tıkla")
    public void clickElementXpath(String elementPath){
        By locator = By.xpath(elementPath);
        clickToElement(locator);
        Logger.info(elementPath + " elementi tıklandı");
    }

    @Step("sayfayı scroll et")
    public void scrollPage(){
        scrollTwiceToBottom();
        Logger.info("Sayfa iki kez scroll yaptı");
    }

    @Step("Rastgele bir ürün seç")
    public void randomProduct(){
        getRandomProduct().click();
        Logger.info("Rastgele ürün seçildi.");
    }

    @Step("<inputElement> id'li elemente <stringData> stringini yaz")
    public void dataEntryToInputField(String inputElement,String data){
        By locator = By.id(inputElement);
        typeToElement(locator,data);
        Logger.info(inputElement+" alanına "+data+" değeri girildi");
    }


}
