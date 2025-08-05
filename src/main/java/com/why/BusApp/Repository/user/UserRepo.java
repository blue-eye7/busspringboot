package com.why.BusApp.Repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.why.BusApp.Entity.User.User;
import com.why.BusApp.Service.User.UserService;
@Repository
public interface UserRepo extends JpaRepository<User,Long>{

	boolean existsByMobile(long mobile);

	boolean existsByEmail(String email);

	User findByMobile(long mobile);

	User findByEmail(String email);

}
