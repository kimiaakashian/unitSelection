package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.base.entity.BaseEntity;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professor extends BaseEntity<Long> {
    private String firstName;
    private String lastName;
    private String professorCode;
    @Enumerated(EnumType.STRING)
    private ProfessorType professorType;
    private double salary;
    @OneToOne
    private Users user;

}
