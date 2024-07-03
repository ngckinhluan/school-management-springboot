package com.naul2k.schoolmanagementspring.Services;

import com.naul2k.schoolmanagementspring.Entities.Lecturer;
import com.naul2k.schoolmanagementspring.Repositories.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerService {

    private final LecturerRepository lecturerRepository;

    @Autowired
    public LecturerService(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    public Lecturer getLecturerById(int id) {
        return lecturerRepository.findById(id).orElse(null);
    }
    
    public Lecturer addLecturer(Lecturer lecturer) {
        Optional<Lecturer> existingLecturer = lecturerRepository.findByEmail(lecturer.getEmail());
        if (existingLecturer.isPresent()) {
            throw new IllegalArgumentException("A lecturer with this email already exists.");
        }
        return lecturerRepository.save(lecturer);
    }

    public Lecturer updateLecturer(Integer id, Lecturer lecturer) {
        Optional<Lecturer> existingLecturerOptional = lecturerRepository.findById(id);
        if (existingLecturerOptional.isPresent()) {
            Lecturer existingLecturer = existingLecturerOptional.get();
            if (!existingLecturer.getEmail().equals(lecturer.getEmail())) {
                Optional<Lecturer> emailCheck = lecturerRepository.findByEmail(lecturer.getEmail());
                if (emailCheck.isPresent()) {
                    throw new IllegalArgumentException("A lecturer with this email already exists.");
                }
            }
            existingLecturer.setFirstname(lecturer.getFirstname());
            existingLecturer.setLastname(lecturer.getLastname());
            existingLecturer.setEmail(lecturer.getEmail());
            return lecturerRepository.save(existingLecturer);
        } else {
            throw new IllegalArgumentException("Lecturer not found.");
        }
    }
    
    public void deleteLecturer(int id) {
        lecturerRepository.deleteById(id);
    }
}
