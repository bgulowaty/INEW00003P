package pl.edu.pwr.bgulowaty.hashing;

import java.security.SecureRandom;

public abstract class Salt {

    public static byte[] createSalt(){
      byte[] bytes = new byte[20];
      SecureRandom random = new SecureRandom();
      random.nextBytes(bytes);
      return bytes;
    }

}
