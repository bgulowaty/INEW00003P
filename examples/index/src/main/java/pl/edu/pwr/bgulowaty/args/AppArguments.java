package pl.edu.pwr.bgulowaty.args;

import java.util.Optional;
import pl.edu.pwr.bgulowaty.HashingAlgorithm;
import pl.edu.pwr.bgulowaty.StudentsIndex;

public interface AppArguments {

  StudentsIndex getStudentsIndex();

  Optional<HashingAlgorithm> getHashingAlgorithm();
}
