package com.jobReport.jobReport.service;


import com.jobReport.jobReport.model.Job;
import com.jobReport.jobReport.repository.JobRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public Job add(Job s){
        return repo.save(s);
    }

       public List<Job> getAll() {
        return repo.findAll();
    }

    public List<Job> getByStudentId(Long id){
        return repo.findByStudid(id);
    }

}
