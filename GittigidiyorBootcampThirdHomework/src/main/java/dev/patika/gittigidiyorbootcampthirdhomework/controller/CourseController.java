package dev.patika.gittigidiyorbootcampthirdhomework.controller;

import dev.patika.gittigidiyorbootcampthirdhomework.entity.Course;
import dev.patika.gittigidiyorbootcampthirdhomework.entity.Student;
import dev.patika.gittigidiyorbootcampthirdhomework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course){
        return courseService.save(course);
    }

    @GetMapping("/courses{id}")
    public ResponseEntity<Course> findById(@PathVariable int id){
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return courseService.update(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourseById(@PathVariable int id){
        courseService.deleteById(id);
    }

    @DeleteMapping("/courses")
    public void deleteCourse(@RequestBody Course course){
        courseService.deleteByObject(course);
    }

    @GetMapping("/findByCourseName/{courseName}")
    public List<Course> getCourseWithCourseName(@PathVariable String courseName){
        return courseService.getCourseWithCourseName(courseName);
    }

    @DeleteMapping("/deleteByCourseName/{courseName}")
    public String deleteByCourseName(@PathVariable String courseName){
        courseService.deleteByCourseName(courseName);
        return "Deleted!";
    }

}
