package com.example.finplatform;

import com.example.finplatform.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class FinPlatformApplication implements ApplicationRunner {
    @Autowired
    private Service service;

    public static void main(String[] args) {
        SpringApplication.run(FinPlatformApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Scanner in = new Scanner(System.in);
        System.out.println(
                "\n=================================================\n\n"
                        + "*** To work with the application, use commands ***:\n\n"
                        + "  get (to get the list of all students)\n"
                        + "  add (to add a new student)\n"
                        + "  delete (to remove a student from the list)\n"
                        + "  exit (to exit the application)");

        String command = in.nextLine().trim();
        if (Arrays.stream(CommandEnum.values()).anyMatch((t) -> t.name().equalsIgnoreCase(command))) {
            CommandEnum.valueOf(command.toUpperCase()).getAction(service, in);
        }
        run(args);
    }
}