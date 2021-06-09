package pl.edu.pwr.bgulowaty.hashing;

import java.security.SecureRandom;

public abstract class RandomSaltGenerator {

    public static String getRandomSalt(int length) {
        if (length < 0) throw new IllegalArgumentException("Length cannot be negative! Current length: " + length);
        SecureRandom random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) (random.nextInt((int) 'z' - (int) '0') + (int) '0'));
        }
        return stringBuilder.toString();
    }

}
