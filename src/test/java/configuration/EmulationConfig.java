package configuration;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:emulation.properties"})
public interface EmulationConfig extends Config {

    String device();

    @Key("os_version")
    String os();

    @Key("host_url")
    String url();
}
