package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "job_post_activity")
public class JobPostActivity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_post_id")
    private int jobPostId;

    @Column(name = "description_of_job")
    private String descriptionOfJob;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "posted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedDate;

    @Column(name = "remote")
    private Boolean remote;

    @Column(name = "salary")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "job_company_id")
    private JobCompany jobCompany;

    @ManyToOne
    @JoinColumn(name = "job_location_id")
    private JobLocation jobLocation;

    @ManyToOne
    @JoinColumn(name = "posted_by_id", referencedColumnName = "userId")
    private Users postedById; 
}
