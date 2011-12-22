package com.ekit.security.data;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.ekit.security.DESEDE;




@Entity
@Table(name = "DB_SECURITY_USER")
public class User  implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	   
	@Id
	@GeneratedValue(generator="UserSeq")
    @SequenceGenerator(name="UserSeq",sequenceName="USERID_SEQ", allocationSize=1)
	private int id;
	
	private String username;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	@Column(name="USER_TYPE")
	private String usertype;
	
	private String password;
	
	@Transient
	private GrantedAuthority[] grantedAuthorities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserType() {
		return usertype;
	}

	public void setUserType(String usertype) {
		this.usertype = usertype;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		if(this.getUsername()!=null && password!=null)
		{
			DESEDE encodepwd=new DESEDE(this.getUsername());
			this.password = encodepwd.encrypt(password);
		
		}
	}
	
	public Collection<GrantedAuthority> getAuthorities() {
		
		ArrayList authorities = new ArrayList();
		// Any Authorized User gets the authority ROLE_USER
		GrantedAuthorityImpl authority = new GrantedAuthorityImpl(ROLE_USER);
		authorities.add(authority);

		// Admin or User?
		if(this.getUserType().equals("Admin" )) {
		    GrantedAuthorityImpl adminAuthority = new GrantedAuthorityImpl(ROLE_ADMIN);
		    authorities.add(adminAuthority);
		}
		
		
		return authorities;

	}

	public boolean hasRole(String role) {
		Collection<GrantedAuthority> authorities = this.getAuthorities();
		for(GrantedAuthority authority : authorities) {
			if(authority.getAuthority().equals(role)) {
				return true;
			}
		}
		return false;
	}

	public boolean isAccountNonExpired() {
		return true;
	    }

	public boolean isAccountNonLocked() {
		return true;
	    }

	
	public boolean isCredentialsNonExpired() {
		return true;
	    }

	public boolean isEnabled() {
		return true;
	    }
	
	public String getDecryptPassword() {
    	String password = getPassword();
    	String username = getUsername();
    	if (password != null && username != null) {
    		DESEDE desede = new DESEDE(username);
    		password = desede.decrypt(password);
    		return password;
    	}
    	
    	return null;
    }
	
}

