package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import helpers.Attach;


public class TestBase {
    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;

        String login = "user1";
        String password = "1234";
//        String url = "selenoid.autotests.cloud/wd/hub/";
        String url = System.getProperty("remoteUrl");


        String remoteWeb= String.format("https://%s:%s@%s", login, password, url);

        Configuration.remote = remoteWeb;
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}