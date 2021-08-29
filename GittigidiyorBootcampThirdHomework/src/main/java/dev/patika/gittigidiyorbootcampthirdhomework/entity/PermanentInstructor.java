package dev.patika.gittigidiyorbootcampthirdhomework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data //This annotation includes @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode and @ToString
@NoArgsConstructor
@Entity
public class PermanentInstructor extends Instructor{
    private double fixedSalary;
}
