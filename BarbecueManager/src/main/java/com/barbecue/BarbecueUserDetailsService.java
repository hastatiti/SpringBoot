package com.barbecue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;

@Service
public class BarbecueUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		List<GrantedAuthority> authorities = new ArrayList<>();
		if (true) {
		authorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		}
		if (user==null) {
			throw new UsernameNotFoundException("username not found" + username);
		}
	return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), authorities);
	
	
	}
}
