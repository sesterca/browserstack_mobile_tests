package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import configuration.MobileConfig;
import drivers.BrowserstackMobileDriver;
import drivers.EmulationMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.sessionId;
import static io.qameta.allure.Allure.step;


public class BaseTests {

    @BeforeAll
    public static void setup(){
        System.getProperty("deviceHost", "emulation");

        if (Objects.equals("deviceHost", "browserstack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else {Configuration.browser = EmulationMobileDriver.class.getName();}

        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver(){
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void tearDown(){
        String sessionId = sessionId();

        Attach.screenshotAs("mobile_screenshot");
        Attach.pageSource();

        step("Close driver", Selenide::closeWebDriver);

        if (Objects.equals("deviceHost", "browserstack")) {Attach.video(sessionId);}
    }
}
