package com.ismael.homework.main.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.ismael.homework.main.Config.JwtTokenUtil;
import com.ismael.homework.main.Service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService jwtInMemoryUserDetailsService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String,String > login(@RequestParam String username, @RequestParam String password) throws BadCredentialsException
	{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));;

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(username);

		final String token = jwtTokenUtil.generateToken(userDetails);
		Map<String,String> response = new HashMap<>();
		response.put("token",token);
		return response;
	}


}