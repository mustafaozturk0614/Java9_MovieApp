package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private String name;
    private String image;
    private String country;
    private Double rating;

    private Double summary;
    private LocalDate premired;
    private String url;
    @ElementCollection
    private List<Long> genres;
    @ElementCollection
    private List<Long> comments;
}
