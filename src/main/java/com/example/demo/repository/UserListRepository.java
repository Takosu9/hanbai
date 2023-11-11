package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserList;

@Repository
public interface UserListRepository  extends JpaRepository<UserList,String>{

	List<UserList> findByUseridAndPass(String userid,String pass);
}
