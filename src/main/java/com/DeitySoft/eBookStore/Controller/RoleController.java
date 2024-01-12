/**
 * 
 */
package com.DeitySoft.eBookStore.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeitySoft.eBookStore.Entity.Role;
import com.DeitySoft.eBookStore.Service.roleService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author pawan
 *
 */
@RestController
@RequestMapping("/role")
public class RoleController {
private roleService roleServ;

public RoleController(roleService roleServ) {
	super();
	this.roleServ = roleServ;
}


@GetMapping("/")
public List<Role> getAllRole() {
    return roleServ.getAllRole();
}
@PostMapping("/add/")
public List<Role> saveRole(@RequestBody Role role){
	roleServ.saveRole(role);
	return roleServ.getAllRole();
}
@PostMapping("/update/")
public Role updateRole(@RequestBody Role role) {
	return roleServ.updateRole(role);
}
@PostMapping("/delete/")
public void deleteRole(@RequestBody Long id) {
	roleServ.deleteRoleById(id);
}

}
