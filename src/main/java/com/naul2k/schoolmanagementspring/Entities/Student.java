package com.naul2k.schoolmanagementspring.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_gen")
    @SequenceGenerator(name = "student_id_gen", sequenceName = "student_studentid_seq", allocationSize = 1)
    @Column(name = "studentid", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name = "dateofbirth")
    private LocalDate dateofbirth;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

}