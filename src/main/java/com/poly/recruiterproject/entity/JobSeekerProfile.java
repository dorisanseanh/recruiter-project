package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "job_seeker_profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerProfile {
    @Id
    @GeneratedValue
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
    private User user;


}
