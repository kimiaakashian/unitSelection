package org.example.repository.student;

import org.example.base.repository.BaseRepository;
import org.example.model.Lesson;
import org.example.model.Student;
import org.example.model.StudentTermUnit;

import java.util.List;

public interface StudentRepository extends BaseRepository<Student, Long> {
    Student findStudentByUserId(Long userId);
    List<StudentTermUnit> findLessonsByStudentId(Long studentCode);

    List<Student> findAll();


}
