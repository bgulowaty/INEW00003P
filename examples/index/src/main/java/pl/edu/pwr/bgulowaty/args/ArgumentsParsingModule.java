package pl.edu.pwr.bgulowaty.args;

import pl.edu.pwr.bgulowaty.config.AppConfig;

public class ArgumentsParsingModule {

    @SuppressWarnings("MethodMayBeStatic")
    public ArgumentsParser argumentsParser(AppConfig appConfig) {
        HashingAlgorithmNameParser hashingAlgorithmNameParser = new HashingAlgorithmNameParser();

        return new ArgumentsParser(
                appConfig.getStudentIndexPattern(),
                hashingAlgorithmNameParser);
    }
}
