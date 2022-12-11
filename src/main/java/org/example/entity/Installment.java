package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.enums.LoanType;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter

@Entity
@Table(name = "Installment")
public class Installment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private LoanType loanType;
    private String loanAmount;
    @Column(name = "Date")
    private LocalDate date;
    private long firstYear;
    private long secondYear;
    private long thirdYear;
    private long fourthYear;
    private long fifthYear;

    @OneToOne
    private Loans loans;
    @ManyToOne
    private Students students;

    public void setFirstYear(Long firstYear) {
        this.firstYear = firstYear;
        this.secondYear = 2*firstYear;
        this.thirdYear = 2*(2*firstYear);
        this.fourthYear = 2*(2*(2*firstYear));
        this.fifthYear = 2*(2*(2*(2*firstYear)));

    }
}

