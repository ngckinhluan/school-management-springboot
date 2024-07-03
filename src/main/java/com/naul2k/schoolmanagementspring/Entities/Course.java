package com.naul2k.schoolmanagementspring.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id_gen")
    @SequenceGenerator(name = "course_id_gen", sequenceName = "course_courseid_seq", allocationSize = 1)
    @Column(name = "courseid", nullable = false)
    private Integer id;

    @Column(name = "coursename", nullable = false, length = 100)
    private String coursename;

    @Column(name = "coursedescription", length = Integer.MAX_VALUE)
    private String coursedescription;

}