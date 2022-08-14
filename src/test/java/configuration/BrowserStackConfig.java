package configuration;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:credentials.properties"})
public interface BrowserStackConfig extends Config {
    @Key("user")
    String browserStackUser();

    @Key("key")
    String browserStackKey();

    @Key("app")
    String browserStackApp();

    @Key("device")
    String device();

    @Key("os_version")
    String os();

    @Key("browserstack_url")
    String url();
}
