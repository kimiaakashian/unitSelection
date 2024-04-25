package org.example;

import org.example.model.*;
import org.example.service.term.TermService;
import org.example.util.ApplicationContext;
import org.example.util.EmployeeMenu;
import org.example.util.Menu;
import org.example.util.StudentMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Users user2 = new Users("kimia123", "kimia123");
//        ApplicationContext.getUserService().saveOrUpdate(user2);
//
//        Users user = new Users(1L, "kimia123", "kimia123");
//
//        Student student = ApplicationContext.getStudentService().findStudentByUserId(user.getId());
//        Term activeTerm = ApplicationContext.getTermService().findActiveTerm();
//
//        StudentTerm studentTerm = ApplicationContext.getStudentTermService().register(student, activeTerm);
//
//
//        Scanner scanner = new Scanner(System.in);
//        Double lastTermAverageGrade = studentTerm.getPreviousTerm() != null ? studentTerm.getPreviousTerm().getAverageGrade() : 0;
//        int maxAllowedUnit = lastTermAverageGrade > 17 ? 24 : 20;
//
//        long lessonId = 0;
//        System.out.println("**** Hello " + student.getFirstName() + " " + student.getLastName() + "- Welcome To Select Lessons Part in Term : " + activeTerm.getName() + "****");
//        while (lessonId != -1) {
//            System.out.println(" please enter lesson Id (-1 for end):");
//            lessonId = scanner.nextInt();
//
//            Lesson lesson = ApplicationContext.getLessonService().findById(lessonId);
//            if(lesson == null)
//                System.out.println("Not valid lesson Id!!!!!");
//            else {
//                int sumOfUnits = lesson.getUnitCount() + studentTerm.getSumOfUnits();
//                if( sumOfUnits > maxAllowedUnit)
//                    System.out.println("Sum of units is more than allowed unit count!!!!!->maxAllowed is : " + maxAllowedUnit + " - taken unit is : " + sumOfUnits);
//                else {
//                    //check that if this lesson has taken before
//                    if(ApplicationContext.getStudentTermUnitService().hasThisLessonTakenBefore(student,lesson))
//                        System.out.println("this lesson has taken before!!!!");
//                    else {
//                        StudentTermUnit studentTermUnit = new StudentTermUnit(studentTerm, lesson, 0);
//                        ApplicationContext.getStudentTermUnitService().saveOrUpdate(studentTermUnit);
//
//                        //update Total inits
//                        studentTerm.setSumOfUnits(sumOfUnits);
//                        ApplicationContext.getStudentTermService().saveOrUpdate(studentTerm);
//                    }
//                }
//            }
//
//        }
//
//        System.out.println(activeTerm.getName());
//
        Menu menu = new Menu();
        menu.mainMenu();


    }
}