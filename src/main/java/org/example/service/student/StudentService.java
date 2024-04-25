package org.example.service.student;

import org.example.base.service.BaseService;
import org.example.model.Lesson;
import org.example.model.Student;
import org.example.model.StudentTermUnit;

import java.util.List;

public interface StudentService extends BaseService<Student, Long> {
    Student findStudentByUserId(Long userId);
    List<StudentTermUnit> findLessonsByStudentId(Long studentCode);
    void SignUp(Student student);
    List<Student> findAll();


}
