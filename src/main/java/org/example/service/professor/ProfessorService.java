package org.example.service.professor;

import org.example.base.service.BaseService;
import org.example.model.Lesson;
import org.example.model.Professor;
import org.example.model.Student;
import org.example.model.StudentTermUnit;

import java.util.ArrayList;
import java.util.List;

public interface ProfessorService extends BaseService<Professor,Long> {
    Professor findProfessorByUserId(Long userId);
    ArrayList<Lesson> findProfessorLessonsInActiveTerm(long professorId);
    ArrayList<StudentTermUnit> findProfessorStudentsInActiveTermAndSelectedLesson(long professorId, long lessonId);
    List<Professor> findAll();

}
