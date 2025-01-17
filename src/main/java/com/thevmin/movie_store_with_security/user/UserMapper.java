package com.thevmin.movie_store_with_security.user;

import com.thevmin.movie_store_with_security.user.dto.UserProfileDTO;

public class UserMapper {

    private UserMapper(){
        throw new IllegalStateException("Utility class");
    }

    public static UserProfileDTO mapUserToUserProfileDTO(User user) {
        return UserProfileDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .profileImageUrl(user.getProfileImageUrl())
                .build();

    }
}
