package org.generation.ecommerce.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;


import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter extends GenericFilterBean{
 public static String secret = "CH# La_cohorte_actual_123456789%%%";

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	// TODO Auto-generated method stub
	
	
	HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	String authHeader =  httpServletRequest.getHeader("authorization");
	if (  ("POST".equals(httpServletRequest.getMethod())) ||
			( ("GET".equals(httpServletRequest.getMethod())) && 
					(! httpServletRequest.getRequestURI().contains("/api/productos/") )  ) ||
		  ("PUT".equals(httpServletRequest.getMethod())) ||
		  ("DELETE".equals(httpServletRequest.getMethod()))
		) {
			if  ( authHeader ==null || !authHeader.startsWith("Bearer: ") ) {
				throw new ServletException("1. Invalid Token");
			}// if authHedaer
			String token = authHeader.substring(7);
			try {
			Claims claims = Jwts.parser().setSigningKey(secret)
					.parseClaimsJws(token).getBody();
			claims.forEach((key, value)->{
				System.out.println("key: " + key + " value: " + value);
			});
		}catch (SignatureException | MalformedJwtException | ExpiredJwtException  e) {
				throw new ServletException("2. Invalid Token.");
			}//catch 
	}// if methods
	chain.doFilter(request, response);	
}//doFilter


}//JwtFilter
