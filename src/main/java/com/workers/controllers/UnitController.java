package com.workers.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workers.models.Unit;
import com.workers.services.UnitService;

@Controller
@CrossOrigin
@RequestMapping(path="/unit") 
public class UnitController {
  @Autowired 
  private UnitService unitService;

  @PostMapping(path="") 
  public @ResponseBody Unit addNewUnit (@RequestBody Unit newUnit) {
    
    return this.unitService.createUnit(newUnit);
  }

  @DeleteMapping("{id}")
  public @ResponseBody void  deleteEmployee(@PathVariable Integer id) {
    this.unitService.deleteUnit(id);
  }

  @GetMapping("{id}")
  @ResponseBody
  public Optional<Unit> getUnit(@PathVariable Integer id) {
    Optional<Unit> unit = this.unitService.getUnit(id);

    return unit;
  }

  @GetMapping(path="")
  public @ResponseBody Iterable<Unit> getAllUsers() {
    return this.unitService.getAllUnits();
  }
}