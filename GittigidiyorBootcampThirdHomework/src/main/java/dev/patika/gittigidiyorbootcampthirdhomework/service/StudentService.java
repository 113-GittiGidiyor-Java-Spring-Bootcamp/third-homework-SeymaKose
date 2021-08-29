package dev.patika.gittigidiyorbootcampthirdhomework.service;

import dev.patika.gittigidiyorbootcampthirdhomework.entity.Student;
import dev.patika.gittigidiyorbootcampthirdhomework.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student>{

    private final StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true) //Provides performance benefits for find/read operations
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Iterable<Student> studentIter = studentRepository.findAll();
        studentIter.iterator().forEachRemaining(studentList::add); //This format is from Java8 Stream API
        return studentList;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteByObject(Student student) {
        studentRepository.delete(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    public List<?> getGendersWithGrouping(){
        return studentRepository.getGendersWithGrouping();
    }

    public List<Student> getStudentWithFullName(String fullName) {
        return studentRepository.findByFullName(fullName);
    }

    @Transactional
    public void deleteByFullName(String fullName) {
        studentRepository.deleteByFullName(fullName);
    }
}
