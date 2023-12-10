package com.workers.controllers;

import java.util.Optional;

import org.hibernate.engine.jdbc.env.internal.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workers.exceptions.ExistingWorkerException;
import com.workers.models.Worker;
import com.workers.services.WorkerService;

@Controller
@CrossOrigin
@RequestMapping(path="unit/{unitId}/worker") 
public class WorkerController {

  @Autowired private WorkerService workerService;

  @PostMapping(path="") 
  public @ResponseBody ResponseEntity  addNewWorker (@PathVariable Integer unitId, @RequestBody Worker newWorker) {
    
    try {
        Worker worker = this.workerService.saveWorker(newWorker, unitId);
        return new ResponseEntity<Worker>(worker, HttpStatus.CREATED);
    } catch(ExistingWorkerException e) {
        return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
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
  public ResponseEntity getWorker(@PathVariable Integer id, @PathVariable Integer unitId) {
    Optional<Worker> worker = this.workerService.findWorkerOfUnit(id, unitId);
    if (worker.isPresent()) {
      return new ResponseEntity<Worker>(worker.get(), HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.NOT_FOUND);
  }

  @GetMapping(path="")
  public @ResponseBody Iterable<Worker> getAllUsers(@PathVariable Integer unitId) {
    return this.workerService.findWorkersOfUnit(unitId);
  }
}