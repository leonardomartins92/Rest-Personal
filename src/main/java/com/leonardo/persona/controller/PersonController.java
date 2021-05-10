package com.leonardo.persona.controller;

import com.leonardo.persona.dto.PersonDTO;
import com.leonardo.persona.entity.Person;
import com.leonardo.persona.exception.PersonNotFoundException;
import com.leonardo.persona.service.PersonService;
import com.leonardo.persona.dto.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.getAllPerson();
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@RequestBody @Valid PersonDTO personDTO,@PathVariable Long id)throws PersonNotFoundException {
        return personService.updateById(personDTO, id);
    }

    @GetMapping("/{id}")
    public PersonDTO listById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.deleteById(id);
    }
}
