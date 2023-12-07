package com.example.workers.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.workers.models.Worker;
import com.example.workers.repositories.WorkerRepository;
import com.example.workers.services.WorkerService;

@Controller
@RequestMapping(path="unit/{unitId}/worker") 
public class WorkerController {

  @Autowired private WorkerService workerService;

  @PostMapping(path="") 
  public @ResponseBody ResponseEntity  addNewWorker (@PathVariable Integer unitId, @RequestBody Worker newWorker) {
    
    try {
        Worker worker = this.workerService.saveWorker(newWorker, unitId);
        return new ResponseEntity<Worker>(worker, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("{id}")
  public @ResponseBody void  deleteWorker(@PathVariable Integer id) {
    this.workerService.deleteWorker(id);
  }

  @GetMapping("{id}")
  @ResponseBody
  public Optional<Worker> getWorker(@PathVariable Integer id, @PathVariable Integer unitId) {
    return this.workerService.findWorkerOfUnit(id, unitId);
  }

  @GetMapping(path="")
  public @ResponseBody Iterable<Worker> getAllUsers(@PathVariable Integer unitId) {
    return this.workerService.findWorkersOfUnit(unitId);
  }
}