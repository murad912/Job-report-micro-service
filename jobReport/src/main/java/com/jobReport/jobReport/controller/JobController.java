package com.jobReport.jobReport.controller;

import com.jobReport.jobReport.DTO.Student;
import com.jobReport.jobReport.model.Job;
import com.jobReport.jobReport.service.JobService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping()
public class JobController {


    @Autowired
    private JobService service;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${studenturl}")
    String studentUrl;
    @Value("${joburl}")
    String jobUrl;


    @PostMapping("/add")
    public Job add(@RequestBody Job s){
        return service.add(s);
    }
    //find student by Id then add Job if student exist
    @PostMapping("/addstudentjob/{id}") //localhost:8001/addstudentjob/5
        public Job addStudenJob(@PathVariable("id") Long id, @RequestBody Job j){
        Student s = restTemplate.getForObject("http://" + studentUrl + "/student/"+ id, Student.class ); //get url and class
        //getstudent
        if(s==null){
            return null;
        }else{
            j.setStudid(id);
            Job job = restTemplate.postForObject("http://" +jobUrl + "/add", j, Job.class);
            return  job;
        }



    }

    //Job class/service lay student file meterat using DTO
    @GetMapping("/getstudent/{id}")
   // @HystrixCommand
    public Student getStudent(@PathVariable("id") Long id){
        Student s = restTemplate.getForObject("http://" + studentUrl + "/student/"+ id, Student.class );
        if(s==null){
            return null;
        }
        return s;
    }

    @GetMapping()//get All Job
    @HystrixCommand(fallbackMethod = "getFallbackStudentJob")
    public List<Job> getAll(){
        return service.getAll();
    }

    public List<Job> getFallbackStudentJob() {
        List<Job> list = new ArrayList<>();
        Job emptyJob = new Job();
        emptyJob.setCompanyName("no company name");
        emptyJob.setStatus("no status");
        emptyJob.setStudid(null);

        list.add(emptyJob);

        return list;
    }

    @GetMapping("getbystudentid/{id}")
    public List<Job> getStudenId(@PathVariable("id") Long id){
        return service.getByStudentId(id);
    }

}
