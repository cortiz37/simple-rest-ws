package com.sample.server.security;

import com.sample.server.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

@Component
public class JwtTokenProvider {

    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String TOKEN_HEADER = "Authorization";
    private static final String SECRET_KEY = Base64.getEncoder().encodeToString("jwt_password".getBytes());

    private static final int VALIDITY = 600000;

    private final UserService userService;

    public JwtTokenProvider(UserService userService) {
        this.userService = userService;
    }

    public static String createToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + VALIDITY);

        return Jwts.builder()
            .setClaims(new HashMap<>())
            .setSubject(username)
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact();
    }

    public Authentication getAuthentication(String token) {
        return userService.getByName(getUsername(token))
            .map(ud -> new UsernamePasswordAuthenticationToken(ud, "", ud.getAuthorities()))
            .orElse(null);
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader(TOKEN_HEADER);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        } catch (MalformedJwtException e) {
            return false;
        }
        return true;
    }
}