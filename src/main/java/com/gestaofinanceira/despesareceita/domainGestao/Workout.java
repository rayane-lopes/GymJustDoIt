package com.gestaofinanceira.despesareceita.domainGestao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String level;

    @JsonBackReference
    @ManyToMany(mappedBy = "workouts")
    private List<Exercise> exercises = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id_client")
    private Client client;
}
