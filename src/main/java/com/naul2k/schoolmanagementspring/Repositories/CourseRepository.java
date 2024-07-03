package com.naul2k.schoolmanagementspring.Repositories;

import com.naul2k.schoolmanagementspring.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
