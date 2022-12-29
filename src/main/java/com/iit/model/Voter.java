package com.iit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "voter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voter {
    @Id
    private String nic;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private boolean isActive;
    private String address;
}
