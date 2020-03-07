package pl.edu.pwr.bgulowaty.config;

import java.util.stream.Stream;

enum ConfigKey {

  DEFAULT_ALGORITHM("defaultAlgorithm"),
  INDEX_PATTERN("studentIndexPattern"),
  SALT("salt");

  private final String mapping;

  ConfigKey(String mapping) {
    this.mapping = mapping;
  }

  static ConfigKey getByMapping(String mapping) {
    return Stream.of(ConfigKey.values())
        .filter(configKey -> configKey.getMapping().equals(mapping))
        .findAny()
        .orElseThrow(
            () -> new IllegalArgumentException("Mapping for " + mapping + " not supported.")
        );
  }

  String getMapping() {
    return mapping;
  }
}
