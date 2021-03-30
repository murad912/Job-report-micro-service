package com.jobReport.jobReport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Job {
    @Id
    @GeneratedValue
    private Long id;

    private String companyName;
    private String status;
    private  Long studid;

    public Job() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStudid() {
        return studid;
    }

    public void setStudid(Long studid) {
        this.studid = studid;
    }

    @Override
    public String toString() {
        return "Job{" +
                "companyName='" + companyName + '\'' +
                ", status='" + status + '\'' +
                ", studid=" + studid +
                '}';
    }

}
