package com.thevmin.movie_store_with_security.auth.dtos;

import com.thevmin.movie_store_with_security.user.dto.UserAuthenticationResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDTO {
    private TokenDTO token;
    private UserAuthenticationResponseDTO user;
}
