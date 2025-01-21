package github.sagubr.security;

import github.sagubr.model.UserDto;
import github.sagubr.services.BCryptPasswordEncoderService;
import github.sagubr.services.UserService;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationFailureReason;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.provider.HttpRequestAuthenticationProvider;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Collections;
import java.util.Optional;

@Singleton
@Requires(beans = UserService.class)
public class AuthenticationProvider<B> implements HttpRequestAuthenticationProvider<B> {

    private final UserService userService;
    private final BCryptPasswordEncoderService passwordEncoder;

    @Inject
    public AuthenticationProvider(UserService userService, BCryptPasswordEncoderService passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthenticationResponse authenticate(
            @Nullable HttpRequest<B> httpRequest,
            @NonNull AuthenticationRequest<String, String> authenticationRequest
    ) {

        String identity = (String) authenticationRequest.getIdentity();
        String secret = (String) authenticationRequest.getSecret();

        try {
            Optional<UserDto> userOptional = userService.findByUsername(identity);

            if (userOptional.isPresent()) {
                UserDto user = userOptional.get();

                if (passwordEncoder.matches(secret, user.getPassword())) {
                    return AuthenticationResponse.success(identity, Collections.singletonList(user.getRoles().toString()));
                }
            }

            return AuthenticationResponse.failure(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH);
        } catch (Exception e) {
            return AuthenticationResponse.failure(AuthenticationFailureReason.USER_NOT_FOUND);
        }
    }
}

