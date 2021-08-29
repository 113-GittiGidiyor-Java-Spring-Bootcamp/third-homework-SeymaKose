package dev.patika.gittigidiyorbootcampthirdhomework.repository;

import dev.patika.gittigidiyorbootcampthirdhomework.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

    List<Instructor> findByFullName(String fullName); //Query creation from method names

    void deleteByFullName(String fullName);
}
