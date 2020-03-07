package pl.edu.pwr.bgulowaty.hashing;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import java.nio.charset.Charset;

@SuppressWarnings("UnstableApiUsage")
class GuavaSHA256Hasher extends GuavaHasher implements IndexHasher {

  protected GuavaSHA256Hasher(Charset charset) {
    super(charset);
  }

  @Override
  protected HashFunction getHashFunction() {
    return Hashing.sha256();
  }
}
