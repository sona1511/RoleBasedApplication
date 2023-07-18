package com.rolebased.rolebasedappplication.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rolebased.rolebasedappplication.entity.Employee;

public class CustomUserDetail implements UserDetails {

	// defining feilds to convert emp to Usertails objet

	private String name;

	private String password;

	private List<GrantedAuthority> grantedAuthority;

	public CustomUserDetail(Employee employee) {

		name = employee.getEmpName();
		password = employee.getEmpPassword();
		grantedAuthority = Arrays.stream(employee.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthority;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
