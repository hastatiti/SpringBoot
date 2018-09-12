package com.barbecue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private BarbecueUserDetailsService barbecueUserDetailsService;
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Override
	public boolean login(String username, String password) {
		UserDetails userDetails = barbecueUserDetailsService.loadUserByUsername(username);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password);
		authenticationManager.authenticate(token);
		boolean result = token.isAuthenticated();
		
		if(result) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		return result;
	}

}
