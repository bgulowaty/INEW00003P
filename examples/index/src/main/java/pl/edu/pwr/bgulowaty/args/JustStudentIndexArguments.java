package pl.edu.pwr.bgulowaty.args;

import java.util.Optional;
import pl.edu.pwr.bgulowaty.HashingAlgorithm;
import pl.edu.pwr.bgulowaty.StudentsIndex;

class JustStudentIndexArguments implements AppArguments {

  private final StudentsIndex studentsIndex;

  JustStudentIndexArguments(StudentsIndex studentsIndex) {
    this.studentsIndex = studentsIndex;
  }


  @Override
  public StudentsIndex getStudentsIndex() {
    return studentsIndex;
  }

  @Override
  public Optional<HashingAlgorithm> getHashingAlgorithm() {
    return Optional.empty();
  }
}
