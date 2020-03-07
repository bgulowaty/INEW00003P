package pl.edu.pwr.bgulowaty.config;

import java.io.File;

public interface ConfigLoader {

  AppConfig load(File file);
}
