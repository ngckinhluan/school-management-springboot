package com.naul2k.schoolmanagementspring.Repositories;

import com.naul2k.schoolmanagementspring.Entities.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer>{
    Optional<Lecturer> findByEmail(String email);
}
