package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentional.properties"})
public interface CredentionalConfig extends Config {
        String login();
        String password();
}
