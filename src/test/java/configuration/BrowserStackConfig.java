package configuration;

import org.aeonbits.owner.Config;

@Config.Sources("credentials.properties")
public interface BrowserStackConfig extends Config {
    @Key("user")
    String browserStackUser();

    @Key("key")
    String browserStackKey();

    @Key("app")
    String browserStackApp();
}
