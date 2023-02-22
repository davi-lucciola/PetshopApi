package io.com.petshop.application;

import io.com.petshop.infrastructure.models.entities.TutorEntity;
import io.com.petshop.infrastructure.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    @Autowired
    private TutorRepository tutorRepository;

    @GetMapping
    public ResponseEntity<List<TutorEntity>> findAll() {
        return new ResponseEntity<>(tutorRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity cadastrarTutor(@RequestBody TutorEntity tutor) {
        tutor = tutorRepository.saveAndFlush(tutor);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
