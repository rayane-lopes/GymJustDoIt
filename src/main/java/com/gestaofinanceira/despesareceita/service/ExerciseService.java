package com.gestaofinanceira.despesareceita.service;

import com.gestaofinanceira.despesareceita.domainGestao.Exercise;
import com.gestaofinanceira.despesareceita.repository.ExerciseRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter
@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;
    public List<Exercise> getAllExercises(){return this.exerciseRepository.findAll();}

    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    public Optional<Exercise> findById(Long id) {
        return exerciseRepository.findById(id);
    }

    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void deleteById(Long id) {
        exerciseRepository.deleteById(id);
    }
}
