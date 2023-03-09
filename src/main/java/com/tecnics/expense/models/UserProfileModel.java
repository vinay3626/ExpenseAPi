/* package com.tecnics.expense.models;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.tecnics.expense.utils.userRoleEnum;

@Entity
@Table(name ="user_profile")
public class UserProfileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    @NotBlank
    private String email;

    @Enumerated(EnumType.STRING)
    private userRoleEnum role;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private AuthModel userAuth;

    @CreationTimestamp
    private Timestamp created;

     @UpdateTimestamp
    private Timestamp updated;

    public UserProfileModel() {
    }

    public UserProfileModel(String firstName, String lastName, @NotBlank String email, userRoleEnum role
           ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public userRoleEnum getRole() {
        return role;
    }

    public void setRole(userRoleEnum role) {
        this.role = role;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public AuthModel getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(AuthModel userAuth) {
        this.userAuth = userAuth;
    }

    

    
    
}
 */