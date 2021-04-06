package com.shopsaree.stock.security;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.shopsaree.stock.constants.GenericConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
	
	private static final Logger log = LogManager.getLogger(JwtValidator.class);
	
    @SuppressWarnings("unchecked")
	public UserDetailsBean validate(String token) {

      
        UserDetailsBean jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey("Stock")
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new UserDetailsBean();
            jwtUser.setFristName(body.getSubject());
            jwtUser.setRole((List<String>) body.get(GenericConstants.JWT_ROLE));
            jwtUser.setDeviceIdentifier((String) body.get(GenericConstants.JWT_DEVICE_ID));
            jwtUser.setLastName((String) body.get(GenericConstants.JWT_LAST_NAME));
            jwtUser.setMobileNumber((String) body.get(GenericConstants.JWT_MOBILE_NUMBER));
            jwtUser.setEmail((String) body.get(GenericConstants.EMAIL));
        }
        catch (Exception e) {
        	log.error("Exception"+e);
        }
        return jwtUser;
    }

	public boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	//retrieve expiration date from jwt token
	private Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = Jwts.parser()
                .setSigningKey("Stock")
                .parseClaimsJws(token)
                .getBody();
		return claimsResolver.apply(claims);
	}

}
