package dev.patika.gittigidiyorbootcampthirdhomework.repository;

import dev.patika.gittigidiyorbootcampthirdhomework.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("select s.gender, count(s.gender) from Student s group by s.gender") //JPQL Format
    List<?> getGendersWithGrouping(); //StudentGenderStatistics

    @Query(nativeQuery = true, value = "select gender as gender, count(gender) as count from student group by gender") //Standart SQL Format
    List<?> getGendersWithGroupingWithNativeQuery();

    List<Student> findByFullName(String fullName); //Query creation from method names

    void deleteByFullName(String fullName);

}
