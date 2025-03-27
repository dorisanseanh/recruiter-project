package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date postedDate;

    @Column(name = "remote")
    private String remote;

    @Column(name = "salary")
    private double salary;

    @Transient
    private Boolean isActive;

    @Transient
    private Boolean isSaved;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_company_id")
    private JobCompany jobCompany;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_location_id")
    private JobLocation jobLocation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "posted_by_id", referencedColumnName = "user_id")
    private Users postedById;

    public int getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(int jobPostId) {
        this.jobPostId = jobPostId;
    }

    public String getDescriptionOfJob() {
        return descriptionOfJob;
    }

    public void setDescriptionOfJob(String descriptionOfJob) {
        this.descriptionOfJob = descriptionOfJob;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getSaved() {
        return isSaved;
    }

    public void setSaved(Boolean saved) {
        isSaved = saved;
    }

    public JobCompany getJobCompany() {
        return jobCompany;
    }

    public void setJobCompany(JobCompany jobCompany) {
        this.jobCompany = jobCompany;
    }


    public JobLocation getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
    }

    public Users getPostedById() {
        return postedById;
    }

    public void setPostedById(Users postedById) {
        this.postedById = postedById;
    }

    public JobPostActivity() {
    }
}
