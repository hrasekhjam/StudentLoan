package org.example.service;

import org.example.entity.Installment;
import org.example.entity.Loans;
import org.example.entity.Students;
import org.example.repository.InstallmentRepository;
import org.example.repository.LoanRepository;

import java.util.List;

public class InstallmentService {
    InstallmentRepository installmentRepository = new InstallmentRepository();

    public void createInstallment(Installment installment){
        installmentRepository.create(installment);
    }

    public void updateUser(Installment installment , Long id){
        installmentRepository.update(installment,id);
    }
//    public List<Loans> findAllLoansById(Students st){
//        return installmentRepository.findAll(st);
//    }

}
