package com.gestaofinanceira.despesareceita.controller;

import com.gestaofinanceira.despesareceita.domainGestao.Workout;
import com.gestaofinanceira.despesareceita.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;

    @GetMapping
    public List<Workout> getAllWorkouts(){
        return workoutService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable Long id) {
        Optional<Workout> workout = workoutService.findById(id);
        if (workout.isPresent()) {
            return new ResponseEntity<>(workout.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutService.save(workout);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable Long id, @RequestBody Workout updatedWorkout) {
        Optional<Workout> workoutOptional = workoutService.findById(id);
        if (workoutOptional.isPresent()) {
            Workout workout = workoutOptional.get();
            workout.setName(updatedWorkout.getName());
            workout.setDescription(updatedWorkout.getDescription());
            workout.setLevel(updatedWorkout.getLevel());
            workout.setClient_workout(updatedWorkout.getClient_workout());
            workout.setExercises(updatedWorkout.getExercises());
            workoutService.save(workout);

            return ResponseEntity.ok(workout);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteWorkout(@PathVariable Long id) {
        try {
            workoutService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
