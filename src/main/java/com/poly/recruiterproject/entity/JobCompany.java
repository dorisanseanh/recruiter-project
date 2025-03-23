package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "job_company")
public class JobCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int jobCompanyId;

    @Column(name = "name")
    private String jobCompanyName;

    @Column(name = "logo")
    private String jobCompanyLogo;

    public int getJobCompanyId() {
        return jobCompanyId;
    }

    public void setJobCompanyId(int jobCompanyId) {
        this.jobCompanyId = jobCompanyId;
    }

    public String getJobCompanyName() {
        return jobCompanyName;
    }

    public void setJobCompanyName(String jobCompanyName) {
        this.jobCompanyName = jobCompanyName;
    }

    public String getJobCompanyLogo() {
        return jobCompanyLogo;
    }

    public void setJobCompanyLogo(String jobCompanyLogo) {
        this.jobCompanyLogo = jobCompanyLogo;
    }

    public JobCompany(int jobCompanyId, String jobCompanyName, String jobCompanyLogo) {
        this.jobCompanyId = jobCompanyId;
        this.jobCompanyName = jobCompanyName;
        this.jobCompanyLogo = jobCompanyLogo;
    }

    public JobCompany() {
    }
}
