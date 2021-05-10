package com.leonardo.persona.service;

import com.leonardo.persona.dto.PersonDTO;
import com.leonardo.persona.entity.Person;
import com.leonardo.persona.mapper.PersonMapper;
import com.leonardo.persona.repository.PersonRepository;
import com.leonardo.persona.dto.MessageResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personTosave = personMapper.toModel(personDTO);
         return MessageResponseDTO
                .builder()
                .message("Created Person with ID " + personTosave.getId())
                .build();
    }

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public Person getById(Long id){
        return personRepository.findById(id).get();
    }
}
