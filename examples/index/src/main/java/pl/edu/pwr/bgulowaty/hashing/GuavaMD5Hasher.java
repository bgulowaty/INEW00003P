package pl.edu.pwr.bgulowaty.hashing;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import java.nio.charset.Charset;

@SuppressWarnings("UnstableApiUsage")
class GuavaMD5Hasher extends GuavaHasher implements IndexHasher {

  GuavaMD5Hasher(Charset charset) {
    super(charset);
  }

  // MD5 is not safe and this method is marked as @deprecated
  // https://security.stackexchange.com/questions/211/how-to-securely-hash-passwords/31846#31846
  // Code here is just for sake of demonstration
  @SuppressWarnings("deprecation")
  @Override
  protected HashFunction getHashFunction() {
    return Hashing.md5();
  }
}
