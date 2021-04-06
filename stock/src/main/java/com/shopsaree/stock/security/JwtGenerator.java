package com.shopsaree.stock.security;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;

import com.shopsaree.stock.constants.GenericConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {
	
    public String generate(UserDetailsBean jwtUser) {
    	
    	Calendar date = new GregorianCalendar();
		// reset hour, minutes, seconds and millis
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);

		// next day
		date.add(Calendar.DAY_OF_MONTH, 1);

        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getFristName());
        claims.put(GenericConstants.JWT_DEVICE_ID, jwtUser.getDeviceIdentifier());
        claims.put(GenericConstants.JWT_LAST_NAME, jwtUser.getLastName());
        claims.put(GenericConstants.JWT_MOBILE_NUMBER, jwtUser.getMobileNumber());
        claims.put(GenericConstants.JWT_ROLE, jwtUser.getRole());
        claims.put(GenericConstants.FCM_TOKEN, jwtUser.getFcmToken());
        claims.put(GenericConstants.EMAIL, jwtUser.getEmail());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(date.getTime())//the midnight, that's the first second of the day.
                .signWith(SignatureAlgorithm.HS512, "Stock")
                .compact();
    }
}
