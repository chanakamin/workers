package com.example.workers.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workers.models.Unit;
import com.example.workers.repositories.UnitRepository;

@Service
public class UnitService {
    @Autowired UnitRepository unitRepository;

    public Optional<Unit> getUnit(Integer id) {
        return this.unitRepository.findById(id);
    }
}
