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

    @OneToOne
    @MapsId // sử dụng user_account_id làm khóa chính và khóa ngoại
    @JoinColumn(name = "user_account_id")
    private JobSeekeProfile jobSeekeProfile;


}
