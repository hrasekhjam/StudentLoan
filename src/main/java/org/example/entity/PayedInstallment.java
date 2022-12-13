package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.enums.LoanType;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter

@Entity
@Table(name = "PayedInstallment")
public class PayedInstallment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private LocalDate installmentDate;
    private LocalDate localDate = LocalDate.now();
    private Long installmentAmount;
    private LoanType loanType;

    @ManyToOne
    private Students students;


}
