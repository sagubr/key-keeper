package github.sagubr.services;

import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Singleton
public class BCryptPasswordEncoderService {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String encode(@NotBlank @NonNull String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public boolean matches(@NotBlank @NonNull CharSequence rawPassword,
                           @NotBlank @NonNull String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
