package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Driver;
import com.example.demo.domain.DriverRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private final DriverRepository repository;

	@Autowired
	public UserDetailServiceImpl(DriverRepository userRepository) {
		this.repository = userRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	Driver curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
}
