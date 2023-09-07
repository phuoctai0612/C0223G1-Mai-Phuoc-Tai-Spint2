package com.example.movie.securiry.jwt;

import com.example.movie.model.Account;
import com.example.movie.securiry.accountpincal.AccountPrinciple;
import com.example.movie.service.IAccountService;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import java.util.Date;
@Component
public class JwtProvider {
    @Autowired
    private IAccountService accountService;
    private static final Logger logger= LoggerFactory.getLogger(JwtProvider.class);
    private String jwtSecret="sieuem2002@gmail.com";
    private int jwtExpiration=86400;
    public String createToken(Authentication authentication){
        AccountPrinciple accountPrinciple= (AccountPrinciple) authentication.getPrincipal();
        return Jwts.builder().setSubject(accountPrinciple.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+jwtExpiration*1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e){
            logger.error("Ivalid JWT sinature ->Message: {}", e);
        } catch (MalformedJwtException e){
            logger.error("The token invalid format ->Message: {}",e);
        } catch (UnsupportedJwtException e){
            logger.error("Unsupported JWT toekn ->Message: {}",e);
        } catch (ExpiredJwtException e){
            logger.error("Expired JWT Token -> Message: {}",e);
        } catch (IllegalArgumentException e){
            logger.error("Jwt claims string is empty -> Message {}",e);
        }
        return false;
    }
    public String getUserNameFromToken(String token){
        String userName = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        return userName;
    }
    public Account getUserNameToken(String token){
        String userName = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        Account account=accountService.findByEmail(userName);
        return account;
    }
}
