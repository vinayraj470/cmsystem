package com.jvscode.cmsystem.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Data
@Getter
@Setter
@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String  lastName;

    @NaturalId
    private String phoneNo;
    @NaturalId
    private String emailId;

    private String city;
    private String country;
    private String address;
}
