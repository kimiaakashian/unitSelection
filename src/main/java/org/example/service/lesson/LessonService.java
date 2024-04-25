package org.example.service.lesson;

import org.example.base.service.BaseService;
import org.example.model.Lesson;

import java.util.List;

public interface LessonService extends BaseService<Lesson,Long> {
    List<Lesson> findAll();

}
