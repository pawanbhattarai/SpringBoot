/**
 * 
 */
package com.DeitySoft.eBookStore.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DeitySoft.eBookStore.Entity.userEntity;
import com.DeitySoft.eBookStore.Repository.userRepository;
import com.DeitySoft.eBookStore.Service.userService;

/**
 * @author pawan
 *
 */
@Service
public class userServiceImpl implements userService {
	private userRepository userRepo;

	public userServiceImpl(userRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	@Override
	public List<userEntity> getAllUser(){
		return userRepo.findAll();
	}
	@Override
	public userEntity saveUser(userEntity User) {
		return userRepo.save(User);
	}
	@Override
	public userEntity updateUser(userEntity User) {
		return userRepo.save(User);
	}
	@Override
	public void deleteUserByID(Long id) {
		userRepo.deleteById(id);
	}
	
}
