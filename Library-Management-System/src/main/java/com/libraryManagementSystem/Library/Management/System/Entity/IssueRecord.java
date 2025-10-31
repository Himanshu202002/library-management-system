package com.libraryManagementSystem.Library.Management.System.Entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection = "issues")
public class IssueRecord {

    @Id
    private String id;
    private String bookId;
    private String memberId;

    private LocalDate issueDate= LocalDate.now();
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean returned= false;

    @CreatedDate
    private LocalDateTime createdAt= LocalDateTime.now();
}
