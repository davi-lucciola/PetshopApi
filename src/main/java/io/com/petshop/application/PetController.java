package io.com.petshop.application;

import io.com.petshop.infrastructure.models.entities.PetEntity;
import io.com.petshop.infrastructure.repository.PetRepository;
import io.com.petshop.infrastructure.repository.interfaces.PetJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public ResponseEntity<List<PetEntity>> findAll() {
        return new ResponseEntity<>(petRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity cadastrarPet(@RequestBody PetEntity pet) {
        pet = petRepository.saveAndFlush(pet);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
