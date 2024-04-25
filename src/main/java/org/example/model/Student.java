package org.example.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Student extends BaseEntity<Long> {
    private  String firstName;
    private String LastName;
    private String StudentCode;
    @OneToOne
    private Users user;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    private Set<StudentTerm> studentTerms;
}
