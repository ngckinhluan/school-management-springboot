package com.naul2k.schoolmanagementspring.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lecturer")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecturer_id_gen")
    @SequenceGenerator(name = "lecturer_id_gen", sequenceName = "lecturer_lecturerid_seq", allocationSize = 1)
    @Column(name = "lecturerid", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

}