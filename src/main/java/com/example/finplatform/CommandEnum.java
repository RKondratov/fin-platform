package com.example.finplatform;

import com.example.finplatform.model.Student;
import com.example.finplatform.service.Service;
import com.example.finplatform.util.ValidationUtil;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Scanner;

import static com.example.finplatform.util.ValidationUtil.isValidDate;

public enum CommandEnum {
    ADD() {
        @Override
        public void getAction(Service service, Scanner in) {
            final Student student = new Student();
            System.out.println("Enter the name of the new student");
            student.setName(in.nextLine());
            System.out.println("Enter the last name of the new student");
            student.setLastName(in.nextLine());
            System.out.println("Enter the middle name of the new student or press Enter to skip");
            String middleName = in.nextLine();
            student.setMiddleName(StringUtils.hasText(middleName) ? middleName : null);
            System.out.println("Enter the date of birth of the new student in YYYY-MM-DD format");
            String birthDate = in.nextLine();
            while (!isValidDate(birthDate)) {
                System.out.println("You entered an invalid date, please try again");
                birthDate = in.nextLine();
            }
            student.setBirthDay(LocalDate.parse(birthDate));
            System.out.println("Enter the group of the new student");
            student.setGroupId(in.nextLine());
            service.add(student);
        }
    },
    DELETE() {
        @Override
        public void getAction(Service service, Scanner in) {
            System.out.println("Enter Id to delete");
            String id = in.nextLine();
            if (ValidationUtil.checkId(id)) {
                service.delete(Integer.parseInt(id));
            } else {
                System.out.println("You must enter an existing student id");
            }
        }
    },
    GET() {
        @Override
        public void getAction(Service service, Scanner in) {
            service.getAll().forEach(System.out::println);
        }
    },
    EXIT() {
        @Override
        public void getAction(Service service, Scanner in) {
            System.exit(0);
        }
    };

    public abstract void getAction(Service service, Scanner in);
}