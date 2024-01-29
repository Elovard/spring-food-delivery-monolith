package com.dydzik.foodpetproject.configuration;

import com.dydzik.foodpetproject.dto.LoginRequestDto;
import com.dydzik.foodpetproject.entity.Client;
import com.dydzik.foodpetproject.repository.ClientRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

	private final ClientRepository clientRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	@Value("${jwt.token.expiration}")
	private int expiration;

	@Value("${jwt.token.secret}")
	private String secret;

	public String generateJwtTokenDependingOnClientType(LoginRequestDto dto) {
		Client client = clientRepository.findByUsername(dto.getUsername()).orElseThrow();
		if (passwordEncoder.matches(dto.getPassword(), client.getPassword())) {
			return Jwts.builder()
					.subject(client.getUsername())
					.claim("email", client.getEmail())
					.claim("type", dto.getType().toUpperCase())
					.issuedAt(new Date())
					.signWith(SignatureAlgorithm.HS256, Decoders.BASE64.decode(secret))
					.expiration(new Date(System.currentTimeMillis() + expiration))
					.compact();
		}
		throw new RuntimeException();
	}
}
