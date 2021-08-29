package dev.patika.gittigidiyorbootcampthirdhomework.controller;

import dev.patika.gittigidiyorbootcampthirdhomework.entity.Student;
import dev.patika.gittigidiyorbootcampthirdhomework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id){
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable int id){
        studentService.deleteById(id);
    }

    @DeleteMapping("/students")
    public void deleteStudent(@RequestBody Student student){
        studentService.deleteByObject(student);
    }

    @GetMapping("/getGendersWithGrouping")
    public List<?> getGendersWithGrouping(){
        return studentService.getGendersWithGrouping();
    }

    @GetMapping("/findByFullName/{fullName}")
    public List<Student> getStudentWithFullName(@PathVariable String fullName){
        return studentService.getStudentWithFullName(fullName);
    }

    @DeleteMapping("/deleteByFullName/{fullName}")
    public String deleteByFullName(@PathVariable String fullName){
        studentService.deleteByFullName(fullName);
        return "Deleted!";
    }
}
