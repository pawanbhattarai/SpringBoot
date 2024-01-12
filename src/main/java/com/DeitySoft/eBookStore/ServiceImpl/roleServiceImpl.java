/**
 * 
 */
package com.DeitySoft.eBookStore.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DeitySoft.eBookStore.Entity.Role;
import com.DeitySoft.eBookStore.Repository.roleRepository;
import com.DeitySoft.eBookStore.Service.roleService;

/**
 * @author pawan
 *
 */
@Service
public class roleServiceImpl implements roleService {
	private roleRepository roleRepo;

	public roleServiceImpl(roleRepository roleRepo) {
		super();
		this.roleRepo = roleRepo;
	}
	
	@Override
	public List<Role> getAllRole(){
		return roleRepo.findAll();
	}
	@Override
	public Role saveRole(Role role) {
		return roleRepo.save(role);
	}
	@Override
	public Role updateRole(Role role) {
		return roleRepo.save(role);
	}
	@Override
	public void deleteRoleById(Long id) {
		 roleRepo.deleteById(id);
	}

}
