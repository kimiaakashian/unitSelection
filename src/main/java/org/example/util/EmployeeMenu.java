package org.example.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.exception.NotFoundException;
import org.example.model.*;
import org.example.service.employee.EmployeeService;
import org.example.service.lesson.LessonService;
import org.example.service.professor.ProfessorService;
import org.example.service.student.StudentService;
import org.example.service.studentTermUnit.StudentTermUnitService;
import org.example.service.user.UserService;

import java.util.*;

public class EmployeeMenu {

    final static Scanner scanner = new Scanner(System.in);
    final static StudentService studentService = ApplicationContext.getStudentService();
    final StudentTermUnitService studentTermUnitService = ApplicationContext.getStudentTermUnitService();
    final UserService userService = ApplicationContext.getUserService();
    final ProfessorService professorService = ApplicationContext.getProfessorService();
    final EmployeeService employeeService = ApplicationContext.getEmployeeService();
    final LessonService lessonService = ApplicationContext.getLessonService();

    int number;
    public Long userId = 0L;

    public void showEmployeeMenu() {
        userId = Menu.signIn();
        while (number != 4) {
            System.out.println("****Welcome****");
            System.out.println(" \n 1.Student management  \n 2.professor management  \n 3.employee management \n " +
                    "4.lessons management \n ");
            number = scanner.nextInt();
            switch (number) {
                case 1 -> {
                    while (number != 4) {
                        System.out.println("Choose one of the options ");
                        System.out.println(" \n 1.register student  \n 2.delete student  \n 3.edit student \n " +
                                "4.exit  \n");
                        number = scanner.nextInt();
                        switch (number) {
                            case 1 -> studentRegisterMenu();
                            case 2 -> deleteStudent();
                            case 3 -> System.out.println("edit student");
                            case 4 -> {
                                break;
                            }
                        }

                    }
                }
                case 2 -> {
                    while (number != 4) {
                        System.out.println("Choose one of the options ");
                        System.out.println(" \n 1.register professor  \n 2.delete professor  \n 3.edit professor \n " +
                                "4.exit  \n");
                        number = scanner.nextInt();
                        switch (number) {
                            case 1 -> professorRegisterMenu();
                            case 2 -> deleteProfessor();
                            case 3 -> System.out.println("edit professor");
                            case 4 -> {
                                break;
                            }
                        }

                    }

                }
                case 3 -> {
                    while (number != 4) {
                        System.out.println("Choose one of the options ");
                        System.out.println(" \n 1.register employee  \n 2.delete employee  \n 3.edit employee \n " +
                                "4.exit  \n");
                        number = scanner.nextInt();
                        switch (number) {
                            case 1 -> System.out.println("register employee");
                            case 2 -> System.out.println("delete employee");
                            case 3 -> System.out.println("edit employee");
                            case 4 -> {
                                break;
                            }
                        }

                    }

                }
                case 4 -> {
                    while (number != 4) {
                        System.out.println("Choose one of the options ");
                        System.out.println(" \n 1.register lesson  \n 2.delete lesson  \n 3.edit lesson \n " +
                                "4.exit  \n");
                        number = scanner.nextInt();
                        switch (number) {
                            case 1 -> System.out.println("register lesson");
                            case 2 -> System.out.println("delete lesson");
                            case 3 -> System.out.println("edit lesson");
                            case 4 -> {
                                break;
                            }
                        }

                    }
                }
                case 5 -> {
                    break;
                }
            }

        }

    }

    public void studentRegisterMenu() {
        System.out.println("please enter student's username ");
        scanner.nextLine();
        String userName = scanner.nextLine();
        System.out.println("please enter student's password ");
        String password = scanner.nextLine();
        Users user = new Users(userName, password);
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Users>> userViolations = validator.validate(user);
        if (!userViolations.isEmpty()) {
            for (ConstraintViolation<Users> violation : userViolations) {
                System.out.println(violation.getMessage());
                studentRegisterMenu();
                break;
            }
        }else {
            userService.signUpUsers(user);
            System.out.println("please enter student's first name ");
            String firstName = scanner.nextLine();
            System.out.println("please enter student's last name ");
            String lastName = scanner.nextLine();
            System.out.println("please enter student's studentCode (national code) ");
            String studentCode = scanner.nextLine();

            Student student = new Student(firstName, lastName, studentCode, user,null);
            studentService.SignUp(student);
        }

    }


    public void professorRegisterMenu() {
        System.out.println("please enter student's username ");
        scanner.nextLine();
        String userName = scanner.nextLine();
        System.out.println("please enter student's password ");
        String password = scanner.nextLine();
        Users user = new Users(userName, password);
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Users>> userViolations = validator.validate(user);
        if (!userViolations.isEmpty()) {
            for (ConstraintViolation<Users> violation : userViolations) {
                System.out.println(violation.getMessage());
                studentRegisterMenu();
                break;
            }
        }else {
            System.out.println("please enter professor's first name ");
            String firstName = scanner.nextLine();

            System.out.println("please enter professor's last name ");
            String lastName = scanner.nextLine();

            System.out.println("please enter professor's code (national code) ");
            String professorCode = scanner.nextLine();

            System.out.println("Please enter professor's type (TUITION or FACULTY_MEMBER):");
            String typeInput = scanner.nextLine();
            ProfessorType professorType = ProfessorType.valueOf(typeInput.toUpperCase());

            System.out.println("please enter professor's salary  ");
            Double salary = scanner.nextDouble();

            Professor professor = new Professor(firstName, lastName, professorCode, professorType, salary, user);
            professorService.saveOrUpdate(professor);

        }

    }

    public void EmployeeRegisterMenu() {
        System.out.println("please enter employee's username ");
        String userName = scanner.nextLine();
        System.out.println("please enter employee's password ");
        String password = scanner.nextLine();
        System.out.println("please enter employee's first name ");
        String firstName = scanner.nextLine();
        System.out.println("please enter employee's last name ");
        String lastName = scanner.nextLine();
        System.out.println("please enter employee's salary  ");
        Double salary = scanner.nextDouble();
        Users user = new Users(userName, password);
        userService.signUpUsers(user);
        Employee employee = new Employee(firstName, lastName, salary, user);
        employeeService.saveOrUpdate(employee);

    }

    private void deleteStudent() {
        System.out.println("all student:");
        List<Student> students = studentService.findAll();
        for (Student s : students
        ) {
            System.out.println((s.getId()) + ". " + s.getFirstName() + " " + s.getLastName() + "--student code: " + s.getStudentCode());
        }
        System.out.println("please enter id of the student you want to delete");
        long studentId = scanner.nextLong();


        Student student = null;
        try {
            student = studentService.findById(studentId);
            studentService.delete(student);
        } catch (NotFoundException e) {
            System.out.printf(e.getMessage());
        }
    }

    private void deleteProfessor() {
        System.out.println("all professor:");
        List<Professor> professors = professorService.findAll();
        for (Professor p : professors
        ) {
            System.out.println((p.getId()) + ". " + p.getFirstName() + " " + p.getLastName() + "--student code: " + p.getProfessorCode());
        }
        System.out.println("please enter id of the professor you want to delete");
        long professorId = scanner.nextLong();


        Professor professor = null;
        try {
            professor = professorService.findById(professorId);
            professorService.delete(professor);
        } catch (NotFoundException e) {
            System.out.printf(e.getMessage());
        }
    }


}



