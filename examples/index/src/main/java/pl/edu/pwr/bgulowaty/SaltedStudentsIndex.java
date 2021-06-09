package pl.edu.pwr.bgulowaty;

import pl.edu.pwr.bgulowaty.hashing.RandomSaltGenerator;

public class SaltedStudentsIndex{

    StudentsIndex studentsIndex;

    public SaltedStudentsIndex(StudentsIndex index, String salt) {
        this.studentsIndex = StudentsIndex.of(salt + index.getIndex());
    }

    public SaltedStudentsIndex(StudentsIndex studentsIndex, int length) {
        this.studentsIndex = StudentsIndex.of(RandomSaltGenerator.getRandomSalt(length) + studentsIndex.getIndex());
    }

    public StudentsIndex getSaltedStudentIndex(){
        return this.studentsIndex;
    }
}
