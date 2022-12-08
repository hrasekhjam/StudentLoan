package org.example.menu;

public class Menus {
    public void firstMenu(){
        System.out.println("--------Welcome--------");
        System.out.println("|------1>sign up------|");
        System.out.println("|------2>Log in-------|");
        System.out.println("|---------------------|");
    }
    public void dashboardMenu(){
        System.out.println("------------Dashboard------------");
        System.out.println("|------1>Loan registration------|");//ثبتنام وام
        System.out.println("|------2>loan repayment---------|");//پرداخت وام
        System.out.println("|------3>Registered loans-------|");//وام های ثبت شده
        System.out.println("|------4>Exit-------------------|");
        System.out.println("|-------------------------------|");
    }

     public void thirdMenu(){
        System.out.println("---------Loan registration---------");
        System.out.println("|------1>tuition loan-------------|");//شهریه
        System.out.println("|------2>Education loan-----------|");//تحصیلی
        System.out.println("|------3>Housing loan-------------|");//ودیعه مسکن
        System.out.println("|------4>Back---------------------|");
        System.out.println("|---------------------------------|");
    }


}
