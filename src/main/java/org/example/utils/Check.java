package org.example.utils;

import org.example.entity.Loans;
import org.example.entity.Students;
import org.example.entity.enums.Cities;
import org.example.entity.enums.Degree;
import org.example.entity.enums.LoanType;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Check {
    Scanner scanner = new Scanner(System.in);
    public String checkAlphabet(){
     while (true){
         String txt = scanner.next();
         if(txt.matches("[a-zA-Z]+"))
             return txt;
         System.out.println("try again");}
     }
     public int checkSwitchNumber(){
     while (true){
         int num = scanner.nextInt();
         for (int i = 0; i <= 6; i++) {
             if(num ==i) return num;
         }
         System.out.println("try again");}
     }

     public Long checkNumberSize(int i){
     while (true){
         String num = scanner.next();
         Long lo;
         if(String.valueOf(num).length() == i){
             if (!String.valueOf(num).matches("[a-zA-Z][!@#$%^&*()/_=+.,`~]+"))
                return lo =Long.parseLong(num);
         }
         System.out.println("try again");}
     }

     public int checkValue(Degree degree){
        int value = 0;
        switch (degree){
            case KARDANI: value = 0;break;
            case KARSHENASIPEYVASTE: value = 0;break;
            case KARSHENASINAPEYVASTE: value = 0;break;
            case KARSHENASIARSHAD: value = 1;break;
            case DOKTORAYHERFEI: value = 1;break;
            case DOKTORAYPEYVASTE: value = 1;break;
            case DOKTORAYTAKHASOSINAPEYVASTE: value = 2;break;
        }
        return value;
     }
     public boolean checkDeadLineDate(){
         LocalDate dateNow = LocalDate.now();
         LocalDate date1 = LocalDate.parse("2022-10-23");//1st Aban
         LocalDate pDate1 = date1.plusDays(8); ;//8st Aban
         LocalDate date2 = LocalDate.parse("2023-02-14");//25th Bahman
         LocalDate pDate2 = date2.plusDays(8); ;//2nd Esfand
         return dateNow.isAfter(date1) && dateNow.isBefore(pDate1)
                 || dateNow.isAfter(date2) && dateNow.isBefore(pDate2);
     }

     public String checkCity(String string){
        String city = "";
        if (string.equalsIgnoreCase("tehran"))
             city = "tehran";
         for (Cities c : Cities.values()) {
             if (c.name().equalsIgnoreCase(string))  city = "metropolis";
             else  city = "other";
         }
         return city;
     }

     public boolean checkGraduation(Long x,Degree degree){
        LocalDate nowDate = LocalDate.now().minusYears(621);
        int educationalYear = 0;
        switch (degree){
            case KARDANI: educationalYear = 2;break;
            case KARSHENASIPEYVASTE: educationalYear = 4;break;
            case KARSHENASINAPEYVASTE: educationalYear = 4;break;
            case KARSHENASIARSHAD: educationalYear = 2;break;
            case DOKTORAYHERFEI: educationalYear = 5;break;
            case DOKTORAYPEYVASTE: educationalYear = 5;break;
            case DOKTORAYTAKHASOSINAPEYVASTE: educationalYear = 5;break;
        }
         return educationalYear + x <= (nowDate.getYear());
     }

    public boolean checkLoan(List<Loans> loans,int input){

        for (Loans loan : loans) {
            if (input == 1)
                if (loan.getLoanType().equals(LoanType.TUITION))
                    return false;
            if (input == 2)
                if (loan.getLoanType().equals(LoanType.EDUCATION))
                    return false;
            if (input == 3)
                if (loan.getLoanType().equals(LoanType.HOUSING))
                    return false;

        }
        return true;
    }
}
