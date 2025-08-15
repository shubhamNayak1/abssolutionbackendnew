package com.qms.backend.training.Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingTypeRepository extends JpaRepository<TrainingType,Integer> {

    @Query("SELECT c FROM TrainingType c JOIN FETCH c.department WHERE c.id = :id")
    Optional<TrainingType> findByIdWithDepartmentName(@Param("id") int id);

    @Query("SELECT c FROM TrainingType c JOIN FETCH c.department")
    List<TrainingType> findAllWithDepartmentName();

}
