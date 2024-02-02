package com.gestaofinanceira.despesareceita.service;
import com.gestaofinanceira.despesareceita.domainGestao.Workout;
import com.gestaofinanceira.despesareceita.repository.WorkoutRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter
@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;
    public List<Workout> getAllWorkouts(){this.workoutRepository.findAll();
    return workoutRepository.findAll();
    }

    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public Optional<Workout> findById(Long id) {
        return workoutRepository.findById(id);
    }

    public Workout save(Workout workout) {
        return workoutRepository.save(workout);
    }

    public void deleteById(Long id) {
        workoutRepository.deleteById(id);
    }
}
