package com.naul2k.schoolmanagementspring;

import com.naul2k.schoolmanagementspring.Entities.Lecturer;
import com.naul2k.schoolmanagementspring.Services.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecturers")
public class LecturerController {
    
    private final LecturerService lecturerService;
    
    @Autowired
    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping
    public ResponseEntity<List<Lecturer>> getAllLecturers() {
        List<Lecturer> lecturers = lecturerService.getAllLecturers();
        return new ResponseEntity<>(lecturers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecturer> getLecturerById(@PathVariable int id) {
        Lecturer lecturer = lecturerService.getLecturerById(id);
        return lecturer != null ? new ResponseEntity<>(lecturer, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Lecturer> addLecturer(@RequestBody Lecturer lecturer) {
        Lecturer createdLecturer = lecturerService.addLecturer(lecturer);
        return new ResponseEntity<>(createdLecturer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lecturer> updateLecturer(@PathVariable int id, @RequestBody Lecturer lecturer) {
        Lecturer updatedLecturer = lecturerService.updateLecturer(id, lecturer);
        return updatedLecturer != null ? new ResponseEntity<>(updatedLecturer, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecturer(@PathVariable int id) {
        lecturerService.deleteLecturer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
