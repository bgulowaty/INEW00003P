package pl.edu.pwr.bgulowaty.hashing;

import java.util.Map;
import java.util.Optional;
import pl.edu.pwr.bgulowaty.HashingAlgorithm;

class MapBasedHashersProvider implements HashersProvider {

  private final Map<HashingAlgorithm, IndexHasher> hasherByAlgorithm;

  MapBasedHashersProvider(
      Map<HashingAlgorithm, IndexHasher> hasherByAlgorithmName) {
    this.hasherByAlgorithm = hasherByAlgorithmName;
  }

  @Override
  public Optional<IndexHasher> findByAlgorithm(
      HashingAlgorithm hashingAlgorithm) {
    return Optional.ofNullable(hasherByAlgorithm.get(hashingAlgorithm));
  }
}
