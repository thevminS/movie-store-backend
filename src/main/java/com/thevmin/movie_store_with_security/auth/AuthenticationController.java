package com.thevmin.movie_store_with_security.auth;

import com.thevmin.movie_store_with_security.auth.dtos.*;
import com.thevmin.movie_store_with_security.configurations.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.AUTH_URL)
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final RevokedTokenService revokedTokenService;

    @PostMapping(Constants.REGISTER_URL_CONSTANT)
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping(Constants.LOGIN_URL_CONSTANT)
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody AuthenticationRequestDTO request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @PostMapping(Constants.REFRESH_URL_CONSTANT)
    public ResponseEntity<AuthenticationResponseDTO> getNewAccessToken(@RequestBody RefreshTokenRequestDTO token) {
        return ResponseEntity.ok(authenticationService.getNewToken(token));
    }

    @PostMapping(Constants.LOGOUT_URL_CONSTANT)
    @ResponseStatus(HttpStatus.OK)
    public void logout(@RequestBody LogoutRequestDTO logoutRequestDTO) {
        revokedTokenService.saveRevokedToken(logoutRequestDTO.getToken());
    }

}
