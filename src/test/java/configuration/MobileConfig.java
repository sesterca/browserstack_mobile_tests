package configuration;

import org.aeonbits.owner.Config;

public interface MobileConfig extends Config {

    @Key("device")
    @DefaultValue("Samsung Galaxy S10")
    String device();

    @Key("os_version")
    @DefaultValue("9.0")
    String os();
}
