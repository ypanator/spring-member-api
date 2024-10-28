package api.members.members_api.auth;

import api.members.members_api.entity.User;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import java.util.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

    // Example, for learning purposes only!
    private final static String base64Key = "Afy34H+AO4zC/sJve3dnfDXP5SjGOX/ZLzzUUJeUQEI=";
    private final static SecretKey key = generateKey(base64Key);

    public static String create(User user, Map<String, Object> claims) {
        return Jwts.builder()
            .claims(claims)
            .subject(user.getUsername())
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
            .signWith(key)
        .compact();
    }

    private static SecretKey generateKey(String base64Key) {
        return Keys.hmacShaKeyFor(Base64.getDecoder().decode(base64Key));
    }

    public static String getUsername(String jwt) {
        return getClaims(jwt).getSubject();
    }

    public static boolean isValid(String jwt, User user) {
        Claims claims = getClaims(jwt);

        return 
            claims.getSubject().equals(user.getUsername()) && 
            new Date().before(claims.getExpiration());
    }
    
    private static Claims getClaims(String jwt) {
        return Jwts.parser().verifyWith(key).build()
            .parseSignedClaims(jwt).getPayload();
    }
}
