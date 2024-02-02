package com.gestaofinanceira.despesareceita.controller;

import com.gestaofinanceira.despesareceita.domainGestao.Workout;
import com.gestaofinanceira.despesareceita.domainGestao.WorkoutExercise;
import com.gestaofinanceira.despesareceita.service.WorkoutExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workout_exercises")
public class WorkoutExerciseController {
    @Autowired
    private WorkoutExerciseService workoutExerciseService;

    @GetMapping
    public List<WorkoutExercise> getAllWorkouts(){
        return workoutExerciseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutExercise> getWorkoutById(@PathVariable Long id) {
        Optional<WorkoutExercise> workoutExercise = workoutExerciseService.findById(id);
        if (workoutExercise.isPresent()) {
            return new ResponseEntity<>(workoutExercise.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkoutExercise createWorkoutExercise(@RequestBody WorkoutExercise workoutExercise) {
        WorkoutExercise workoutExercise1 = workoutExerciseService.exerciseInWorkout(workoutExercise.getExercise(), workoutExercise.getWorkout());
        return workoutExerciseService.save(workoutExercise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutExercise> updateWorkoutExercise(@PathVariable Long id, @RequestBody Workout updatedWorkoutExercise) {
        Optional<WorkoutExercise> workoutExerciseOptional = workoutExerciseService.findById(id);
        if (workoutExerciseOptional.isPresent()) {
            WorkoutExercise workoutExercise = workoutExerciseOptional.get();
            workoutExercise.setId(updatedWorkoutExercise.getId());

            workoutExerciseService.save(workoutExercise);

            return ResponseEntity.ok(workoutExercise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteWorkout(@PathVariable Long id) {
        try {
            workoutExerciseService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
