package org.example.repository.StudentTermUnit;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.StudentTerm;
import org.example.model.StudentTermUnit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class StudentTermUnitRepositoryImpl extends BaseRepositoryImpl<StudentTermUnit,Long> implements StudentTermUnitRepository {

    public StudentTermUnitRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<StudentTermUnit> getEntityClass() {
        return StudentTermUnit.class;
    }

    @Override
    public StudentTermUnit findStudentTermByLessonId(long studentId , long lessonId) {
        StudentTermUnit studentTermUnit = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            studentTermUnit = session.createQuery("FROM StudentTermUnit stu WHERE stu.studentTerm.student.id = :studentId " +
                            " and stu.lesson.id = :lessonId", StudentTermUnit.class)
                    .setParameter("studentId", studentId)
                    .setParameter("lessonId", lessonId)
                    .uniqueResult();
        } catch (Exception e) {
        }
        return studentTermUnit;
    }
}
