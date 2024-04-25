package org.example.repository.StudentTermUnit;

import org.example.base.repository.BaseRepository;
import org.example.model.Lesson;
import org.example.model.StudentTermUnit;

public interface StudentTermUnitRepository extends BaseRepository<StudentTermUnit, Long> {
    StudentTermUnit findStudentTermByLessonId(long studentId , long lessonId);
}
