package pl.edu.pwr.bgulowaty.hashing;

import static pl.edu.pwr.bgulowaty.hashing.Salt.createSalt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import pl.edu.pwr.bgulowaty.StudentsIndex;

class ApacheCommonsCodecsSHA384 implements IndexHasher {

  @Override
  public StudentsIndex hash(StudentsIndex studentsIndex) throws NoSuchAlgorithmException {
    String index = studentsIndex.getIndex();

    /*I had to change almost everything*/
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-384");
    messageDigest.reset();

    /*salt*/

    byte[] bytes = createSalt();
    messageDigest.update(bytes);

    byte[] hash = messageDigest.digest(index.getBytes());

    return StudentsIndex.of(bytesToStringHex(hash));
  }

  private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

  public static String bytesToStringHex(byte[]bytes){
    char[] hexChars = new char[bytes.length * 2];
    for(int j = 0; j < bytes.length;j++){
      int v = bytes[j] & 0xFF;
      hexChars[j * 2] = hexArray[v >>> 4];
      hexChars[j * 2 + 1] = hexArray[v & 0x0F];
    }
    return new String(hexChars);
  }
}
