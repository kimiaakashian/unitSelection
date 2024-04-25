package org.example.repository.professor;

import org.example.base.repository.BaseRepository;
import org.example.model.Lesson;
import org.example.model.Professor;
import org.example.model.Student;
import org.example.model.StudentTermUnit;

import java.util.ArrayList;
import java.util.List;

public interface ProfessorRepository extends BaseRepository<Professor,Long> {
    Professor findProfessorByUserId(Long userId);
    ArrayList<Lesson> findProfessorLessonsInActiveTerm(long professorId,long activeTermId);
    ArrayList<StudentTermUnit> findProfessorStudentsInActiveTermAndSelectedLesson(long professorId, long activeTermId, long lessonId);
    List<Professor> findAll();

}
