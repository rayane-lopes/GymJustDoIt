package com.gestaofinanceira.despesareceita.domainGestao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table (name = "workout_exercise")
public class WorkoutExercise {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;


    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

}
