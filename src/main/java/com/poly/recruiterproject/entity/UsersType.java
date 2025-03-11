package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users_type")
@NoArgsConstructor
@AllArgsConstructor
public class UsersType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "user_type_id")
    private int userTypeId;

    @Column(unique = true, name = "user_type_name")
    private String userTypeName;

    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL)
    private List<User> userType;

}
