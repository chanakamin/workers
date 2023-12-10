package com.workers.repositories;

import org.springframework.data.repository.CrudRepository;

import com.workers.models.Unit;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UnitRepository extends CrudRepository<Unit, Integer> {
    
}