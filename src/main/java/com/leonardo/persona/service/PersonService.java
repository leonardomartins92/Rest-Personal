package com.leonardo.persona.service;

import com.leonardo.persona.dto.MessageResponseDTO;
import com.leonardo.persona.dto.PersonDTO;
import com.leonardo.persona.entity.Person;
import com.leonardo.persona.exception.PersonNotFoundException;
import com.leonardo.persona.mapper.PersonMapper;
import com.leonardo.persona.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personTosave = personMapper.toModel(personDTO);
        personRepository.save(personTosave);
         return MessageResponseDTO
                .builder()
                .message("Saved Person with ID " + personTosave.getId())
                .build();
    }

    public List<PersonDTO> getAllPerson(){
     List<Person> persons =  personRepository.findAll();
     return persons.stream()
             .map(personMapper::toDTO)
             .collect(Collectors.toList());

     /* Opcao 2
     List<PersonDTO> personDTOS = new ArrayList<>();
     for(var person : persons){
         personDTOS.add(personMapper.toDTO(person));
     }
       return personDTOS;*/
    }

    public PersonDTO getById(Long id) throws PersonNotFoundException {
          return personMapper.toDTO(verifyIfExists(id));
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);

    }

    public MessageResponseDTO updateById(PersonDTO personDTO, Long id) throws PersonNotFoundException {
        verifyIfExists(id);
       return createPerson(personDTO);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return   personRepository.findById(id)
                .orElseThrow(()->new PersonNotFoundException(id));
    }
}
