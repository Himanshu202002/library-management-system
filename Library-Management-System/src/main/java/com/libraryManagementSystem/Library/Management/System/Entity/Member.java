package com.libraryManagementSystem.Library.Management.System.Entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "members")
public class Member {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;

    @CreatedDate
    private LocalDateTime membershipDate= LocalDateTime.now();
}
