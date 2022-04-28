package com.factum.service;

import com.factum.model.Gender;
import com.factum.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GenderService {

    private GenderRepository genderRepository;

    @Autowired
    public GenderService(GenderRepository genderRepository){
        this.genderRepository = genderRepository;
    }

    @PostConstruct
    public void createCatalago(){
        this.genderRepository.save(new Gender("Masculino"));
        this.genderRepository.save(new Gender("Femenino"));
    }

}
