package pl.edu.pwr.bgulowaty;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import pl.edu.pwr.bgulowaty.args.AppArguments;
import pl.edu.pwr.bgulowaty.args.ArgumentsParser;
import pl.edu.pwr.bgulowaty.args.ArgumentsParsingModule;
import pl.edu.pwr.bgulowaty.config.AppConfig;
import pl.edu.pwr.bgulowaty.config.ConfigLoader;
import pl.edu.pwr.bgulowaty.config.ConfigModule;
import pl.edu.pwr.bgulowaty.hashing.HashersProvider;
import pl.edu.pwr.bgulowaty.hashing.HashingModule;
import pl.edu.pwr.bgulowaty.hashing.IndexHasher;

public class IndexHashingApplication {

  private static final String CONFIG_FILE_PATH = "conf/hasherAppConfig.yaml";

  public static void main(String... rawArgs) {
    AppConfig config = loadAppConfig(getConfigFile());
    AppArguments arguments = createArgsParser(config).parse(rawArgs);
    HashersProvider hashersProvider = createHashersProvider();

    HashingAlgorithm hashingAlgorithm = resolveAlgorithm(config, arguments);
    IndexHasher hasher = getHasher(hashersProvider, hashingAlgorithm);
    try {
      hashAndPrintToSystemOut(arguments.getStudentsIndex(), hasher);
    }catch(NoSuchAlgorithmException e){
      System.out.println(e.toString());
    }
  }

  private static IndexHasher getHasher(
      HashersProvider hashersProvider, HashingAlgorithm hashingAlgorithm) {

    return hashersProvider.findByAlgorithm(hashingAlgorithm)
        .orElseThrow(() -> new HashingAlgorithmNotAvailableException(hashingAlgorithm));
  }

  private static HashingAlgorithm resolveAlgorithm(AppConfig config, AppArguments appArguments) {
    Optional<HashingAlgorithm> hashingAlgorithmInArgs = appArguments.getHashingAlgorithm();

    return hashingAlgorithmInArgs.orElseGet(config::getDefaultAlgorithm);
  }

  private static File getConfigFile() {
    return new File(CONFIG_FILE_PATH);
  }

  private static HashersProvider createHashersProvider() {
    return new HashingModule().hashersProvider();
  }

  private static void hashAndPrintToSystemOut(StudentsIndex index, IndexHasher hasher) throws NoSuchAlgorithmException {
    System.out.println(hasher.hash(index).getIndex());
  }

  private static AppConfig loadAppConfig(File file) {
    ConfigLoader configLoader = new ConfigModule().yamlLoader();
    return configLoader.load(file);
  }

  private static ArgumentsParser createArgsParser(AppConfig config) {
    return new ArgumentsParsingModule().argumentsParser(config);
  }
}
