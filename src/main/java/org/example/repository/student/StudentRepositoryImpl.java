package org.example.repository.student;

import org.example.base.repository.BaseRepository;
import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.Lesson;
import org.example.model.Student;
import org.example.model.StudentTermUnit;
import org.example.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl extends BaseRepositoryImpl<Student, Long> implements StudentRepository {
    public StudentRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public Student findStudentByUserId(Long userId) {
        Student student = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            student = session.createQuery("FROM Student s WHERE s.user.id = :userId", Student.class)
                    .setParameter("userId", userId)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<StudentTermUnit> findLessonsByStudentId(Long studentCode) {
        List<StudentTermUnit> Lesson = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Lesson = session.createQuery("SELECT stu FROM StudentTermUnit stu " +
                            "WHERE stu.studentTerm.student.StudentCode = :studentCode", StudentTermUnit.class)
                    .setParameter("studentCode", studentCode)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Lesson;
    }

    @Override
    public List<Student> findAll() {
        ArrayList<Student> students = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            students = (ArrayList<Student>) session.createQuery(
                            "FROM Student s ", Student.class)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }


}