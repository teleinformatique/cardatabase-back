package com.packt.cardatabase.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import static java.util.Collections.emptyList;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AuthenticationService {
    
    static final long EXPIRATIONTIME = 864__000__00;
    static final String SIGNINGKEY = "SecretKey";
    static final String PREFIX = "Bearer";

    //add token to authorization header
    public static void addToken(HttpServletResponse res, String username){

        String JwtToken = Jwts.builder()
            .setSubject(username)
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
            .signWith(SignatureAlgorithm.HS512, SIGNINGKEY)
            .compact();
        res.addHeader("Authorization" + PREFIX, JwtToken);
    }

    //get token
    public static Authentication getAuthentication(HttpServletRequest request){
        
        String token = request.getHeader("Authorization");
        if(token != null){
            String user = Jwts.parser()
                .setSigningKey(SIGNINGKEY)
                .parseClaimsJws(token.replace(PREFIX, ""))
                .getBody()
                .getSubject();
            
            if(user != null)
                return new UsernamePasswordAuthenticationToken(user, null, emptyList());
        }

        return null;
    }
}
