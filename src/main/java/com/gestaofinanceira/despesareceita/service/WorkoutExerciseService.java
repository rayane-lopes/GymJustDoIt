package com.gestaofinanceira.despesareceita.service;

import com.gestaofinanceira.despesareceita.domainGestao.Exercise;
import com.gestaofinanceira.despesareceita.domainGestao.Workout;
import com.gestaofinanceira.despesareceita.domainGestao.WorkoutExercise;
import com.gestaofinanceira.despesareceita.repository.WorkoutExerciseRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter
@Service
public class WorkoutExerciseService {

    @Autowired
    private WorkoutExerciseRepository workoutExerciseRepository;

    public WorkoutExercise exerciseInWorkout(Exercise exercise, Workout workout) {
        WorkoutExercise workoutExercise = new WorkoutExercise();
        workoutExercise.setExercise(exercise);
        workoutExercise.setWorkout(workout);
        return workoutExerciseRepository.save(workoutExercise);
    }

    public List<WorkoutExercise> findAll() {
        return workoutExerciseRepository.findAll();
    }

    public Optional<WorkoutExercise> findById(Long id) {
        return workoutExerciseRepository.findById(id);
    }

    public WorkoutExercise save(WorkoutExercise workoutExercise) {
        return workoutExerciseRepository.save(workoutExercise);
    }

    public void deleteById(Long id) {
    }
}
