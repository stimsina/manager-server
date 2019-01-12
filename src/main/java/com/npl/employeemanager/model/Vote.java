package com.npl.employeemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "vote")
@Table(name = "vote")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vote implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "empUser")
    private EmpUser empUser;

    @Column(name = "participant")
    private Participant participant;

    @Column(name = "voteDate")
    private LocalDateTime voteDate=LocalDateTime.now();

    @Column(name = "rating")
    @ColumnDefault("1")
    private Integer rating;

    public Vote() {
        super();
    }

    public Vote(EmpUser empUser, Participant participant, LocalDateTime voteDate, Integer rating) {
        this.empUser = empUser;
        this.participant = participant;
        this.voteDate = voteDate;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public EmpUser getEmpUser() {
        return empUser;
    }

    public void setEmpUser(EmpUser empUser) {
        this.empUser = empUser;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public LocalDateTime getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(LocalDateTime voteDate) {
        this.voteDate = voteDate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
