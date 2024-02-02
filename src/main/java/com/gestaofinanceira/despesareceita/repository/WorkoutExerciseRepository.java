package com.gestaofinanceira.despesareceita.repository;

import com.gestaofinanceira.despesareceita.domainGestao.WorkoutExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutExerciseRepository extends JpaRepository <WorkoutExercise, Long> {
}
