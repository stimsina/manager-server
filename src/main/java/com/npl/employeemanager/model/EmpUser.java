package com.npl.employeemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "emp_user")
@Table(name = "emp_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmpUser implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "user_name",unique = true)
    @NotNull
    @Email
    private String userName;

    @Column(columnDefinition = "boolean default false")
    private Boolean isAdmin=false;

    @Column(columnDefinition = "boolean default true")
    private Boolean isActive=true;

    @Column(name = "last_login")
    private LocalDateTime loginDateTime;

    @Column(name = "remaining_votes",columnDefinition = "int default 50")
    private int remainingVotes=50;

    // password not saved to this table, handled by firebase auth
    @Column
    @Transient
    private String password;

    // standard setters and getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() { return firstName;  }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setActive(Boolean active) { isActive = active; }

    public Boolean getActive() { return isActive;}

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public LocalDateTime getLoginDateTime() { return loginDateTime; }

    public void setLoginDateTime(LocalDateTime loginDateTime) { this.loginDateTime = loginDateTime; }

    public void setPassword(String password) { this.password = password; }

    public String getPassword() { return password;}

    public void setRemainingVotes(int remainingVotes) { this.remainingVotes = remainingVotes; }

    public int getRemainingVotes() { return remainingVotes; }
}
