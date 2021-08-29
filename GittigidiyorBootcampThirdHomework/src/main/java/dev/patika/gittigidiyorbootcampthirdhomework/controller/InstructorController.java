package dev.patika.gittigidiyorbootcampthirdhomework.controller;

import dev.patika.gittigidiyorbootcampthirdhomework.entity.Instructor;
import dev.patika.gittigidiyorbootcampthirdhomework.entity.Student;
import dev.patika.gittigidiyorbootcampthirdhomework.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {
    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/instructors")
    public Instructor saveInstructor(@RequestBody Instructor instructor){
        return instructorService.save(instructor);
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable int id){
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/instructors")
    public Instructor updateInstructor(@RequestBody Instructor instructor){
        return instructorService.update(instructor);
    }

    @DeleteMapping("/instructors/{id}")
    public void deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
    }

    @DeleteMapping("/instructors")
    public void deleteInstructor(@RequestBody Instructor instructor){
        instructorService.deleteByObject(instructor);
    }

    @GetMapping("/findByFullName/{fullName}")
    public List<Instructor> getStudentWithFullName(@PathVariable String fullName){
        return instructorService.getInstructorWithFullName(fullName);
    }

    @DeleteMapping("/deleteByFullName/{fullName}")
    public String deleteByFullName(@PathVariable String fullName){
        instructorService.deleteByFullName(fullName);
        return "Deleted!";
    }

}
