package com.pbl5.helpers;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BcryptPassword {
    public static String HashPW(String password) {
        String Salt = BCrypt.gensalt("$2b", 10);
        return BCrypt.hashpw(password, Salt);
    }
}
