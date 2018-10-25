package controller;

import model.Students;
import model.entity.Student;
import services.InputUtility;
import view.OutputMessages;
import view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WhatToDo {

    public static void execute(String input, Students model){
        if(input.equals("1")) {
            View.printNotes(model.getStudents());
        } else if(input.equals("2")){
            View.printMessage(OutputMessages.ENTER_SURNAME);
            String surname = InputUtility.getName();
            View.printMessage(OutputMessages.ENTER_NAME);
            String name = InputUtility.getName();
            View.printMessage(OutputMessages.ENTER_DATE_OF_BIRTH);
            String date = InputUtility.getDateOfBirth();
            View.printMessage(OutputMessages.ENTER_PHONE_NUMBER);
            String phone = InputUtility.getPhone();
            View.printMessage(OutputMessages.ENTER_ADDRESS);
            String address = InputUtility.getAddress();
            model.addStudent(new Student(surname, name, date, phone, address));
        }
    }
}
