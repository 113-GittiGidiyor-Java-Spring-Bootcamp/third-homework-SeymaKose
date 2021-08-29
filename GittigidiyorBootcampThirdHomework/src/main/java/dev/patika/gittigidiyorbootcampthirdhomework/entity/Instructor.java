package dev.patika.gittigidiyorbootcampthirdhomework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data //This annotation includes @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode and @ToString
@NoArgsConstructor
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String address;
    private String phoneNumber;
}
