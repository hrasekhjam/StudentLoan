package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.enums.LoanType;

import javax.persistence.*;

@Setter
@Getter

@Entity
@Table(name = "Loans")
public class Loans extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private LoanType loanType;
    private String loanAmount;
}
