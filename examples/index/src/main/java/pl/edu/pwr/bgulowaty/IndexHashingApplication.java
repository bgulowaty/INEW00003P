package pl.edu.pwr.bgulowaty;

import pl.edu.pwr.bgulowaty.args.AppArguments;
import pl.edu.pwr.bgulowaty.args.ArgumentsParser;
import pl.edu.pwr.bgulowaty.args.ArgumentsParsingModule;
import pl.edu.pwr.bgulowaty.config.AppConfig;
import pl.edu.pwr.bgulowaty.config.ConfigLoader;
import pl.edu.pwr.bgulowaty.config.ConfigModule;
import pl.edu.pwr.bgulowaty.hashing.HashersProvider;
import pl.edu.pwr.bgulowaty.hashing.HashingModule;
import pl.edu.pwr.bgulowaty.hashing.IndexHasher;

import java.io.File;
import java.util.Optional;

public class IndexHashingApplication {

    private static final String CONFIG_FILE_PATH = "conf\\hasherAppConfig.yaml";

    public static void main(String... rawArgs) {
        AppConfig config = loadAppConfig(getConfigFile());
        String salt = config.getSalt();
        AppArguments arguments = createArgsParser(config).parse(rawArgs);
        HashersProvider hashersProvider = createHashersProvider();

    HashingAlgorithm hashingAlgorithm = resolveAlgorithm(config, arguments);
    IndexHasher hasher = getHasher(hashersProvider, hashingAlgorithm);

        hashAndPrintToSystemOut(arguments.getStudentsIndex(), hasher, salt);
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

    private static void hashAndPrintToSystemOut(StudentsIndex index, IndexHasher hasher, String salt) {
        SaltedStudentsIndex saltedIndex = new SaltedStudentsIndex(index, salt);
        System.out.println(hasher.hash(saltedIndex.getSaltedStudentIndex()).getIndex());
    }

  private static AppConfig loadAppConfig(File file) {
    ConfigLoader configLoader = new ConfigModule().yamlLoader();
    return configLoader.load(file);
  }

  private static ArgumentsParser createArgsParser(AppConfig config) {
    return new ArgumentsParsingModule().argumentsParser(config);
  }
}
