package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.var;
import org.example.entity.enums.Degree;
import org.example.entity.enums.UniType;
import org.example.utils.Password;

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
    private Long studentId;
    @Column(name = "university_name")
    private String uniName;
    @Column(name = "university_type")
    private UniType uniType;
    private Long yearOfUniEntrance;
    private Degree degree;
    private String userName;
    private String passWord;

//    public Students() {
//        Password password = new Password(8);
//        setPassWord(password);
//    }
}