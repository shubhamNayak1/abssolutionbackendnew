package com.qms.backend.training.Conference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference,Integer> {

    @Query("SELECT c FROM Conference c JOIN FETCH c.location WHERE c.id = :id")
    Optional<Conference> findByIdWithLocationName(@Param("id") int id);

    @Query("SELECT c FROM Conference c JOIN FETCH c.location")
    List<Conference> findAllWithLocationName();

}
