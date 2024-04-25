package org.example.repository.lesson;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.Lesson;
import org.example.model.StudentTermUnit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class LessonRepositoryImpl extends BaseRepositoryImpl<Lesson,Long> implements LessonRepository {
    public LessonRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Lesson> getEntityClass() {
        return Lesson.class;
    }

    @Override
    public List<Lesson> findAll() {
        ArrayList<Lesson> lessons = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            lessons = (ArrayList<Lesson> ) session.createQuery(
                            "FROM Lesson l ", Lesson.class)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lessons;
    }
}
