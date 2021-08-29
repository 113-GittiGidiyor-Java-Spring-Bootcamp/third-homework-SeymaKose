package dev.patika.gittigidiyorbootcampthirdhomework.repository;

import dev.patika.gittigidiyorbootcampthirdhomework.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    List<Course> findByCourseName(String courseName); //Query creation from method names

    void deleteByCourseName(String courseName);
}
