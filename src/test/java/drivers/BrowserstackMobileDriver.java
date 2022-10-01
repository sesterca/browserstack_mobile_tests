package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static configuration.ConfigProperties.browserstackConfig;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities){

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", browserstackConfig.browserStackUser());
        mutableCapabilities.setCapability("browserstack.key", browserstackConfig.browserStackKey());
        // Set URL of the application under test
        mutableCapabilities.setCapability("app", browserstackConfig.browserStackApp());
        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", browserstackConfig.device());
        mutableCapabilities.setCapability("os_version", browserstackConfig.os());
        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "browserstack_mobile");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "android test");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(browserstackConfig.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
