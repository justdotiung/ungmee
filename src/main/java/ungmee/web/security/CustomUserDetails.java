package ungmee.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ungmee.web.entity.User;

public class CustomUserDetails extends User implements UserDetails {

	public CustomUserDetails() {
		// TODO Auto-generated constructor stub
	}

	public CustomUserDetails(User user) {
		setId(user.getId());
		setEmail(user.getEmail());
		setPw(user.getPw());
		setEnabled(user.getEnabled());
		setAuthority(user.getAuthority());

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(getAuthority()));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getPw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		boolean enabled = false;
		int result = getEnabled();

		if (result == 1)
			enabled = true;
		return enabled;
	}

}
