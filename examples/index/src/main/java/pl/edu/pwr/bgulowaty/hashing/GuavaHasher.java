package pl.edu.pwr.bgulowaty.hashing;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import pl.edu.pwr.bgulowaty.StudentsIndex;

@SuppressWarnings("UnstableApiUsage")
abstract class GuavaHasher implements IndexHasher {

  private final Charset charset;

  protected GuavaHasher(Charset charset) {
    this.charset = charset;
  }

  protected abstract HashFunction getHashFunction();

  @Override
  public StudentsIndex hash(StudentsIndex studentsIndex) throws NoSuchAlgorithmException {
    String index = studentsIndex.getIndex();

    HashCode hashCode = getHashFunction().hashString(index, charset);

    return StudentsIndex.of(hashCode.toString().toUpperCase());
  }
}
