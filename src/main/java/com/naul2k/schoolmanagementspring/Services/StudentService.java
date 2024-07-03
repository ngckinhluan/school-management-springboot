package com.naul2k.schoolmanagementspring.Services;

import com.naul2k.schoolmanagementspring.Entities.Student;
import com.naul2k.schoolmanagementspring.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.ReadOnlyBufferException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public ResponseEntity<?> addStudent(Student student) {
        try {
            return ResponseEntity.ok(studentRepository.save(student));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Email address already exists");
        }
    }

    public ResponseEntity<?> updateStudent(Integer id, Student student) {
        Optional<Student> existingStudentOptional = studentRepository.findById(id);
        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            Optional<Student> studentWithSameEmail = studentRepository.findByEmail(student.getEmail());
            if (studentWithSameEmail.isPresent() && !studentWithSameEmail.get().getId().equals(id)) {
                return ResponseEntity.badRequest().body("Email address already in use by another student");
            }
            existingStudent.setFirstname(student.getFirstname());
            existingStudent.setLastname(student.getLastname());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setDateofbirth(student.getDateofbirth());
            return ResponseEntity.ok(studentRepository.save(existingStudent));
        }
        return ResponseEntity.notFound().build();
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}

