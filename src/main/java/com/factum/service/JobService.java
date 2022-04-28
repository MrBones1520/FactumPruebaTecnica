package com.factum.service;

import com.factum.model.Job;
import com.factum.repository.JobRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class JobService {

    private JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }


    @PostConstruct
    private void createCatalago(){
        this.jobRepository.save(new Job("Desarrollador", 35000.00));
        this.jobRepository.save(new Job("Recursos Humanos", 15000.00));
        this.jobRepository.save(new Job("Contabilidad", 45000.00));
    }

    public Job get(long id){
        return this.jobRepository.findById(id).orElse(null);
    }

    public boolean existsById(long id){
        return this.jobRepository.existsById(id);
    }

}
