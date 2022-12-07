package org.example.utils;

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

     public Long checkNumberSize(){
     while (true){
         String num = scanner.next();
         Long lo;
         if(String.valueOf(num).length() == 10){
             if (!String.valueOf(num).matches("[a-zA-Z][!@#$%^&*()/_=+.,`~]+"))
                return lo =Long.parseLong(num);
         }
         System.out.println("try again");}
     }

}
