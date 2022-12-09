package org.example.service;

import org.example.entity.Loans;
import org.example.entity.Students;
import org.example.exceptions.InvalidUsernamePasswordException;
import org.example.exceptions.UserNotFoundException;
import org.example.repository.LoanRepository;
import org.example.repository.StudentRepository;
import org.example.securiy.SecurityUtils;

public class LoanService {
    LoanRepository loanRepository = new LoanRepository();

    public void createLoan(Loans loans){
        loanRepository.create(loans);
    }

    public void updateUser(Loans loans , Long id){
        loanRepository.update(loans,id);
    }
//    public Students findById(Long id){
//        return studentRepository.findById(id);
//    }
}
