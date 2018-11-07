package org.zerock.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.MemberVO;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@Data
public class CustomUser extends User {
	
	private MemberVO vo;
	
	public CustomUser(MemberVO vo) {
		this(vo.getUserid(),vo.getUserpw(),true,true,true,true,
				vo.getAuthList().stream().
				map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList())
				);
		this.vo = vo;
	}
	

	public CustomUser(String username, String password, 
			boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
	}

	
	
}
