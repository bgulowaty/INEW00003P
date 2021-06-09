package pl.edu.pwr.bgulowaty.hashing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RandomSaltGeneratorTest {

    @Test
    void getRandomSaltPositiveInputTest() {
        int length = 10;
        assertEquals(RandomSaltGenerator.getRandomSalt(length).length(), length);
    }

    @Test
    void getRandomSaltThrowsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, ()->RandomSaltGenerator.getRandomSalt(-1));
    }

}
