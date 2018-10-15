package com.foodhomie.cook.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.foodhomie.cook.models.requests.CookReq;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.GenerationType.*;

@Entity
@Data
@Table (name = "cook_beta")
@JsonIgnoreProperties
public class Cook implements Serializable {
    @Id
    @GeneratedValue(strategy = TABLE )
    //@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="cook_id", nullable = false)
    private int cook_id;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "date_created", nullable = true)
    private Date dateCreated;
    @Column(name = "date_modified", nullable = true)
    private Date dateModified;



    private enum STATUS{
        NEW,
        ACTIVE,
        BLOCKED,
        BANNED
    }

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "cook")
    @PrimaryKeyJoinColumn
    private CookProfile cookProfile;


    // Default Constructor
    public Cook() {
    }

    // Constructor
    public Cook(String email, String password, Date dateCreated, Date dateModified) {
        this.email = email;
        this.password = password;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    // Constructor with CookReq Object - For Get Method
    public Cook(CookReq cookReq) {
        this.email = cookReq.getEmail();
        this.password = cookReq.getPassword();
    }

    //Constructor with Cook object - For Update Method
    public Cook(Cook cook) {
        this.email = cook.getEmail();
        this.password = cook.getPassword();
        this.dateCreated = cook.getDateCreated();
        this.dateModified = cook.getDateModified();
    }

    // Getters & Setters
    public int getId() {
        return cook_id;
    }

    public void setId(int id) {
        this.cook_id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    // CookProfile Getter & Setter
    public CookProfile getCookProfile() {
        return cookProfile;
    }

    public void setCookProfile(CookProfile cookProfile) {
        this.cookProfile = cookProfile;
    }


    @Override
    public String toString() {
        return "Cook{" +
                "id='" + cook_id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                '}';
    }
}
