package org.example.service.professor;

import org.example.base.service.BaseServiceImpl;
import org.example.model.Lesson;
import org.example.model.Professor;
import org.example.model.StudentTermUnit;
import org.example.model.Term;
import org.example.repository.professor.ProfessorRepository;
import org.example.repository.term.TermRepository;
import org.example.repository.term.TermRepositoryImpl;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ProfessorServiceImpl extends BaseServiceImpl<Professor,Long, ProfessorRepository> implements ProfessorService{
    TermRepository termRepository = new TermRepositoryImpl(sessionFactory);

    public ProfessorServiceImpl(ProfessorRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public Professor findProfessorByUserId(Long userId) {
        return repository.findProfessorByUserId(userId);
    }

    @Override
    public ArrayList<Lesson> findProfessorLessonsInActiveTerm(long professorId) {
        Term activeTerm = termRepository.findActiveTerm();
        return repository.findProfessorLessonsInActiveTerm(professorId , activeTerm.getId());
    }

    @Override
    public ArrayList<StudentTermUnit> findProfessorStudentsInActiveTermAndSelectedLesson(long professorId, long lessonId) {
        Term activeTerm = termRepository.findActiveTerm();
        return repository.findProfessorStudentsInActiveTermAndSelectedLesson(professorId,activeTerm.getId() , lessonId);
    }

    @Override
    public List<Professor> findAll() {
        return repository.findAll();
    }
}
