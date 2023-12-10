package com.workers.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workers.models.Unit;
import com.workers.repositories.UnitRepository;

@Service
public class UnitService {
    @Autowired UnitRepository unitRepository;

    public Optional<Unit> getUnit(Integer id) {
        return this.unitRepository.findById(id);
    }

    public Iterable<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public void deleteUnit(Integer id) {
        unitRepository.deleteById(id);
    }

    public Unit createUnit(Unit newUnit) {
        return unitRepository.save(newUnit);
    }
}
