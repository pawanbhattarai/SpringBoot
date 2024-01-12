/**
 * 
 */
package com.DeitySoft.eBookStore.Service;

import java.util.List;

import com.DeitySoft.eBookStore.Entity.userEntity;

/**
 * @author pawan
 *
 */
public interface userService {

	List<userEntity> getAllUser();

	userEntity saveUser(userEntity User);

	userEntity updateUser(userEntity User);

	void deleteUserByID(Long id);

}
