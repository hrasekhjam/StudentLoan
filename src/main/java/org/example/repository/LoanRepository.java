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

}
