package org.example.repository.employee;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.Employee;
import org.hibernate.SessionFactory;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee,Long> implements EmployeeRepository {
    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
