package configuration;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProperties {
    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    public static EmulationConfig emulationConfig = ConfigFactory.create(EmulationConfig.class, System.getProperties());
}
