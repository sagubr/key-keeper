package github.sagubr.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String hashPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return passwordEncoder.matches(plainPassword, hashedPassword);
    }

    public static void main(String[] args) {
        String plainPassword = "myPassword";
        String hashedPassword = hashPassword(plainPassword);

        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Password matches: " + checkPassword(plainPassword, hashedPassword));
    }
}

