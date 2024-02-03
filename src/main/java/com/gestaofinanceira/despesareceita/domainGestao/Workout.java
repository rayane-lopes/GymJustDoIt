package com.gestaofinanceira.despesareceita.domainGestao;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "workout")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "workout_id")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workout_id;

    private String name;

    private String description;

    private String level;

    @ManyToMany
    @JoinTable(name = "workout_exercise",
            joinColumns = @JoinColumn(name = "workout_fk", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "exercise_fk", nullable = true)
    )
    List<Exercise> exercises;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id_fk")
    Client client_workout;
}
