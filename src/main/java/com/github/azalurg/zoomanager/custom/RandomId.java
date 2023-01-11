package com.github.azalurg.zoomanager.custom;

public class RandomId {
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE = ALPHABET.length();

    public static String randomString( int length ) {
        StringBuilder sb = new StringBuilder( length );
        for( int i = 0; i < length; i++ )
            sb.append( ALPHABET.charAt( (int) (Math.random() * BASE) ) );
        return sb.toString();
    }
}
