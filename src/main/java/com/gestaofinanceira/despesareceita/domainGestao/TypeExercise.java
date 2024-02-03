package com.gestaofinanceira.despesareceita.domainGestao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "type_exercise")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "tp_exercise_id")
public class TypeExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tp_exercise_id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "typeExercise")
    List<Exercise> exercises;
}
