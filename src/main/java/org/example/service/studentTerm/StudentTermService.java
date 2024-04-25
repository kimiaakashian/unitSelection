package org.example.service.studentTerm;

import org.example.base.service.BaseService;
import org.example.model.Student;
import org.example.model.StudentTerm;
import org.example.model.Term;

public interface StudentTermService extends BaseService<StudentTerm,Long> {
    StudentTerm register(Student student , Term term);
}
