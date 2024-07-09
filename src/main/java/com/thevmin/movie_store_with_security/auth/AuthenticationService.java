package com.thevmin.movie_store_with_security.auth;

import com.thevmin.movie_store_with_security.auth.dtos.*;
import com.thevmin.movie_store_with_security.configurations.JwtService;
import com.thevmin.movie_store_with_security.user.Role;
import com.thevmin.movie_store_with_security.user.RoleService;
import com.thevmin.movie_store_with_security.user.User;
import com.thevmin.movie_store_with_security.user.UserRepository;
import com.thevmin.movie_store_with_security.user.dto.UserAuthenticationResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;
    private final RoleService roleService;

    public AuthenticationResponseDTO register(RegisterRequestDTO request) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getUser().get());
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .profileImageUrl(request.getProfileImageUrl())
                .roles(roles)
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user);
        Date date = jwtService.tokenExpiration(jwtToken);
        return AuthenticationResponseDTO.builder()
                .token(new TokenDTO(jwtToken, refreshToken.getToken(), date))
                .user(new UserAuthenticationResponseDTO(user.getId(), user.getName(), user.getEmail()))
                .build();
    }

    public AuthenticationResponseDTO login(AuthenticationRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user);
        Date date = jwtService.tokenExpiration(jwtToken);
        return AuthenticationResponseDTO.builder()
                .token(new TokenDTO(jwtToken, refreshToken.getToken(), date))
                .user(new UserAuthenticationResponseDTO(user.getId(), user.getName(), user.getEmail()))
                .build();
    }

    public AuthenticationResponseDTO getNewToken(RefreshTokenRequestDTO token) {
        return refreshTokenService.findByToken(token.getToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String jwtToken = jwtService.generateToken(user);
                    Date date = jwtService.tokenExpiration(jwtToken);
                    return AuthenticationResponseDTO.builder()
                            .token(new TokenDTO(jwtToken, token.getToken(), date))
                            .user(new UserAuthenticationResponseDTO(user.getId(), user.getName(), user.getEmail()))
                            .build();
                }).orElseThrow(() -> new RuntimeException("Refresh token is Invalid"));


    }
}
