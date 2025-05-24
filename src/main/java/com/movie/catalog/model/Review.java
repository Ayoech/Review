package com.movie.catalog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private Long bookId;
    private String comment;
    private int rating;

    // getters and setters
}

