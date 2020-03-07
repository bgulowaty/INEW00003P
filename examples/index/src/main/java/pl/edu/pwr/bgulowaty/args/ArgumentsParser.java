package pl.edu.pwr.bgulowaty.args;

import java.util.regex.Pattern;
import pl.edu.pwr.bgulowaty.HashingAlgorithm;
import pl.edu.pwr.bgulowaty.StudentsIndex;

public class ArgumentsParser {

  private final Pattern studentIndexPattern;
  private final HashingAlgorithmNameParser hashingAlgorithmNameParser;

  ArgumentsParser(
      Pattern studentIndexPattern,
      HashingAlgorithmNameParser hashingAlgorithmNameParser) {
    this.studentIndexPattern = studentIndexPattern;
    this.hashingAlgorithmNameParser = hashingAlgorithmNameParser;
  }

  public AppArguments parse(String... args) {
    int argumentsCount = args.length;

    if (isInvalid(argumentsCount)) {
      throw new IllegalArgumentException("Arguments should contain at least student's index");
    }

    String firstArgument = args[0];
    if (isNotStudentIndex(firstArgument)) {
      throw new IllegalArgumentException(
          "First argument (" + firstArgument + ") is not valid PWr index");
    }

    StudentsIndex studentsIndex = StudentsIndex.of(firstArgument);
    boolean onlyIndexPassed = argumentsCount == 1;
    if (onlyIndexPassed) {
      return new JustStudentIndexArguments(studentsIndex);
    }

    String secondArgument = args[1];
    HashingAlgorithm algorithm = hashingAlgorithmNameParser.parse(secondArgument);

    return new FullArguments(studentsIndex, algorithm);
  }

  private static boolean isInvalid(int argumentsCount) {
    return argumentsCount < 1 || argumentsCount > 2;
  }

  private boolean isNotStudentIndex(String firstArgument) {
    return !studentIndexPattern.matcher(firstArgument).matches();
  }
}
