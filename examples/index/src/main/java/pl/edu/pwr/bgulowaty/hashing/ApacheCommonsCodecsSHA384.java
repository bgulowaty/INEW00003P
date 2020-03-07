package pl.edu.pwr.bgulowaty.hashing;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import pl.edu.pwr.bgulowaty.StudentsIndex;

class ApacheCommonsCodecsSHA384 implements IndexHasher {

  @Override
  public StudentsIndex hash(StudentsIndex studentsIndex) {
    String index = studentsIndex.getIndex();

    DigestUtils utils = new DigestUtils(MessageDigestAlgorithms.SHA_384);

    return StudentsIndex.of(utils.digestAsHex(index));
  }
}
