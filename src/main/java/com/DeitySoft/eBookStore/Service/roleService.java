/**
 * 
 */
package com.DeitySoft.eBookStore.Service;

import java.util.List;

import com.DeitySoft.eBookStore.Entity.Role;

/**
 * @author pawan
 *
 */
public interface roleService {

	List<Role> getAllRole();

	Role saveRole(Role role);

	void deleteRoleById(Long id);

	Role updateRole(Role role);


}
