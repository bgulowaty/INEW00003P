package pl.edu.pwr.bgulowaty.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.yaml.snakeyaml.Yaml;

class SnakeYamlConfigLoader implements ConfigLoader {

  private final Yaml yaml;

  public SnakeYamlConfigLoader(Yaml yaml) {
    this.yaml = yaml;
  }

  private static Map<ConfigKey, String> mapToConfigKeys(Map<String, String> loadedConfig) {
    return loadedConfig.entrySet()
            .stream()
            .collect(
                    Collectors
                            .toMap(entry -> ConfigKey.getByMapping(entry.getKey()), Entry::getValue)
            );
  }

  private static InputStream asInputStream(File file) {
    try {
      return new FileInputStream(file);
    } catch (FileNotFoundException e) {
      throw new CouldNotLoadConfigException(e);
    }
  }

  @Override
  public AppConfig load(File file) {
    InputStream inputStream = asInputStream(file);

    Map<String, String> loadedConfig = parseConfigFile(inputStream);
    Map<ConfigKey, String> configValuesByKeys = mapToConfigKeys(loadedConfig);

    return tryParsingAppConfig(configValuesByKeys);
  }

  private static AppConfig tryParsingAppConfig(Map<ConfigKey, String> configValuesByKeys) {
    try {
      return new AppConfig(configValuesByKeys);
    } catch (IllegalArgumentException e) {
      throw new CouldNotLoadConfigException(e);
    }
  }

  // Its ugly, don't normally do this
  @SuppressWarnings("unchecked")
  private Map<String, String> parseConfigFile(InputStream inputStream) {
    return (Map<String, String>) yaml.load(inputStream);
  }

  public static class CouldNotLoadConfigException extends RuntimeException {

    private static final long serialVersionUID = 5593950259706391035L;

    CouldNotLoadConfigException(Throwable cause) {
      super(cause);
    }
  }
}
