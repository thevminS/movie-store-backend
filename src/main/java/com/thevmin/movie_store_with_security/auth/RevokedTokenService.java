package com.thevmin.movie_store_with_security.auth;

import com.thevmin.movie_store_with_security.configurations.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class RevokedTokenService {
    private final RevokedTokenRepository revokedTokenRepository;

    private final JwtService jwtService;

    public void saveRevokedToken(String token) {
        Date expirationDate = jwtService.tokenExpiration(token);
        if (expirationDate != null) {
            revokedTokenRepository.save(new RevokedToken(token, expirationDate));
        }
    }
}
