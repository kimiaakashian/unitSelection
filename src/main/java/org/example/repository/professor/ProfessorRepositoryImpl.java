package org.example.repository.professor;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.Lesson;
import org.example.model.Professor;
import org.example.model.Student;
import org.example.model.StudentTermUnit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ProfessorRepositoryImpl extends BaseRepositoryImpl<Professor, Long> implements ProfessorRepository {
    public ProfessorRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Professor> getEntityClass() {
        return Professor.class;
    }

    @Override
    public Professor findProfessorByUserId(Long userId) {
        Professor professor = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            professor = session.createQuery("FROM Professor p WHERE p.user.id = :userId", Professor.class).setParameter("userId", userId).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professor;
    }

    @Override
    public ArrayList<Lesson> findProfessorLessonsInActiveTerm(long professorId, long activeTermId) {
        ArrayList<Lesson> lessons = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            lessons = (ArrayList<Lesson>) session.createQuery("select distinct stu.lesson FROM StudentTermUnit stu WHERE stu.lesson.professor.id = :professorId" + " AND stu.studentTerm.term.id = :termId", Lesson.class).setParameter("professorId", professorId).setParameter("termId", activeTermId).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lessons;
    }

    @Override
    public ArrayList<StudentTermUnit> findProfessorStudentsInActiveTermAndSelectedLesson(long professorId, long activeTermId, long lessonId) {
        ArrayList<StudentTermUnit> students = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            students = (ArrayList<StudentTermUnit>) session.createQuery("FROM StudentTermUnit stu WHERE stu.lesson.professor.id = :professorId" + " AND stu.studentTerm.term.id = :termId" + " AND stu.lesson.id = :lessonId", StudentTermUnit.class).setParameter("professorId", professorId).setParameter("termId", activeTermId).setParameter("lessonId", lessonId).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Professor> findAll() {
        ArrayList<Professor> professors = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            professors = (ArrayList<Professor>) session.createQuery(
                            "FROM Professor p ", Professor.class)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professors;
    }
    }

