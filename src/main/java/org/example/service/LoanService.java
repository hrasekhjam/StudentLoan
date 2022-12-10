package org.example.service;

import org.example.entity.Loans;
import org.example.entity.Students;
import org.example.repository.LoanRepository;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class LoanService {
    LoanRepository loanRepository = new LoanRepository();

    public void createLoan(Loans loans){
        loanRepository.create(loans);
    }

    public void updateUser(Loans loans , Long id){
        loanRepository.update(loans,id);
    }
    public List<Loans> findAllLoansById(Students st){
        return loanRepository.findAll(st);
    }

}
