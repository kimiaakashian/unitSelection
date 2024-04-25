package org.example.util;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.model.*;
import org.example.service.employee.EmployeeService;
import org.example.service.lesson.LessonService;
import org.example.service.professor.ProfessorService;
import org.example.service.student.StudentService;
import org.example.service.studentTermUnit.StudentTermUnitService;
import org.example.service.user.UserService;

import java.util.*;

public class Menu {
    int number;

    public void mainMenu() {
        final Scanner scanner = new Scanner(System.in);
        StudentMenu studentMenu = new StudentMenu();
        EmployeeMenu employeeMenu = new EmployeeMenu();
        ProfessorMenu professorMenu = new ProfessorMenu();
        while (number != 4) {
            System.out.println("****Welcome****");
            System.out.println(" \n 1.employee   \n 2.student  \n 3.professor  \n 4.exit");
            System.out.println("Who are you ?:");
            number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case 1 -> employeeMenu.showEmployeeMenu();
                case 2 -> studentMenu.showStudentMenu();
                case 3 -> professorMenu.showProfessorMenu();
                case 4 -> {
                    break;
                }
            }

        }
    }

    public static long signIn() {
        Scanner scanner = new Scanner(System.in);
        UserService userService = ApplicationContext.getUserService();


        while (true) {

            System.out.println("Please enter your username: ");
            String username = scanner.nextLine();

            System.out.println("Please enter your password: ");
            String password = scanner.nextLine();


            Users user = userService.findByUserName(username);

            if (user != null && user.getPassword().equals(password)) {
                return user.getId();
            } else if (user == null) {
                System.out.println("User does not exist. please register first !");
                userService.signUpUsers(user);
            } else if (!password.equals(user.getPassword())) {
                System.out.println(("Incorrect password."));
            }
        }
    }

}



