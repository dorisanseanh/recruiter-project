package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skills")
@AllArgsConstructor
@NoArgsConstructor
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int skillId;

    @Column(name = "experience_level")
    private String experienceLevel;

    @Column(name = "name")
    private String skillName;

    @Column(name = "years_of_experience")
    private String yearOfExperience;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_seeker_profile")
    private JobSeekerProfile jobSeekerProfileobSeekeProfile;


    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
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

    public JobSeekerProfile getJobSeekerProfileobSeekeProfile() {
        return jobSeekerProfileobSeekeProfile;
    }

    public void setJobSeekerProfileobSeekeProfile(JobSeekerProfile jobSeekerProfileobSeekeProfile) {
        this.jobSeekerProfileobSeekeProfile = jobSeekerProfileobSeekeProfile;
    }
}
