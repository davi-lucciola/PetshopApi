package io.com.petshop.application.controllers;

import io.com.petshop.infrastructure.models.BasicResponse;
import io.com.petshop.infrastructure.models.entities.PetEntity;
import io.com.petshop.infrastructure.models.entities.TutorEntity;
import io.com.petshop.infrastructure.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/petshop/tutor")
public class PetshopController {

    @Autowired
    private TutorRepository tutorRepository;

    @GetMapping
    public ResponseEntity<List<TutorEntity>> findAll() {
        return new ResponseEntity<>(tutorRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorEntity> findById(@PathVariable Long id) {
        return new ResponseEntity<>(tutorRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity cadastrarTutor(@RequestBody TutorEntity tutor) {
        tutor = tutorRepository.saveAndFlush(tutor);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity alterarTutor(@RequestBody TutorEntity pet) {
        if (pet.getId() != null) {
            tutorRepository.saveAndFlush(pet);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTutor(@PathVariable Long id) {
        tutorRepository.deleteTutorById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}