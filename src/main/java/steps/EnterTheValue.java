package steps;

import configuration.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CertificateObject;

public class EnterTheValue extends BaseClass {
    static {
        if (driver == null) {
            BaseClass.createWebDriver();
        }
    }

    CertificateObject certificateObject = new CertificateObject(driver);

    @Before
    public void opencerPage() {
        driver.navigate().to("https://certificate.ithillel.ua/");
    }

    @When("I send certificate number {string}")
    public void iSendCertificateNumber(String cerNumber) {
        certificateObject.sendNumber(cerNumber);
    }


    @Then("Verification  certificate {string}")
    public void verificationCertificate(String expected) throws Exception {
        Assert.assertEquals(Boolean.valueOf(expected), certificateObject.checkcertifChekForm());
    }
}
