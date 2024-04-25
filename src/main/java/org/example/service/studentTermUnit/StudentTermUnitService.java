package org.example.service.studentTermUnit;

import org.example.base.service.BaseService;
import org.example.model.Lesson;
import org.example.model.Student;
import org.example.model.StudentTermUnit;

public interface StudentTermUnitService extends BaseService<StudentTermUnit,Long> {
    boolean hasThisLessonTakenBefore(Student student , Lesson lesson);
}
