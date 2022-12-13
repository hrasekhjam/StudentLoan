package org.example.utils;

import org.example.entity.Students;
import org.example.entity.enums.LoanType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InstallmentCalculation {

    public int calculation(String amount) {

        double loanAmount = Double.parseDouble(amount);
        double math1 = 0;
        for (int i = 1; i <= 4; i++) {
            double b = Math.pow((2 / (Math.pow(1.0033, 12))), i);
            math1 += b;
        }
        double math2 = ((Math.pow(1.0033, 12)) - 1) / (0.0033 * (Math.pow(1.0033, 12)));
        double math3 = Math.pow((2 / (Math.pow(1.0033, 12))), 5);
        double math4 = ((Math.pow(1.0033, 0)) - 1) / (0.0033 * (Math.pow(1.0033, 0)));

        return (int) (loanAmount / ((math1 + 1) * math2) + (math3 * math4));
    }

    public List<LocalDate> installmentTimePay(LocalDate localDate, int year){
        List<LocalDate> timeForPay = new ArrayList<>();
        LocalDate time = localDate.plusYears(year - 1);
        for (int i = 1; i <= 12; i++) {
            timeForPay.add(time.plusMonths(i));
        }
        return timeForPay;
    }
}
