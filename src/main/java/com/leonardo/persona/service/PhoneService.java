package com.leonardo.persona.service;


import com.leonardo.persona.module.Phone;
import com.leonardo.persona.repository.PhoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    private PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

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
