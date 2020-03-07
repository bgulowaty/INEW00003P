package pl.edu.pwr.bgulowaty.config;

import java.util.Map;
import java.util.regex.Pattern;
import pl.edu.pwr.bgulowaty.HashingAlgorithm;

public class AppConfig {

  private final HashingAlgorithm defaultAlgorithm;
  private final String salt;
  private final Pattern studentIndexPattern;

  AppConfig(Map<ConfigKey, String> configKeysByValues) {
    this.defaultAlgorithm = HashingAlgorithm.valueOf(
        configKeysByValues.get(ConfigKey.DEFAULT_ALGORITHM)
    );
    this.salt = configKeysByValues.get(ConfigKey.SALT);
    this.studentIndexPattern = Pattern.compile(configKeysByValues.get(ConfigKey.INDEX_PATTERN));
  }

  @Override
  public String toString() {
    return "HashingAppConfig{" +
        "defaultAlgorithm=" + defaultAlgorithm +
        ", salt='" + salt + '\'' +
        ", studentIndexPattern=" + studentIndexPattern +
        '}';
  }

  public String getSalt() {
    return salt;
  }

  public Pattern getStudentIndexPattern() {
    return studentIndexPattern;
  }

  public HashingAlgorithm getDefaultAlgorithm() {
    return defaultAlgorithm;
  }
}
