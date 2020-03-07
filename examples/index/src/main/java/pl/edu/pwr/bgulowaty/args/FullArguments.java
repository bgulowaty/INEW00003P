package pl.edu.pwr.bgulowaty.args;

import java.util.Optional;
import pl.edu.pwr.bgulowaty.HashingAlgorithm;
import pl.edu.pwr.bgulowaty.StudentsIndex;

class FullArguments implements AppArguments {

  private final StudentsIndex studentsIndex;
  private final HashingAlgorithm hashingAlgorithm;

  FullArguments(
      StudentsIndex studentsIndex, HashingAlgorithm hashingAlgorithm) {
    this.studentsIndex = studentsIndex;
    this.hashingAlgorithm = hashingAlgorithm;
  }

  @Override
  public StudentsIndex getStudentsIndex() {
    return studentsIndex;
  }

  @Override
  public Optional<HashingAlgorithm> getHashingAlgorithm() {
    return Optional.of(hashingAlgorithm);
  }
}
