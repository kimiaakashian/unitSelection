package org.example.service.studentTermUnit;

import org.example.base.service.BaseServiceImpl;
import org.example.model.Lesson;
import org.example.model.Student;
import org.example.model.StudentTermUnit;
import org.example.repository.StudentTermUnit.StudentTermUnitRepository;
import org.hibernate.SessionFactory;

public class StudentTermUnitServiceImpl extends BaseServiceImpl<StudentTermUnit,Long, StudentTermUnitRepository> implements StudentTermUnitService {
    public StudentTermUnitServiceImpl(StudentTermUnitRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public boolean hasThisLessonTakenBefore(Student student, Lesson lesson) {
        StudentTermUnit studentTermUnit = repository.findStudentTermByLessonId(student.getId() , lesson.getId());
        return studentTermUnit != null;
    }
}
