package org.example.util;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.example.model.*;
import org.example.service.employee.EmployeeService;
import org.example.service.lesson.LessonService;
import org.example.service.professor.ProfessorService;
import org.example.service.student.StudentService;
import org.example.service.studentTermUnit.StudentTermUnitService;
import org.example.service.user.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ProfessorMenu {

    final Scanner scanner = new Scanner(System.in);
    final StudentTermUnitService studentTermUnitService = ApplicationContext.getStudentTermUnitService();
    final ProfessorService professorService = ApplicationContext.getProfessorService();

    int number;
    public Long userId = 0L;

    public void showProfessorMenu() {
        userId = Menu.signIn();
        while (number != 4) {
            System.out.println("****Welcome****");
            System.out.println(" \n 1.View your profile  \n 2.Registration of students' grades  \n 3.View the pay slip \n 4.exit");
            number = scanner.nextInt();
            switch (number) {
                case 1 -> displayProfessorDetails();
                case 2 -> registerStudentsGrade();
                case 3 -> showProfessorMenu();
                case 4 -> {
                    break;
                }
            }
        }
    }

    public void registerStudentsGrade() {
        Professor professor = professorService.findProfessorByUserId(userId);
        List<Lesson> lessons = professorService.findProfessorLessonsInActiveTerm(professor.getId());
        if (!lessons.isEmpty()) {

            int lessonId = 1;
            while (lessonId > 0) {
                System.out.println("Available lessons for professor :");
                for (int i = 1; i < lessons.size(); i++) {
                    System.out.println((lessons.get(i).getId()) + ". " + lessons.get(i).getName());
                }
                System.out.print("Enter the id of the lesson(0 for exit): ");
                lessonId = scanner.nextInt();
                if (lessonId > 0) {
                    ArrayList<StudentTermUnit> studentTermUnits = professorService.findProfessorStudentsInActiveTermAndSelectedLesson(professor.getId(), lessonId);
                    System.out.println("Registered Students are :");

                    HashMap validStudentsIdMap = new HashMap();
                    for (StudentTermUnit stu : studentTermUnits
                    ) {
                        validStudentsIdMap.put(stu.getId(), stu.getId());
                        System.out.println((stu.getId()) + ". " + stu.getStudentTerm().getStudent().getFirstName()
                                + " " + stu.getStudentTerm().getStudent().getLastName()
                                + " - already entered grade is : " + stu.getGrade());
                    }
                    long stuId = 1;
                    while (stuId > 0) {
                        System.out.print("Enter the id of the student(0 for exit): ");
                        stuId = scanner.nextInt();

                        if (stuId > 0) {
                            if (validStudentsIdMap.containsKey(stuId)) {
                                System.out.print("Enter the grade of student: ");
                                double grade = scanner.nextInt();
                                StudentTermUnit studentTermUnit = studentTermUnitService.findById(stuId);
                                if (studentTermUnit != null) {
                                    studentTermUnit.setGrade(grade);
                                    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
                                    String message = validator.validateProperty(studentTermUnit, "Grade").toString();
                                    if (message.equals("[]"))
                                        studentTermUnitService.saveOrUpdate(studentTermUnit);
                                    else
                                        System.out.println(message);
                                } else {
                                    showUnValidStudentMessage(studentTermUnits);
                                }
                            } else {
                                showUnValidStudentMessage(studentTermUnits);
                            }
                        }
                    }
                }
            }

        } else {
            System.out.println("No lessons found for professor ");
        }
    }

    private static void showUnValidStudentMessage(ArrayList<StudentTermUnit> studentTermUnits) {
        System.out.println("not valid studentId!!");
        for (StudentTermUnit stu : studentTermUnits
        ) {
            System.out.println((stu.getId()) + ". " + stu.getStudentTerm().getStudent().getFirstName()
                    + " " + stu.getStudentTerm().getStudent().getLastName()
                    + " - already entered grade is : " + stu.getGrade());
        }
    }

    private double calculateSalary(Professor professor) {
        System.out.println("How many units did you teach this semester? ");
        int unit = scanner.nextInt();
        double baseSalary = 0;
        double salary = 0;
        if (professor.getProfessorType() == ProfessorType.FACULTY_MEMBER) {
            baseSalary = professor.getSalary();
            salary = baseSalary + (unit * 1_000_000);
        } else if (professor.getProfessorType() == ProfessorType.TUITION) {

            salary = unit * 1_000_000;
        }
        return salary;
    }

    private void displayProfessorDetails() {

        Professor professor = professorService.findProfessorByUserId(userId);
        System.out.println("your profile:");
        System.out.println("ID: " + professor.getId());
        System.out.println("Name: " + professor.getFirstName());
        System.out.println("Age: " + professor.getLastName());
        System.out.println("Age: " + professor.getProfessorCode());

    }


}



