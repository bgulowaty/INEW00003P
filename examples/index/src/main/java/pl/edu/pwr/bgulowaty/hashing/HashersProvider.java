package pl.edu.pwr.bgulowaty.hashing;

import java.util.Optional;
import pl.edu.pwr.bgulowaty.HashingAlgorithm;

public interface HashersProvider {

  Optional<IndexHasher> findByAlgorithm(HashingAlgorithm hashingAlgorithm);
}
