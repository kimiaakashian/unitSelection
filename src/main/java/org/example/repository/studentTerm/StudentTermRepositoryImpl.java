package org.example.repository.studentTerm;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.Student;
import org.example.model.StudentTerm;
import org.example.model.Term;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class StudentTermRepositoryImpl extends BaseRepositoryImpl<StudentTerm,Long> implements StudentTermRepository {
    public StudentTermRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<StudentTerm> getEntityClass() {
        return StudentTerm.class;
    }

    @Override
    public StudentTerm findStudentInTerm(Student student, Term term) {
        StudentTerm studentTerm = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            studentTerm = session.createQuery("FROM StudentTerm st WHERE st.student.id = :studentId and st.term.id = :termId", StudentTerm.class)
                    .setParameter("studentId", student.getId())
                    .setParameter("termId", term.getId())
                    .uniqueResult();
        } catch (Exception e) {
        }
        return studentTerm;
    }

    @Override
    public StudentTerm findStudentLastTerm(Student student) {
        StudentTerm studentTerm = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            studentTerm = ((ArrayList<StudentTerm>) session.createQuery("FROM StudentTerm st WHERE st.student.id = :studentId order by st.id desc", StudentTerm.class)
                    .setParameter("studentId", student.getId())
                    .list()).get(0);
        } catch (Exception e) {
        }
        return studentTerm;
    }
}
