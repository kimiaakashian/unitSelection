package org.example.util;


import org.example.conncetion.SessionFactorySingleton;
import org.example.model.*;
import org.example.repository.StudentTermUnit.StudentTermUnitRepository;
import org.example.repository.StudentTermUnit.StudentTermUnitRepositoryImpl;
import org.example.repository.employee.EmployeeRepository;
import org.example.repository.employee.EmployeeRepositoryImpl;
import org.example.repository.lesson.LessonRepository;
import org.example.repository.lesson.LessonRepositoryImpl;
import org.example.repository.professor.ProfessorRepository;
import org.example.repository.professor.ProfessorRepositoryImpl;
import org.example.repository.student.StudentRepository;
import org.example.repository.student.StudentRepositoryImpl;
import org.example.repository.studentTerm.StudentTermRepository;
import org.example.repository.studentTerm.StudentTermRepositoryImpl;
import org.example.repository.term.TermRepository;
import org.example.repository.term.TermRepositoryImpl;
import org.example.repository.user.UserRepository;
import org.example.repository.user.UserRepositoryImpl;
import org.example.service.employee.EmployeeService;
import org.example.service.employee.EmployeeServiceImpl;
import org.example.service.lesson.LessonService;
import org.example.service.lesson.LessonServiceImpl;
import org.example.service.professor.ProfessorService;
import org.example.service.professor.ProfessorServiceImpl;
import org.example.service.student.StudentService;
import org.example.service.student.StudentServiceImpl;
import org.example.service.studentTerm.StudentTermService;
import org.example.service.studentTerm.StudentTermServiceImpl;
import org.example.service.studentTermUnit.StudentTermUnitService;
import org.example.service.studentTermUnit.StudentTermUnitServiceImpl;
import org.example.service.term.TermService;
import org.example.service.term.TermServiceImpl;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImpl;
import org.hibernate.SessionFactory;

import java.security.Provider;
import java.time.LocalDateTime;

public class ApplicationContext {

    static final SessionFactory SESSION_FACTORY;
    static final EmployeeRepository EMPLOYEE_REPOSITORY;
    static final EmployeeService EMPLOYEE_SERVICE;
    static final LessonRepository LESSON_REPOSITORY;
    static final LessonService LESSON_SERVICE;
    static final ProfessorRepository PROFESSOR_REPOSITORY;
    static final ProfessorService PROFESSOR_SERVICE;

    static final StudentRepository STUDENT_REPOSITORY;
    static final StudentService STUDENT_SERVICE;
    static final StudentTermRepository STUDENT_TERM_REPOSITORY;
    static final StudentTermService STUDENT_TERM_SERVICE;
    static final StudentTermUnitRepository STUDENT_TERM_UNIT_REPOSITORY;
    static final StudentTermUnitService STUDENT_TERM_UNIT_SERVICE;
    static final TermRepository TERM_REPOSITORY;
    static final TermService TERM_SERVICE;
    static final UserRepository USER_REPOSITORY;
    static final UserService USER_SERVICE;


    static {
        SESSION_FACTORY = SessionFactorySingleton.getInstance();
        EMPLOYEE_REPOSITORY = new EmployeeRepositoryImpl(SESSION_FACTORY);
        EMPLOYEE_SERVICE = new EmployeeServiceImpl(EMPLOYEE_REPOSITORY, SESSION_FACTORY);
        LESSON_REPOSITORY = new LessonRepositoryImpl(SESSION_FACTORY);
        LESSON_SERVICE = new LessonServiceImpl(LESSON_REPOSITORY, SESSION_FACTORY);
        PROFESSOR_REPOSITORY = new ProfessorRepositoryImpl(SESSION_FACTORY);
        PROFESSOR_SERVICE = new ProfessorServiceImpl(PROFESSOR_REPOSITORY, SESSION_FACTORY);
        STUDENT_REPOSITORY = new StudentRepositoryImpl(SESSION_FACTORY);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY, SESSION_FACTORY);
        STUDENT_TERM_REPOSITORY = new StudentTermRepositoryImpl(SESSION_FACTORY);
        STUDENT_TERM_SERVICE = new StudentTermServiceImpl(STUDENT_TERM_REPOSITORY, SESSION_FACTORY);
        STUDENT_TERM_UNIT_REPOSITORY = new StudentTermUnitRepositoryImpl(SESSION_FACTORY);
        STUDENT_TERM_UNIT_SERVICE = new StudentTermUnitServiceImpl(STUDENT_TERM_UNIT_REPOSITORY, SESSION_FACTORY);
        TERM_REPOSITORY = new TermRepositoryImpl(SESSION_FACTORY);
        TERM_SERVICE = new TermServiceImpl(TERM_REPOSITORY, SESSION_FACTORY);
        USER_REPOSITORY = new UserRepositoryImpl(SESSION_FACTORY);
        USER_SERVICE = new UserServiceImpl(USER_REPOSITORY, SESSION_FACTORY);


    }

    public static EmployeeService getEmployeeService() {
        return EMPLOYEE_SERVICE;
    }

    public static LessonService getLessonService() {
        return LESSON_SERVICE;
    }

    public static ProfessorService getProfessorService() {
        return PROFESSOR_SERVICE;
    }

    public static StudentService getStudentService() {
        return STUDENT_SERVICE;
    }

    public static StudentTermService getStudentTermService() {
        return STUDENT_TERM_SERVICE;
    }

    public static StudentTermUnitService getStudentTermUnitService() {
        return STUDENT_TERM_UNIT_SERVICE;
    }

    public static TermService getTermService() {
        return TERM_SERVICE;
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }

}
