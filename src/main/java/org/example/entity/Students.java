package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.enums.Degree;
import org.example.entity.enums.UniType;

import javax.persistence.*;
@Setter
@Getter

@Entity
@Table(name = "Students")
public class Students extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String lastName;
    private String fatherName;
    private String motherName;
    private Long sh_Number;
    private Long nationNumber;
    private String birthDate;
    private boolean isMarried;
    private String city;
    private String cardNumber;
    private String cvv2;
    private String cardPassword;
    private String partnerName;
    private String partnerLastName;
    private String partnerFatherName;
    private Long partnerNationNumber;
    private String partnerBirthDate;
    private Long studentId;
    @Column(name = "university_name")
    private String uniName;
    @Column(name = "university_type")
    private UniType uniType;
    private Long yearOfUniEntrance;
    private Degree degree;
    private String userName;
    private String passWord;
//    private boolean graduated;


}
