package configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:emulation.properties"})
public interface EmulationConfig extends Config {

    @Key("device")
    String device();

    @Key("os_version")
    String os();

    @Key("host_url")
    String url();
}
