package com.thevmin.movie_store_with_security.movies;

import com.thevmin.movie_store_with_security.reviews.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String rating;

    private String director;

    private String language;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "cover_image_link")
    private String coverImageLink;

    @Column(name = "tailor_link")
    private String tailorLink;

    @OneToMany(mappedBy = "reviewedMovie")
    private List<Review> MovieReviews;

}
