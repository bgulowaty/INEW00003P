package pl.edu.pwr.bgulowaty;


import java.util.Objects;

public class StudentsIndex {

  private final String studentIndex;

  private StudentsIndex(String studentIndex) {
    this.studentIndex = studentIndex;
  }

  public static StudentsIndex of(String index) {
    return new StudentsIndex(index);
  }

  public String getIndex() {
    return studentIndex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudentsIndex that = (StudentsIndex) o;
    return Objects.equals(studentIndex, that.studentIndex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(studentIndex);
  }
}
