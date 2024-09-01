package com.api.v1.utils.book;

import java.security.SecureRandom;

public class IsbnGeneratorUtil {

    public static String generate() {
        long firstNumber = 1000000000000L;
        long lastNumber = 9999999999999L;
        long isbn = new SecureRandom().nextLong(firstNumber, lastNumber+1);
        return String.valueOf(isbn);
    }

}
