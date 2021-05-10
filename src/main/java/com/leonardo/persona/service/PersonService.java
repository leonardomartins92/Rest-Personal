package com.leonardo.persona.service;

import com.leonardo.persona.module.Person;
import com.leonardo.persona.repository.PersonRepository;
import com.leonardo.persona.utils.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
         return MessageResponseDTO
                .builder()
                .message("Created Person with ID " + personRepository.save(person).getId())
                .build();
    }

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public Person getById(Long id){
        return personRepository.findById(id).get();
    }
}
