package pl.edu.pwr.bgulowaty.hashing;

import java.nio.charset.Charset;
import java.util.Map;
import pl.edu.pwr.bgulowaty.HashingAlgorithm;

public class HashingModule {

    @SuppressWarnings("MethodMayBeStatic")
    public HashersProvider hashersProvider() {
        Charset charset = Charset.defaultCharset();
        Map<HashingAlgorithm, IndexHasher> availableHashers = Map.of(
                HashingAlgorithm.MD5_GUAVA, new GuavaMD5Hasher(charset),
                HashingAlgorithm.SHA256_GUAVA, new GuavaSHA256Hasher(charset),
                HashingAlgorithm.SHA384_COMMONS, new ApacheCommonsCodecsSHA384()
        );

        return new MapBasedHashersProvider(availableHashers);
    }
}
