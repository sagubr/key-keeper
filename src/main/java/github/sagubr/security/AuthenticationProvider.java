package github.sagubr.security;

import github.sagubr.entities.Permissions;
import github.sagubr.models.UserAuthenticateDto;
import github.sagubr.services.UserService;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.annotation.Value;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationFailureReason;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.provider.HttpRequestAuthenticationProvider;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.*;
import java.util.stream.Collectors;

@Singleton
@Requires(beans = UserService.class)
public class AuthenticationProvider<B> implements HttpRequestAuthenticationProvider<B> {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Value("${master.username}")
    private String masterUsername;

    @Value("${master.password}")
    private String masterPassword;

    @Inject
    public AuthenticationProvider(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthenticationResponse authenticate(
            @Nullable HttpRequest<B> httpRequest,
            @NonNull AuthenticationRequest<String, String> authenticationRequest
    ) {
        String identity = authenticationRequest.getIdentity();
        String secret = authenticationRequest.getSecret();

        if (isSuperUser(identity, secret)) {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("name", "SUPER USUARIO");
            return AuthenticationResponse.success(identity, Collections.singletonList("SUPER_USER"), attributes);
        }

        try {
            Optional<UserAuthenticateDto> userOptional = userService.findByUsername(identity);

            if (userOptional.isPresent()) {
                UserAuthenticateDto user = userOptional.get();
                if (passwordEncoder.matches(secret, user.password())) {
                    Set<Permissions> roles = user.assignment().getPermissions();
                    List<String> roleNames = roles.stream()
                            .map(Enum::name)
                            .collect(Collectors.toList());

                    Map<String, Object> attributes = new HashMap<>();
                    attributes.put("name", user.name());

                    return AuthenticationResponse.success(identity, roleNames, attributes);
                }
            }
            return AuthenticationResponse.failure(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH);
        } catch (Exception e) {
            return AuthenticationResponse.failure(AuthenticationFailureReason.USER_NOT_FOUND);
        }
    }


    private boolean isSuperUser(String username, String password) {
        return username.equals(masterUsername) && password.equals(masterPassword);
    }

}
