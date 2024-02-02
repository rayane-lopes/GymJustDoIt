package com.gestaofinanceira.despesareceita.controller;

import com.gestaofinanceira.despesareceita.domainGestao.TypeExercise;
import com.gestaofinanceira.despesareceita.service.TypeExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/type_exercises")
public class TypeExerciseController {
    @Autowired
    private TypeExerciseService typeExerciseService;

    @GetMapping
    public List<TypeExercise> getAllTypesExercises(){
        return typeExerciseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeExercise> getTypeExerciseById(@PathVariable Long id) {
        Optional<TypeExercise> typeExercise = typeExerciseService.findById(id);
        if (typeExercise.isPresent()) {
            return new ResponseEntity<>(typeExercise.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TypeExercise createTypeExercise(@RequestBody TypeExercise typeExercise) {
        return typeExerciseService.save(typeExercise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeExercise> updateTypeExercise(@PathVariable Long id, @RequestBody TypeExercise updatedTypeExercise) {
        Optional<TypeExercise> typeExerciseOptional = typeExerciseService.findById(id);
        if (typeExerciseOptional.isPresent()) {
            TypeExercise typeExercise = typeExerciseOptional.get();
            typeExercise.setName(updatedTypeExercise.getName());
            typeExercise.setDescription(updatedTypeExercise.getDescription());

            typeExerciseService.save(typeExercise);

            return ResponseEntity.ok(typeExercise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteWorkout(@PathVariable Long id) {
        try {
            typeExerciseService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
