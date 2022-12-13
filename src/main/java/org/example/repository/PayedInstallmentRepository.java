package org.example.repository;


import org.example.entity.Installment;
import org.example.entity.PayedInstallment;
import org.example.entity.Students;
import org.example.entity.enums.LoanType;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class PayedInstallmentRepository extends BaseRepository<PayedInstallment>{
    public PayedInstallmentRepository() {
        super("PayedInstallment", PayedInstallment.class );
    }
    public List<PayedInstallment> findAll(Students st) {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select p from PayedInstallment p where p.students=:students")
                .setParameter("students",st);
        List list = query.list();
        session.close();
            if (list.isEmpty())
                return null;
        return list;
    }
//    public Installment findInst(Students st,LoanType loanType) {
//        Session session = sessionFactory.openSession();
//        Query query = session.createQuery("select i from Installment i where i.loanType=:loanType And i.students=:students")
//                .setParameter("loanType",loanType)
//                .setParameter("students",st);
//        List<Installment> list = query.list();
//        session.close();
//        if (list.isEmpty())
//            return null;
//
//        return list.get(0);
//    }
//    public String installmentPayment(LoanType loanType, Students students){
//        return  "select i from Installment i where i.loanType=: "+loanType+" And i.students=: "+students;
//    }


}
