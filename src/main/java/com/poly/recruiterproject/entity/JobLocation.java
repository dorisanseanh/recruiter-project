package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "job_location")
public class JobLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "jobLocationId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobPostActivity> jobPosts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public JobLocation(int id, String city, String country, String state) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.state = state;
    }

    public JobLocation() {
    }

    @Override
    public String toString() {
        return "JobLocation{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", jobPosts=" + jobPosts +
                '}';
    }
}



