package github.sagubr.security;

import jakarta.inject.Singleton;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

@Singleton
public class PasswordGenerator {

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = LOWER.toUpperCase(Locale.ROOT);
    private static final String DIGITS = "0123456789";
    private static final String ALPHA_NUMERIC = LOWER + UPPER + DIGITS;
    private static final Random RANDOM = new SecureRandom();

    public static String generate(int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(ALPHA_NUMERIC.charAt(RANDOM.nextInt(ALPHA_NUMERIC.length())));
        }
        return password.toString();
    }

}
