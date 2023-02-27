package io.com.petshop.application.controllers;

import io.com.petshop.infrastructure.models.entities.PetEntity;
import io.com.petshop.infrastructure.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/petshop/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public ResponseEntity<List<PetEntity>> findAll() {
        return new ResponseEntity<>(petRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetEntity> findById(@PathVariable Long id) {
        return new ResponseEntity<>(petRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity cadastrarPet(@RequestBody PetEntity pet) {
        if (pet.getId() == null) {
            petRepository.saveAndFlush(pet);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity alterarPet(@RequestBody PetEntity pet) {
        if (pet.getId() != null) {
            petRepository.saveAndFlush(pet);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPet(@PathVariable Long id) {
        petRepository.deletePetById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping("/associar-pet/{tutorId}")
    public ResponseEntity associarPet(@RequestBody PetEntity pet, @PathVariable Long tutorId) {
        //...
        return null;
    }
}
