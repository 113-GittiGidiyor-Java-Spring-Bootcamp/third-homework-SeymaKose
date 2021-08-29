package dev.patika.gittigidiyorbootcampthirdhomework.service;

import dev.patika.gittigidiyorbootcampthirdhomework.entity.Instructor;
import dev.patika.gittigidiyorbootcampthirdhomework.entity.Student;
import dev.patika.gittigidiyorbootcampthirdhomework.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor>{

    private final InstructorRepository instructorRepository;

    @Override
    @Transactional(readOnly = true) //Provides performance benefits for find/read operations
    public List<Instructor> findAll() {
        List<Instructor> instructorList = new ArrayList<>();
        Iterable<Instructor> instructorIter = instructorRepository.findAll();
        instructorIter.iterator().forEachRemaining(instructorList::add); //This format is from Java8 Stream API
        return instructorList;
    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findById(int id) {
        return instructorRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    @Transactional
    public void deleteByObject(Instructor instructor) {
        instructorRepository.delete(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        instructorRepository.deleteById(id);
    }

    public List<Instructor> getInstructorWithFullName(String fullName) {
        return instructorRepository.findByFullName(fullName);
    }

    @Transactional
    public void deleteByFullName(String fullName) {
        instructorRepository.deleteByFullName(fullName);
    }
}
