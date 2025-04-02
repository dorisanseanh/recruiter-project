package com.poly.recruiterproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer skillId;

    @Column(name = "experience_level")
    private String experienceLevel;

    @Column(name = "name")
    private String skillName;

    @Column(name = "years_of_experience")
    private String yearOfExperience;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_seeker_profile")
    private JobSeekerProfile jobSeekerProfile;

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(String yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public Skills() {
    }

    public Skills(Integer skillId, String experienceLevel, String skillName, String yearOfExperience, JobSeekerProfile jobSeekerProfile) {
        this.skillId = skillId;
        this.experienceLevel = experienceLevel;
        this.skillName = skillName;
        this.yearOfExperience = yearOfExperience;
        this.jobSeekerProfile = jobSeekerProfile;
    }
}
