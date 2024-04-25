package org.example.repository.studentTerm;

import org.example.base.repository.BaseRepository;
import org.example.model.Lesson;
import org.example.model.Student;
import org.example.model.StudentTerm;
import org.example.model.Term;

public interface StudentTermRepository extends BaseRepository<StudentTerm, Long> {
    StudentTerm findStudentInTerm(Student student , Term term);
    StudentTerm findStudentLastTerm(Student student);

}
