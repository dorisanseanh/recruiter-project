package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "job_location")
public class JobLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int jobLocationId;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "jobLocation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobPostActivity> jobPosts;

    public int getJobLocationId() {
        return jobLocationId;
    }

    public void setJobLocationId(int jobLocationId) {
        this.jobLocationId = jobLocationId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<JobPostActivity> getJobPosts() {
        return jobPosts;
    }

    public void setJobPosts(List<JobPostActivity> jobPosts) {
        this.jobPosts = jobPosts;
    }

    public JobLocation(int jobLocationId, String city, String country, String state, List<JobPostActivity> jobPosts) {
        this.jobLocationId = jobLocationId;
        this.city = city;
        this.country = country;
        this.state = state;
        this.jobPosts = jobPosts;
    }
    public JobLocation() {

    }
}



