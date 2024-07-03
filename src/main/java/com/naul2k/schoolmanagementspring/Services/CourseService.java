package com.naul2k.schoolmanagementspring.Services;

import com.naul2k.schoolmanagementspring.Entities.Course;
import com.naul2k.schoolmanagementspring.Repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository = null;
    
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }
    
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
    
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }
    
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
    
}
