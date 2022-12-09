package org.example;

import org.example.entity.Loans;
import org.example.entity.Students;
import org.example.entity.enums.*;
import org.example.menu.Menus;
import org.example.service.StudentService;
import org.example.utils.Check;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Menus menu = new Menus();
        menu1run();
    }

    static Scanner scanner = new Scanner(System.in);
    static Students students = new Students();
    static Degree degreeSet;
    static Long studentIdSet;

    static StudentService studentService = new StudentService();

    public static void menu1run() {
        Menus menu = new Menus();
        Check check = new Check();
//        System.out.println(check.checkDeadLineDate());//todo check deadline
        menu.firstMenu();
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Enter Name: ");
                students.setName(check.checkAlphabet());
                System.out.println("Enter Last Name: ");
                students.setLastName(check.checkAlphabet());
                System.out.println("Enter Father Name: ");
                students.setFatherName(check.checkAlphabet());
                System.out.println("Enter Mother Name: ");
                students.setMotherName(check.checkAlphabet());
                System.out.println("Enter Shenasnameh Number: ");
                students.setSh_Number(check.checkNumberSize());
                System.out.println("Enter Nation Number: ");
                students.setNationNumber(check.checkNumberSize());
                System.out.println("Enter Birth Date: " + "\n" + "(Ex. yy/mm/dd)");
                students.setBirthDate(scanner.next());
                System.out.println("Enter Your Married Status :   (married/single) ");
                if (scanner.next().equalsIgnoreCase("married"))students.setMarried(true);
                if (scanner.next().equalsIgnoreCase("single"))students.setMarried(false);
                System.out.println("Enter Your City Name: ");
                students.setCity(check.checkAlphabet());
                System.out.println("Enter Student Id: ");
                students.setStudentId(check.checkNumberSize());
                System.out.println("Enter University Name: ");
                students.setUniName(check.checkAlphabet());
                System.out.println("Enter University Type ");
                System.out.println("0 -> AZAD//1 -> DOLATIROZANE//2 -> PAYAMNOUR//3 -> DOLATISHABANE//4 -> GHEYRENTEFAEI//5 -> PARDIS//6 -> ELMIKARBORDI: ");
                switch (check.checkSwitchNumber()) {
                    case 0:
                        students.setUniType(UniType.AZAD);
                        break;
                    case 1:
                        students.setUniType(UniType.DOLATIROZANE);
                        break;
                    case 2:
                        students.setUniType(UniType.PAYAMNOUR);
                        break;
                    case 3:
                        students.setUniType(UniType.DOLATISHABANE);
                        break;
                    case 4:
                        students.setUniType(UniType.GHEYRENTEFAEI);
                        break;
                    case 5:
                        students.setUniType(UniType.PARDIS);
                        break;
                    case 6:
                        students.setUniType(UniType.ELMIKARBORDI);
                }
                System.out.println("Enter year Of University Entrance: ");
                students.setYearOfUniEntrance(scanner.nextLong());
                System.out.println("Enter Your Degree ");
                System.out.println("0 -> KARDANI//1 -> KARSHENASIPEYVASTE//2 -> KARSHENASINAPEYVASTE//3 -> KARSHENASIARSHAD//4 -> DOKTORAYHERFEI//5 -> DOKTORAYPEYVASTE//6 -> DOKTORAYTAKHASOSINAPEYVASTE: ");
                switch (check.checkSwitchNumber()) {
                    case 0:
                        students.setDegree(Degree.KARDANI);
                        break;
                    case 1:
                        students.setDegree(Degree.KARSHENASIPEYVASTE);
                        break;
                    case 2:
                        students.setDegree(Degree.KARSHENASINAPEYVASTE);
                        break;
                    case 3:
                        students.setDegree(Degree.KARSHENASIARSHAD);
                        break;
                    case 4:
                        students.setDegree(Degree.DOKTORAYHERFEI);
                        break;
                    case 5:
                        students.setDegree(Degree.DOKTORAYPEYVASTE);
                        break;
                    case 6:
                        students.setDegree(Degree.DOKTORAYTAKHASOSINAPEYVASTE);
                }
                students.setPassWord(generatePassword(8));
                students.setUserName(String.valueOf(students.getNationNumber()));
                studentService.register(students);
                System.out.println("Your registration has been completed." + "\n" + "Your password : " + students.getPassWord() + "\n" + "The UserName is the national code without zero");
                menu1run();
            case 2:
                System.out.println("Enter Username : ");
                String user = scanner.next();
                System.out.println("Enter password : ");
                String pass = scanner.next();
                students = studentService.loginUser(user, pass);
                degreeSet = students.getDegree();
                studentIdSet = students.getId();

                System.out.println("Log in successfully");
                break;
        }
        menu2run();
    }

    public static void menu2run() {
        Menus menu = new Menus();
        Loans loans = new Loans();
        Check check = new Check();

        menu.dashboardMenu();
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Your Degree is : " + degreeSet);
                System.out.println("Which one do you want to choose?");
                System.out.println("// 1* tuition //" + "\n" + "// 2* Education //" + "\n" + "// 3* Housing //");
                if (scanner.nextInt() == 1) {
                    loans.setLoanType(LoanType.TUITION);
                    switch (check.checkValue(degreeSet)) {
                        case 0:
                            loans.setLoanAmount(TuitionLoan.MAGHTA1.getAction());
                            break;
                        case 1:
                            loans.setLoanAmount(TuitionLoan.MAGHTA2.getAction());
                            break;
                        case 2:
                            loans.setLoanAmount(TuitionLoan.MAGHTA3.getAction());
                            break;
                    }
                }
                if (scanner.nextInt() == 2) {
                    loans.setLoanType(LoanType.EDUCATION);
                    switch (check.checkValue(degreeSet)) {
                        case 0:
                            loans.setLoanAmount(EducationLoan.MAGHTA1.getAction());
                            break;
                        case 1:
                            loans.setLoanAmount(EducationLoan.MAGHTA2.getAction());
                            break;
                        case 2:
                            loans.setLoanAmount(EducationLoan.MAGHTA3.getAction());
                            break;
                    }
                }
                if (scanner.nextInt() == 3) {
                    if (students.isMarried()) {
                        loans.setLoanType(LoanType.HOUSING);//todo
                        switch (check.checkValue(degreeSet)) {
                            case 0:
                                loans.setLoanAmount(HousingLoan.MAGHTA1.getAction());
                                break;
                            case 1:
                                loans.setLoanAmount(HousingLoan.MAGHTA2.getAction());
                                break;
                            case 2:
                                loans.setLoanAmount(HousingLoan.MAGHTA3.getAction());
                                break;
                        }
                    }else System.out.println("You cannot register this loan");
                }

                if (students.getUniType().equals(UniType.DOLATIROZANE)) {
                    System.out.println("Your University type is : " + students.getUniType() + ". You cannot register this loan");
                    break;
                } else
                    System.out.println("For " + degreeSet + " : " + loans.getLoanAmount() + " Toman Ast." + "\n" + "Continue press 1" + "\n" + "Else press 0");
                if (scanner.nextInt() == 1) {
                    if (loans.getLoanType().equals(LoanType.HOUSING)) {
                        System.out.println("Enter Partner Name: ");
                        students.setPartnerName(check.checkAlphabet());
                        System.out.println("Enter Partner Last Name: ");
                        students.setPartnerLastName(check.checkAlphabet());
                        System.out.println("Enter Partner Father Name: ");
                        students.setPartnerFatherName(check.checkAlphabet());
                        System.out.println("Enter Partner Nation Number: ");
                        students.setPartnerNationNumber(check.checkNumberSize());
                        System.out.println("Enter Partner Birth Date: " + "\n" + "(Ex. yy/mm/dd)");
                        students.setPartnerBirthDate(scanner.next());
                        studentService.updateUser(students,studentIdSet);
                    }
                        if (students.getIdCard().isEmpty()) {
                             System.out.println("Add Your Card" + "\n" + "Enter Card Number :");
                             students.setIdCard(scanner.next());
                             System.out.println("Enter cvv2 :");
                             students.setIdCard(scanner.next());
                             System.out.println("Enter Card Password :");
                             students.setIdCard(scanner.next());
                             studentService.updateUser(students, studentIdSet);
                        }
                } else menu.dashboardMenu();
//                break;
            System.out.println(loans.getLoanType() + " Loans is registered");
            menu.dashboardMenu();
            case 2:

            case 3:

            case 4:
                menu1run();
        }
    }

    public static void menu3run() {
        Scanner scanner = new Scanner(System.in);
        Check check = new Check();
        Menus menu = new Menus();
        Students students = new Students();
        StudentService studentService = new StudentService();

        menu.thirdMenu();
        switch (scanner.nextInt()) {
            case 1:

            case 2:

            case 3:

            case 4:
                menu2run();
        }
    }

    private static String generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;

        Random random = new Random();
        char[] pass = new char[length];
        pass[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        pass[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        pass[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        pass[3] = numbers.charAt(random.nextInt(numbers.length()));

        for (int i = 4; i < length; i++) {
            pass[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        String st = String.valueOf(pass);
        return st;
    }
}