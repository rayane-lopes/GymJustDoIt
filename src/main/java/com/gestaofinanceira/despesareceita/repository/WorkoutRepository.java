package com.gestaofinanceira.despesareceita.repository;

import com.gestaofinanceira.despesareceita.domainGestao.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository <Workout, Long> {
}
