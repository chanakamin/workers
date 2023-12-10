package com.workers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workers.exceptions.ExistingWorkerException;
import com.workers.models.Unit;
import com.workers.models.Worker;
import com.workers.repositories.WorkerRepository;

@Service
public class WorkerService {
    @Autowired 
    private WorkerRepository workerRepository;

    @Autowired private UnitService unitService;

    public Worker saveWorker(Worker newWorker, Integer unitId) throws Exception {
        Optional<Unit> unit = this.unitService.getUnit(unitId);
        Optional<Worker> existingWorker = this.workerRepository.findByWorkerNumber(newWorker.getWorkerNumber());
        if (existingWorker.isPresent()) {
            throw new ExistingWorkerException("existing-worker-worker-number");
        }
        if (unit.isPresent()) {
            newWorker.setUnit(unit.get());
            return this.workerRepository.save(newWorker);
        } else {
            throw new Exception("Unit not exists");
        }
        
    }

    public void deleteWorker(Integer workerId) {
        this.workerRepository.deleteById(workerId);
    }

    public Optional<Worker> findWorkerOfUnit(Integer workerId, Integer unitId) {
        return this.workerRepository.findByUnitIdAndId(unitId, workerId);
    }

    public List<Worker> findWorkersOfUnit(Integer unitId) {
        return this.workerRepository.findByUnitId(unitId);
    }
}
