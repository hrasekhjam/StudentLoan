package org.example.repository;


import org.example.entity.Loans;
import org.example.entity.Students;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class LoanRepository extends BaseRepository<Loans>{
    public LoanRepository() {
        super("Loans", Loans.class );
    }
    public List<Loans> findAll(Students st) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select l from Loans l where l.students=:students")
                .setParameter("students",st);
        List list = query.list();
        session.close();
        if (list.isEmpty())
            return null;

        return list;
    }


}
