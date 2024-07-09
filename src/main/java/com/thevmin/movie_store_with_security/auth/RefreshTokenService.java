package com.thevmin.movie_store_with_security.auth;

import com.thevmin.movie_store_with_security.user.User;
import com.thevmin.movie_store_with_security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    private final UserRepository userRepository;

    public RefreshToken createRefreshToken(User user){
        String userName = user.getEmail();
        Optional<RefreshToken> optionalRefreshToken= refreshTokenRepository.findByUser(user);
        if (optionalRefreshToken.isPresent()){
            try {
                return verifyExpiration(optionalRefreshToken.get());
            }catch (RuntimeException e){
            }
        }
        RefreshToken refreshToken = RefreshToken.builder()
                .user(userRepository.findByEmail(userName).orElseThrow())
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(600000))
                .build();
        return refreshTokenRepository.save(refreshToken);
    }

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if (token.getExpiryDate().compareTo(Instant.now())<0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token is expired. Please make a new login..!");
        }
        return token;
    }
}
