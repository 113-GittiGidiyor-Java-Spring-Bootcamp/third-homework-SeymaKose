package dev.patika.gittigidiyorbootcampthirdhomework.service;

import dev.patika.gittigidiyorbootcampthirdhomework.entity.Course;
import dev.patika.gittigidiyorbootcampthirdhomework.entity.Student;
import dev.patika.gittigidiyorbootcampthirdhomework.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course>{

    private final CourseRepository courseRepository;
    @Override
    @Transactional(readOnly = true) //Provides performance benefits for find/read operations
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> studentIter = courseRepository.findAll();
        studentIter.iterator().forEachRemaining(courseList::add); //This format is from Java8 Stream API
        return courseList;
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public void deleteByObject(Course course) {
        courseRepository.delete(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getCourseWithCourseName(String courseName) {
        return courseRepository.findByCourseName(courseName);
    }

    @Transactional
    public void deleteByCourseName(String courseName) {
        courseRepository.deleteByCourseName(courseName);
    }
}
