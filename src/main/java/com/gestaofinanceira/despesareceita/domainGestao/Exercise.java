package com.gestaofinanceira.despesareceita.domainGestao;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "exercise")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "exercise_id")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exercise_id;

    private String name;

    @ManyToMany(mappedBy = "exercises")
    List<Workout> workouts;

    @ManyToOne
    @JoinColumn(name = "type_exercise_id")
    TypeExercise typeExercise;
}
