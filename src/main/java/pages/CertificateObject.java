package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CertificateObject {
    @FindBy(name="certificate")
    WebElement searchField;
    WebDriver driver;
    @FindBy(id = "certificateCheckForm")
    WebElement checkFormMassage;

    public CertificateObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this );
    }

    public void sendNumber(String number){
        searchField.sendKeys(number);
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean checkLinkCertificate(){
        return driver.getCurrentUrl().contains("view");
    }
    public boolean checkcertifChekForm() throws Exception {
        System.out.println(checkFormMassage.getAttribute("class"));

        int i = 0;
        boolean result=false;
        while (true) {
            if (checkLinkCertificate()) {
                result = true;
                break;
            }
            if (checkFormMassage.getAttribute("class").contains("invalid")) {
                result = false;
                break;
            }

            try {
                Thread.sleep(1000);
                i++;
                if (i > 10) {
                    throw new Exception("Out of time wait certificate cheker");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
