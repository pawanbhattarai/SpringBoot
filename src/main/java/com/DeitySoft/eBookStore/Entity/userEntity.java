/**
 * 
 */
package com.DeitySoft.eBookStore.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pawan
 *
 */
@Entity
public class userEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String email;
	 @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	    @JoinTable(
	            name="users_roles",
	            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
	            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	    private List<Role> roles = new ArrayList<>();
	public userEntity() {
		
	}
	public userEntity(String username, String password, String email, List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	
}
