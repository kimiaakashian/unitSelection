package org.example.repository.lesson;

import org.example.base.repository.BaseRepository;
import org.example.model.Lesson;

import java.util.List;

public interface LessonRepository extends BaseRepository<Lesson,Long> {

    List<Lesson> findAll();

}
