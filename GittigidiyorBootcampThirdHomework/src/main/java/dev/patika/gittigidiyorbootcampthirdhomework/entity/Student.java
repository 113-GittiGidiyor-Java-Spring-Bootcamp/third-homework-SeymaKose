package dev.patika.gittigidiyorbootcampthirdhomework.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data //This annotation includes @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode and @ToString
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private LocalDate birthDate;
    private String address;
    private Gender gender;

   public Student(String fullName, LocalDate birthDate, String address, Gender gender) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
    }
}
