package pl.edu.pwr.bgulowaty.args;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pwr.bgulowaty.HashingAlgorithm;
import pl.edu.pwr.bgulowaty.StudentsIndex;

class ArgumentsParserTest {

  private ArgumentsParser underTest;

  private Pattern pwrPattern = Pattern.compile("[0-9]{6}");

  @BeforeEach
  void setUp() {
    underTest = new ArgumentsParser(pwrPattern, new HashingAlgorithmNameParser());
  }

  @Test
  void givenArgsLengthIsThree_throwsIllegalArgsException() {
    assertThatThrownBy(() -> underTest.parse("one two three"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void givenCorrectArgs_parsesCorrectly() {
    // given
    String givenIndex = "123456";
    String givenAlgorithm = "SHA384_COMMONS";

    // when
    AppArguments actual = underTest.parse(givenIndex, givenAlgorithm);

    // then
    assertThat(actual.getHashingAlgorithm())
        .isPresent()
        .contains(HashingAlgorithm.SHA384_COMMONS);

    assertThat(actual.getStudentsIndex()).isEqualTo(StudentsIndex.of(givenIndex));
  }
}
