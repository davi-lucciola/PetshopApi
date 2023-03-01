package io.com.petshop.application.controllers;

import io.com.petshop.domain.models.AdocaoPayload;
import io.com.petshop.domain.models.responses.BasicResponse;
import io.com.petshop.domain.services.PetshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/petshop")
public class PetshopController {

    @Autowired
    private PetshopService petshopService;

    @PostMapping("/adotar-pet")
    public ResponseEntity<BasicResponse> adotarPet(@RequestBody AdocaoPayload adotarPayload) {

        BasicResponse response = petshopService.adotarPet(adotarPayload);

        return new ResponseEntity(response, HttpStatus.OK);
    }
}