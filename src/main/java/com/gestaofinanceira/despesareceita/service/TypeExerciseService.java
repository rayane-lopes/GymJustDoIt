package com.gestaofinanceira.despesareceita.service;
import com.gestaofinanceira.despesareceita.domainGestao.TypeExercise;
import com.gestaofinanceira.despesareceita.repository.TypeExerciseRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter
@Service
public class TypeExerciseService {
    @Autowired
    private TypeExerciseRepository typeExerciseRepository;
    public List<TypeExercise> getAllTypesExercises(){return this.typeExerciseRepository.findAll();}

    public List<TypeExercise> findAll() {
        return typeExerciseRepository.findAll();
    }

    public Optional<TypeExercise> findById(Long id) {
        return typeExerciseRepository.findById(id);
    }

    public TypeExercise save(TypeExercise typeExercise) {
        return typeExerciseRepository.save(typeExercise);
    }

    public void deleteById(Long id) {
        typeExerciseRepository.deleteById(id);
    }
}
