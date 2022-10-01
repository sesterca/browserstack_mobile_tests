package configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:browserstack.properties"})
public interface BrowserstackConfig extends Config {

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

    @Key("host_url")
    String url();
}
