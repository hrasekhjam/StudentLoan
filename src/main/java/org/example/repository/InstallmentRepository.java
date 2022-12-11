package org.example.repository;


import org.example.entity.Installment;
import org.example.entity.Loans;
import org.example.entity.Students;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class InstallmentRepository extends BaseRepository<Installment>{
    public InstallmentRepository() {
        super("Loans", Installment.class );
    }
//    public List<Loans> findAll(Students st) {
//        Session session = sessionFactory.openSession();
//        Query query = session.createQuery("select l from Loans l where l.students=:students")
//                .setParameter("students",st);
//        List list = query.list();
//        session.close();
//        if (list.isEmpty())
//            return null;
//
//        return list;
//    }


}
