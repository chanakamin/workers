package com.example.workers.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.workers.models.Unit;
import com.example.workers.repositories.UnitRepository;

@Controller
@RequestMapping(path="/unit") 
public class UnitController {
  @Autowired 
  private UnitRepository unitRepository;

  @PostMapping(path="") 
  public @ResponseBody String addNewUnit (@RequestBody Unit newUnit) {
    unitRepository.save(newUnit);
    return "Saved";
  }

  @DeleteMapping("{id}")
  public @ResponseBody String  deleteEmployee(@PathVariable Integer id) {
    unitRepository.deleteById(id);
    return "deleted";
  }

  @GetMapping("{id}")
  @ResponseBody
  public Optional<Unit> getUnit(@PathVariable Integer id) {
    Optional<Unit> unit = unitRepository.findById(id);

    return unit;
  }

  @GetMapping(path="")
  public @ResponseBody Iterable<Unit> getAllUsers() {
    return unitRepository.findAll();
  }
}