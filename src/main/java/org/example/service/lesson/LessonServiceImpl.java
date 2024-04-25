package org.example.service.lesson;

import org.example.base.service.BaseServiceImpl;
import org.example.model.Lesson;
import org.example.repository.lesson.LessonRepository;
import org.hibernate.SessionFactory;

import java.util.List;

public class LessonServiceImpl extends BaseServiceImpl<Lesson,Long, LessonRepository> implements LessonService {
    public LessonServiceImpl(LessonRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public List<Lesson> findAll() {
        return repository.findAll();
    }
}
