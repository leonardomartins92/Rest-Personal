package com.leonardo.persona.service;


import com.leonardo.persona.entity.Phone;
import com.leonardo.persona.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    public void createPhone(Phone phone){
        phoneRepository.save(phone);
    }

    public List<Phone> getAllPhone(){
        return phoneRepository.findAll();
    }

    public Phone getById(Long id){
        return phoneRepository.findById(id).get();
    }
}
