package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Getter
@Setter
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


}
