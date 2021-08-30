package dev.patika.gittigidiyorbootcampthirdhomework;

import dev.patika.gittigidiyorbootcampthirdhomework.entity.Gender;
import dev.patika.gittigidiyorbootcampthirdhomework.entity.Student;
import dev.patika.gittigidiyorbootcampthirdhomework.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class GittigidiyorBootcampThirdHomeworkApplication  implements CommandLineRunner{

    private static final Logger LOG = LoggerFactory.getLogger(GittigidiyorBootcampThirdHomeworkApplication.class);
    private StudentRepository studentRepository;
    @Autowired
    public GittigidiyorBootcampThirdHomeworkApplication(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(GittigidiyorBootcampThirdHomeworkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentRepository.save(new Student("Sal Sutor", LocalDate.of(1980,5,23), "4972 Ridge Oak Center", Gender.Female));
        studentRepository.save(new Student("Gianina Fishwick", LocalDate.of(1990,7,1), "1422 Vidon Park", Gender.Male));
        studentRepository.save(new Student("Danielle Linzee", LocalDate.of(1991,12,24), "57790 Northfield Point", Gender.Female));
        studentRepository.save(new Student("Dollie Bratchell", LocalDate.of(1995,4,7), "50 Nelson Junction", Gender.Female));
        studentRepository.save(new Student("Tessie Cozzi", LocalDate.of(1984,5,31), "6 Tennyson Pass", Gender.Male));
    }
}
