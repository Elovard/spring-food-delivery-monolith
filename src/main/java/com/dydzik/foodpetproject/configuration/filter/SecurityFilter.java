package com.dydzik.foodpetproject.configuration.filter;

import com.dydzik.foodpetproject.configuration.principal.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Set;

@Component
@Slf4j
public class SecurityFilter extends OncePerRequestFilter {

	@Value("${jwt.token.secret}")
	private String secret;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (authorization == null) {
			filterChain.doFilter(request, response);
			return;
		}

		try {
			String token = authorization.substring(7);

			Claims payload = Jwts.parser().setSigningKey(Decoders.BASE64.decode(secret)).build().parseClaimsJws(token).getPayload();
			String username = payload.getSubject();
			String email = payload.get("email", String.class);
			String type = payload.get("type", String.class);

			UserPrincipal userPrincipal = new UserPrincipal(username, email, UserPrincipal.Type.valueOf(type.toUpperCase()));

			log.info("Principal: {}", userPrincipal);

			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userPrincipal, token, Set.of(new SimpleGrantedAuthority("ROLE_USER")));
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);

			filterChain.doFilter(request, response);
		} catch (JwtException | IndexOutOfBoundsException e) {
			filterChain.doFilter(request, response);
		}
	}
}
