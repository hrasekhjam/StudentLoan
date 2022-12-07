package org.example;

import org.example.entity.Students;
import org.example.entity.enums.Degree;
import org.example.entity.enums.UniType;
import org.example.menu.Menus;
import org.example.service.StudentService;
import org.example.utils.Check;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menus menu = new Menus();

        menu.firstMenu();
        menu1run();
    }
    public static void menu1run() {
        Scanner scanner = new Scanner(System.in);
        Check check = new Check();
        Menus menu = new Menus();
        Students students = new Students();
        StudentService studentService = new StudentService();

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

                menu1run();
            case 2:
                System.out.println("Enter Username : ");
                String user = scanner.next();
                System.out.println("Enter password : ");
                String pass = scanner.next();
                studentService.loginUser(user,pass);

                System.out.println("Log in successfully");
                menu.secondMenu();
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