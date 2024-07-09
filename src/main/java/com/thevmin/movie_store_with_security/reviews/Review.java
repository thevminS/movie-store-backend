package com.thevmin.movie_store_with_security.reviews;

import com.thevmin.movie_store_with_security.movies.Movie;
import com.thevmin.movie_store_with_security.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String review;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User reviewOwner;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie reviewedMovie;



}
