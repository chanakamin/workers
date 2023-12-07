package com.example.workers.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.workers.models.Unit;
import com.example.workers.models.Worker;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface WorkerRepository extends CrudRepository<Worker, Integer> {
    List<Worker> findByUnitId(Integer UnitId);

    Optional<Worker> findByUnitIdAndId(Integer unitId, Integer Id);
    
}