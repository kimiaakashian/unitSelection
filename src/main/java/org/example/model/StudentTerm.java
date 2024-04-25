package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.base.entity.BaseEntity;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentTerm extends BaseEntity<Long> {
    @ManyToOne(cascade = CascadeType.REMOVE )
    private Student student;
    @ManyToOne
    private Term term;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private StudentTerm previousTerm;
    private Integer sumOfUnits;
    private Double averageGrade;

    @OneToMany(mappedBy = "studentTerm", cascade = CascadeType.REMOVE)
    private Set<StudentTermUnit> children;
}
