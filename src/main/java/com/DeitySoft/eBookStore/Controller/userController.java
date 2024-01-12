/**
 * 
 */
package com.DeitySoft.eBookStore.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeitySoft.eBookStore.Entity.userEntity;
import com.DeitySoft.eBookStore.Service.userService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author pawan
 *
 */
@RestController
@RequestMapping("/user")
public class userController {
	private userService userServ;
	
 public userController(userService userServ) {
		super();
		this.userServ = userServ;
	}
 @GetMapping("/")
 public List<userEntity> getAll(userEntity User){
	 return userServ.getAllUser();
 }
@PostMapping("/add")
 public List<userEntity> saveUser(@RequestBody userEntity User) {
      userServ.saveUser(User);
     return userServ.getAllUser();
 }	
@PostMapping("/update")
public List<userEntity> updateUser(@RequestBody userEntity User) {
	 userServ.updateUser(User);
	 return userServ.getAllUser();
}
@PostMapping("/delete")
public List<userEntity> deleteUser(@RequestBody Long id) {
	 userServ.deleteUserByID(id);
	 return userServ.getAllUser();
}
}
