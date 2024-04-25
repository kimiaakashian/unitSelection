package org.example.util;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.example.model.*;
import org.example.service.employee.EmployeeService;
import org.example.service.lesson.LessonService;
import org.example.service.professor.ProfessorService;
import org.example.service.student.StudentService;
import org.example.service.studentTerm.StudentTermService;
import org.example.service.studentTermUnit.StudentTermUnitService;
import org.example.service.term.TermService;
import org.example.service.user.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StudentMenu {

    final Scanner scanner = new Scanner(System.in);
    final StudentService studentService = ApplicationContext.getStudentService();
    final TermService termService = ApplicationContext.getTermService();
    final StudentTermService studentTermService = ApplicationContext.getStudentTermService();
    final StudentTermUnitService studentTermUnitService = ApplicationContext.getStudentTermUnitService();
    final LessonService lessonService = ApplicationContext.getLessonService();

    int number;
    public Long userId = 0L;


    public void showStudentMenu() {
        userId = Menu.signIn();
        while (number != 4) {
            System.out.println("****Welcome****");
            System.out.println(" \n 1.View your profile  \n 2.View the list of lessons  \n 3.Select unit \n 4.\n" +
                    "Viewing the lessons taken with their grades \n 5.exit");
            number = scanner.nextInt();
            switch (number) {
                case 1 -> displayStudentDetails();
                case 2 -> displayAllLessons();
                case 3 -> selectUnit();
                case 4 -> System.out.println();
                case 5 -> {
                    Menu menu = new Menu();
                    menu.mainMenu();
                    break;
                }
            }

        }

    }


    public void selectUnit() {
        Student student = studentService.findStudentByUserId(userId);
        Term activeTerm = termService.findActiveTerm();

        StudentTerm studentTerm = studentTermService.register(student, activeTerm);


        Scanner scanner = new Scanner(System.in);
        Double lastTermAverageGrade = studentTerm.getPreviousTerm() != null ? studentTerm.getPreviousTerm().getAverageGrade() : 0;
        int maxAllowedUnit = lastTermAverageGrade > 17 ? 24 : 20;

        long lessonId = 0;
        System.out.println("**** Hello " + student.getFirstName() + " " + student.getLastName() + "- Welcome To Select Lessons Part in Term : " + activeTerm.getName() + "****");
        while (lessonId != -1) {
            System.out.println(" please enter lesson Id (-1 for end):");
            List<Lesson> lessons = lessonService.findAll();
            for (Lesson l : lessons
            ) {
                System.out.println((l.getId()) + ". " + l.getName());
            }
            lessonId = scanner.nextInt();
            if (lessonId != -1) {
                try {
                    Lesson lesson = lessonService.findById(lessonId);
                    if (lesson == null)
                        System.out.println("Not valid lesson Id!!!!!");
                    else {
                        int sumOfUnits = lesson.getUnitCount() + studentTerm.getSumOfUnits();
                        if (sumOfUnits > maxAllowedUnit)
                            System.out.println("Sum of units is more than allowed unit count!!!!!->maxAllowed is : " + maxAllowedUnit + " - taken unit is : " + sumOfUnits);
                        else {
                            if (studentTermUnitService.hasThisLessonTakenBefore(student, lesson))
                                System.out.println("this lesson has taken before!!!!");
                            else {
                                StudentTermUnit studentTermUnit = new StudentTermUnit(studentTerm, lesson, 0);
                                studentTermUnitService.saveOrUpdate(studentTermUnit);

                                //update Total inits
                                studentTerm.setSumOfUnits(sumOfUnits);
                                studentTermService.saveOrUpdate(studentTerm);
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }


        }
    }

    private void displayStudentDetails() {

        Student student = studentService.findStudentByUserId(userId);
        System.out.println("your profile:");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getFirstName());
        System.out.println("Age: " + student.getLastName());
        System.out.println("Age: " + student.getStudentCode());

    }

    public void displayAllLessons() {
        List<Lesson> lessons = lessonService.findAll();
        for (Lesson l : lessons
        ) {
            System.out.println((l.getId()) + ". " + l.getName());
        }
    }

}





