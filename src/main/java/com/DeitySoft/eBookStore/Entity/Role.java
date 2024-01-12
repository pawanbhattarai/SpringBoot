/**
 * 
 */
package com.DeitySoft.eBookStore.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

/**
 * @author pawan
 *
 */
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String role_type;
	 @ManyToMany(mappedBy="roles")
	    private List<userEntity> users;
	public Role() {
		
	}
	public Role(String role_type) {
		super();
		this.role_type = role_type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	
	
}
