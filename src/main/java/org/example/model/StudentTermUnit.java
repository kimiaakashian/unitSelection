package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
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
public class StudentTermUnit extends BaseEntity<Long> {
    @ManyToOne(cascade = CascadeType.REMOVE)
    private StudentTerm studentTerm;
    @ManyToOne
    private Lesson lesson;

    @Min(value = 0L, message = "The value must be positive")
    @Max(value = 20L, message = "The value must be less than 20")
    private double Grade;
}
