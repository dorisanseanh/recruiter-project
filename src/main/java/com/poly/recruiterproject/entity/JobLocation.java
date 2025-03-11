package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "job_location")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int jobLocationId;

    @Column(name = "city")
    private String location;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "jobLocation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobPostActivity> jobPosts;
}



