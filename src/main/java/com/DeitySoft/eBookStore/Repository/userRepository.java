/**
 * 
 */
package com.DeitySoft.eBookStore.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.DeitySoft.eBookStore.Entity.userEntity;

/**
 * @author pawan
 *
 */
public interface userRepository extends JpaRepository<userEntity,Long>{

}
