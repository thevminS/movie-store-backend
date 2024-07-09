package com.thevmin.movie_store_with_security.user;

import com.thevmin.movie_store_with_security.reviews.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String password;

    @Column(unique = true)
    private String email;

//    @Enumerated(EnumType.STRING)
//    private Role role;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @Column(name = "profile_image")
    private String profileImageUrl;

    @OneToMany(
            mappedBy = "reviewOwner"
    )
    private List<Review> userReviews;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        for (Role role : this.getRoles()) {
            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
        }
        return auths;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
