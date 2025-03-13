package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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

    @OneToMany(mappedBy = "userTypeId", cascade = CascadeType.ALL)
    private List<Users> users;

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }
}
