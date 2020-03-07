package pl.edu.pwr.bgulowaty.config;

import org.yaml.snakeyaml.Yaml;

public class ConfigModule {

    @SuppressWarnings("MethodMayBeStatic")
    public ConfigLoader yamlLoader() {
        return new SnakeYamlConfigLoader(new Yaml());
    }
}
