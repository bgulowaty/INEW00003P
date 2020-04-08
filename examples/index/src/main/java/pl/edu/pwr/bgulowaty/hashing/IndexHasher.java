package pl.edu.pwr.bgulowaty.hashing;

import java.security.NoSuchAlgorithmException;
import pl.edu.pwr.bgulowaty.StudentsIndex;

public interface IndexHasher {

  StudentsIndex hash(StudentsIndex index) throws NoSuchAlgorithmException;
}
