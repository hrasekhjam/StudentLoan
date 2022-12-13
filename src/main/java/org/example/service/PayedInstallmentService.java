package org.example.service;

import org.example.entity.Installment;
import org.example.entity.PayedInstallment;
import org.example.entity.Students;
import org.example.entity.enums.LoanType;
import org.example.repository.InstallmentRepository;
import org.example.repository.PayedInstallmentRepository;

import java.util.List;

public class PayedInstallmentService {
    PayedInstallmentRepository payedInstallmentRepository = new PayedInstallmentRepository();

    public void createInstallmentPayed(PayedInstallment payedInstallment){
        payedInstallmentRepository.create(payedInstallment);
    }

//    public void updateUser(Installment installment , Long id){
//        payedInstallmentRepository.update(installment,id);
//    }
    public List<PayedInstallment> findAllPayedInstallment(Students st){
        return payedInstallmentRepository.findAll(st);
    }
//
//    public Installment findInstallment (Students students, LoanType loanType){
//        return payedInstallmentRepository.findInst(students,loanType);
//    }


}
