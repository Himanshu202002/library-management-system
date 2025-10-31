package com.libraryManagementSystem.Library.Management.System.Entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String category;
    private int availableCopies;
    private boolean available= true;

    @CreatedDate
    private LocalDateTime createdAt= LocalDateTime.now();
}
