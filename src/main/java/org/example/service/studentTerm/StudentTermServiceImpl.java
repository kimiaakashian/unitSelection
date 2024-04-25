package org.example.service.studentTerm;

import org.example.base.service.BaseServiceImpl;
import org.example.model.Student;
import org.example.model.StudentTerm;
import org.example.model.Term;
import org.example.repository.studentTerm.StudentTermRepository;
import org.hibernate.SessionFactory;

public class StudentTermServiceImpl extends BaseServiceImpl<StudentTerm,Long, StudentTermRepository> implements StudentTermService{
    public StudentTermServiceImpl(StudentTermRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public StudentTerm register(Student student, Term term) {

        StudentTerm studentTerm = repository.findStudentInTerm(student,term);
        if(studentTerm == null){
            StudentTerm previousRegisteredTerm = repository.findStudentLastTerm(student);
            studentTerm = new StudentTerm(student,term , previousRegisteredTerm , 0  , 0D ,null);
            repository.saveOrUpdate(studentTerm);
        }
        return studentTerm;
    }
}
