package com.jobReport.jobReport.repository;

import com.jobReport.jobReport.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  JobRepo extends JpaRepository<Job, Long> {
    public List<Job> findByStudid(Long id); //custom repository method
}
