package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job_seeker_profile")
public class JobSeekerProfile {
    @Id
    @Column(name = "user_account_id")
    private int userAccountId;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "employment_type")
    private String employmentType;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "state")
    private String state;

    @Column(name = "resume")
    private String resume;

    @Column(name = "work_authorization")
    private String workAuthorization;

    @OneToOne
    @MapsId // sử dụng user_account_id làm khóa chính và khóa ngoại
    @JoinColumn(name = "user_account_id")
    private Users user;

    public JobSeekerProfile(Users savedUser) {
        this.user = savedUser;
    }

    public JobSeekerProfile() {

    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
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

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getWorkAuthorization() {
        return workAuthorization;
    }

    public void setWorkAuthorization(String workAuthorization) {
        this.workAuthorization = workAuthorization;
    }

    public Users getUser() {
        return user;
    }

    public JobSeekerProfile(int userAccountId, String city, String country, String employmentType, String firstName, String lastName, String profilePhoto, String state, String resume, String workAuthorization, Users user) {
        this.userAccountId = userAccountId;
        this.city = city;
        this.country = country;
        this.employmentType = employmentType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePhoto = profilePhoto;
        this.state = state;
        this.resume = resume;
        this.workAuthorization = workAuthorization;
        this.user = user;
    }
}
