import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaseMethods extends BaseTest{

    public MobileElement findAElement(By element) {
        return appiumDriver.findElement(element);
    }
    public List<MobileElement> findAllElements(By locator){
        return appiumDriver.findElements(locator);
    }
    public Boolean isDisplayed(By element) {
        return findAElement(element).isDisplayed();
    }
    public void clickToElement(By element){
        appiumDriver.findElement(element).click();
    }
    public void typeToElement(By element,String text){
        appiumDriver.findElement(element).sendKeys(text);
    }




    public void scrollDown(){
        Dimension dimension = appiumDriver.manage().window().getSize();

        Double scrollHeightStart = dimension.getHeight()*0.8;
        int scrollStart = scrollHeightStart.intValue();
        Double scrollHeightEnd = dimension.getHeight() * 0.2;
        int scrollEnd = scrollHeightEnd.intValue();

        new TouchAction((PerformsTouchActions) appiumDriver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    //  //androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[18]
    public void scrollTwiceToBottom(){

        for(int i=0;i<3;i++){//Sayfa 2 kez urunler yenilenene kadar scroll ediliyor
            for(int j=0;j<3;j++){//Dongu sonunda sayfa 3 kere kaydirilip 18 urun gecilmis ve sayfa yenilenmis oluyor.
                scrollDown();
            }
        }

    }



    public MobileElement getRandomProduct(){
        Random random = new Random();
        By productsLocator = By.id("com.ozdilek.ozdilekteyim:id/imageView");
        List<MobileElement> products = findAllElements(productsLocator);
        int listLimit = products.size()-1;
        int randomListIndex = random.nextInt(listLimit);
        MobileElement selectedProduct = products.get(randomListIndex);

        return selectedProduct;
    }
}
