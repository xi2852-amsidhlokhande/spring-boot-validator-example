package com.amsidh.mvc.controller;

import com.amsidh.mvc.controller.response.GenericResponse;
import com.amsidh.mvc.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/persons")
@Slf4j
public class PersonController {

    @PostMapping
    public ResponseEntity savePerson(@RequestBody @Valid Person person) {
        log.info("Person saved successfully {}", person);
        return ResponseEntity.ok(GenericResponse.builder().data(person).build());
    }
}
