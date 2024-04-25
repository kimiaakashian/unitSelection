package org.example.service.employee;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.base.service.BaseServiceImpl;
import org.example.model.Employee;
import org.example.model.Lesson;
import org.example.repository.employee.EmployeeRepository;
import org.hibernate.SessionFactory;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long, EmployeeRepository> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }


}
