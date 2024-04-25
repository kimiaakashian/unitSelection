package org.example.service.student;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.base.service.BaseServiceImpl;
import org.example.model.Student;
import org.example.model.StudentTermUnit;
import org.example.model.Users;
import org.example.repository.student.StudentRepository;
import org.example.repository.term.TermRepository;
import org.example.repository.term.TermRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentServiceImpl extends BaseServiceImpl<Student,Long, StudentRepository> implements StudentService{
    public StudentServiceImpl(StudentRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public Student findStudentByUserId(Long userId) {
        return repository.findStudentByUserId(userId);
    }

    @Override
    public List<StudentTermUnit> findLessonsByStudentId(Long studentCode) {
        return repository.findLessonsByStudentId(studentCode);
    }

    @Override
    public void SignUp(Student student) {
        repository.saveOrUpdate(student);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }



}







