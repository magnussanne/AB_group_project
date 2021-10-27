package com.ab.repositories;

import com.ab.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	@Query("SELECT u from Users u WHERE u.username =:uName and u.password =:password")
	public Users loginCheck(@Param("uName") String username, @Param("password") String password);

	@Query("SELECT u FROM Users u WHERE u.username = :uName")
	public Users getUserByUsername(@Param("uName") String username);
}